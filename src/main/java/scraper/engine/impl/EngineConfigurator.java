package scraper.engine.impl;

import scraper.analyzer.CharsAnalyzer;
import scraper.analyzer.SentencesAnalyzer;
import scraper.analyzer.WordAnalyzer;
import scraper.analyzer.impl.CommonAnalyzer;
import scraper.collector.TextCollector;
import scraper.collector.WebPagesCollector;
import scraper.collector.impl.DefaultWebPagesCollector;
import scraper.collector.impl.SimpleTextCollector;
import scraper.collector.impl.SimpleWordCollector;
import scraper.engine.Engine;
import scraper.logger.Logger;
import scraper.logger.LoggerFactory;
import scraper.parser.ConsoleParser;
import scraper.parser.TextParser;
import scraper.parser.impl.DefaultConsoleParser;
import scraper.parser.impl.SimpleTextParser;

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

    private static final Logger log = LoggerFactory.obtain(EngineConfigurator.class);

    public static EngineConfigurator configure(){
        return new EngineConfigurator();
    }

    private WebScraperEngine engine = new WebScraperEngine();

    public EngineConfigurator consoleParser(ConsoleParser parser){
        engine.setConsoleParser(parser);
        return this;
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
    public Engine defaultConfiguration(){
        CommonAnalyzer commonAnalyzer = new CommonAnalyzer(new SimpleWordCollector());
        wordAnalyzer(commonAnalyzer);
        charsAnalyzer(commonAnalyzer);
        sentencesAnalyzer(commonAnalyzer);
        textCollector(new SimpleTextCollector());
        webPagesCollector(new DefaultWebPagesCollector());
        consoleParser(new DefaultConsoleParser());
        textParser(new SimpleTextParser());
        log.info("WebScraper setup default configuration");
        return engine;
    }

}
