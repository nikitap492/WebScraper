package scraper.engine.impl;

import scraper.analyzer.CharsAnalyzer;
import scraper.analyzer.SentencesAnalyzer;
import scraper.analyzer.WordAnalyzer;
import scraper.collector.TextCollector;
import scraper.collector.WebPagesCollector;
import scraper.config.ApplicationPropertiesConfiguration;
import scraper.domain.ConsoleParseData;
import scraper.domain.ParseEntity;
import scraper.domain.WebPage;
import scraper.domain.WebPageText;
import scraper.engine.Engine;
import scraper.logger.Logger;
import scraper.logger.LoggerFactory;
import scraper.parser.ConsoleParser;
import scraper.parser.TextParser;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static scraper.domain.Property.*;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public class WebScraperEngine implements Engine{

    private static final Logger log = LoggerFactory.obtain(WebScraperEngine.class);

    private List<String> words;
    private ConsoleParser  consoleParser;
    private WebPagesCollector webPagesCollector;
    private TextCollector textCollector;
    private TextParser textParser;
    private SentencesAnalyzer sentencesAnalyzer;
    private CharsAnalyzer charsAnalyzer;
    private WordAnalyzer wordAnalyzer;
    private long start;

    /**
     * {@inheritDoc}
     */
    @Override
    public void run(String[] args) {
        //formatter:off
        analyze(
                parse(
                        text(
                                webPages(
                                        console(args)))));
        //formatter:on
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParseEntity<ConsoleParseData> console(String[] args) {
        ParseEntity<ConsoleParseData> parse = consoleParser.parse(Arrays
                .stream(args)
                .collect(Collectors.toList()));
        this.words = parse.getEntity().getWords();
        return parse;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<WebPage> webPages(ParseEntity<ConsoleParseData> consoleResult) {
        long start = System.nanoTime();
        List<WebPage> webPages = webPagesCollector.collect(consoleResult
                .getEntity()
                .getUrls());
        long end = System.nanoTime();
        log.debug( "Time of web information collection: " + new DecimalFormat("#.###").format(((double) end - start) /1_000_000_000)   + "s");
        return webPages;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> text(Collection<WebPage> webPages) {
        start = System.nanoTime();
        return textCollector.collect(webPages);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParseEntity<WebPageText> parse(List<String> text) {
        return textParser.parse(text);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void analyze(ParseEntity<WebPageText> parseEntity) {
        setData(parseEntity
                .getEntity()
                .getText());

        if (ApplicationPropertiesConfiguration.configuration().getValue(SENTENCES)) {
            sentencesAnalyzer.sentencesAnalyze(words);
        }

        if (ApplicationPropertiesConfiguration.configuration().getValue(CHARS_NUMBER)) {
            charsAnalyzer.charsAnalyze();
        }

        if (ApplicationPropertiesConfiguration.configuration().getValue(WORDS_NUMBER)) {
            wordAnalyzer.wordsAnalyze(words);
        }

        long end = System.nanoTime();
        log.debug( "Time of full analyze: " + new DecimalFormat("#.###").format(((double) end - start) / 1_000_000_000)  + "s");

    }

    /**
     * @param data
     * Data setter
     */
    private void setData(List<String> data){
        sentencesAnalyzer.data(data);
        charsAnalyzer.data(data);
        wordAnalyzer.data(data);
    }

    WebScraperEngine(){

    }

    /**
     * setters
     */

    void setConsoleParser(ConsoleParser consoleParser) {
        this.consoleParser = consoleParser;
    }

    void setWebPagesCollector(WebPagesCollector webPagesCollector) {
        this.webPagesCollector = webPagesCollector;
    }

    void setTextCollector(TextCollector textCollector) {
        this.textCollector = textCollector;
    }

    void setTextParser(TextParser textParser) {
        this.textParser = textParser;
    }

    void setSentencesAnalyzer(SentencesAnalyzer sentencesAnalyzer) {
        this.sentencesAnalyzer = sentencesAnalyzer;
    }

    void setCharsAnalyzer(CharsAnalyzer charsAnalyzer) {
        this.charsAnalyzer = charsAnalyzer;
    }

    void setWordAnalyzer(WordAnalyzer wordAnalyzer) {
        this.wordAnalyzer = wordAnalyzer;
    }
}
