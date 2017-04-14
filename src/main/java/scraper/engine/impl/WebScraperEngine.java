package scraper.engine.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scraper.analyzer.CharsAnalyzer;
import scraper.analyzer.SentencesAnalyzer;
import scraper.analyzer.WordAnalyzer;
import scraper.collector.TextCollector;
import scraper.collector.WebPagesCollector;
import scraper.config.Configuration;
import scraper.domain.EngineAnalyze;
import scraper.domain.WebPage;
import scraper.domain.WebScraperEngineAnalyze;
import scraper.engine.Engine;
import scraper.parser.TextParser;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;

import static scraper.domain.Property.*;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
class WebScraperEngine implements Engine {

    private static final Logger log = LoggerFactory.getLogger(WebScraperEngine.class);
    private final Configuration configuration;

    private WebPagesCollector webPagesCollector;
    private TextCollector textCollector;
    private TextParser textParser;
    private SentencesAnalyzer sentencesAnalyzer;
    private CharsAnalyzer charsAnalyzer;
    private WordAnalyzer wordAnalyzer;
    private List<String> searchableWords;
    private WebScraperEngineAnalyze analyzeResult = new WebScraperEngineAnalyze();

    /**
     * {@inheritDoc}
     */
    @Override
    public EngineAnalyze run(Collection<URL> sources) {
        long start = System.nanoTime();
        List<WebPage> webPages = webPagesCollector.collect(sources);
        long end = System.nanoTime();
        log.debug("Time of web information collection: " + new DecimalFormat("#.###").format(((double) end - start) / 1_000_000_000) + "s");
        start = System.nanoTime();
        List<String> text = textParser.parse(textCollector.collect(webPages));

        setData(text);

        if (configuration.hasProperty(SENTENCES.name()) && configuration.getValue(SENTENCES.name()).equals("true")) {
            analyzeResult.setSentences(sentencesAnalyzer.sentencesAnalyze(searchableWords));
        }

        if (configuration.hasProperty(CHARS.name()) && configuration.getValue(CHARS.name()).equals("true")) {
            analyzeResult.setChars(charsAnalyzer.charsAnalyze());
        }

        if (configuration.hasProperty(WORDS.name()) && configuration.getValue(WORDS.name()).equals("true")) {
            analyzeResult.setWords(wordAnalyzer.wordsAnalyze(searchableWords));
        }

        end = System.nanoTime();
        log.debug("Time of full analyze: " + new DecimalFormat("#.###").format(((double) end - start) / 1_000_000_000) + "s");
        return analyzeResult;
    }

    /**
     * @param data Data setter
     */
    private void setData(List<String> data) {
        sentencesAnalyzer.data(data);
        charsAnalyzer.data(data);
        wordAnalyzer.data(data);
    }

    WebScraperEngine(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * setters
     */

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

    void setSearchableWords(List<String> searchableWords) {
        this.searchableWords = searchableWords;
    }
}
