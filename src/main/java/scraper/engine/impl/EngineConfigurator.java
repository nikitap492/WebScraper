package scraper.engine.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scraper.analyzer.CharsAnalyzer;
import scraper.analyzer.SentencesAnalyzer;
import scraper.analyzer.WordAnalyzer;
import scraper.analyzer.impl.CommonAnalyzer;
import scraper.collector.TextCollector;
import scraper.collector.WebPagesCollector;
import scraper.collector.impl.DefaultWebPagesCollector;
import scraper.collector.impl.SimpleTextCollector;
import scraper.collector.impl.SimpleWordCollector;
import scraper.config.Configuration;
import scraper.engine.Engine;
import scraper.parser.TextParser;
import scraper.parser.impl.SimpleTextParser;

import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 *
 * Configurator for
 * {@link Engine}.
 * Use pattern builder
 * return {@link WebScraperEngine}
 */
public class EngineConfigurator {

    private static final Logger log = LoggerFactory.getLogger(EngineConfigurator.class);
    private final WebScraperEngine engine;

    public static EngineConfigurator configure(Configuration configuration){
        return new EngineConfigurator(configuration);
    }

    public EngineConfigurator(Configuration configuration) {
        this.engine = new WebScraperEngine(configuration);
    }

    public EngineConfigurator webPagesCollector(WebPagesCollector webPagesCollector){
        engine.setWebPagesCollector(webPagesCollector);
        return this;
    }

    public EngineConfigurator textParser(TextParser textParser){
        engine.setTextParser(textParser);
        return this;
    }

    public EngineConfigurator textCollector(TextCollector textCollector){
        engine.setTextCollector(textCollector);
        return this;
    }

    public EngineConfigurator sentencesAnalyzer(SentencesAnalyzer sentencesAnalyzer){
        engine.setSentencesAnalyzer(sentencesAnalyzer);
        return this;
    }

    public EngineConfigurator charsAnalyzer(CharsAnalyzer charsAnalyzer){
        engine.setCharsAnalyzer(charsAnalyzer);
        return this;
    }

    public EngineConfigurator wordAnalyzer(WordAnalyzer wordAnalyzer){
        engine.setWordAnalyzer(wordAnalyzer);
        return this;
    }

    public Engine accept(){
        log.info("WebScraper setup manual configuration");
        return engine;
    }

    /**
     * Setup default engine configuration
     */
    public Engine useDefaultComponents(){
        CommonAnalyzer commonAnalyzer = new CommonAnalyzer(new SimpleWordCollector());
        wordAnalyzer(commonAnalyzer);
        charsAnalyzer(commonAnalyzer);
        sentencesAnalyzer(commonAnalyzer);
        textCollector(new SimpleTextCollector());
        webPagesCollector(new DefaultWebPagesCollector());
        textParser(new SimpleTextParser());
        log.info("WebScraper setup default component");
        return engine;
    }


    public EngineConfigurator search(List<String> words) {
        engine.setSearchableWords(words);
        return this;
    }
}
