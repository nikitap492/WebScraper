package scraper.engine.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import scraper.analyzer.CharsAnalyzer;
import scraper.analyzer.SentencesAnalyzer;
import scraper.analyzer.WordAnalyzer;
import scraper.collector.TextCollector;
import scraper.collector.WebPagesCollector;
import scraper.config.ApplicationPropertiesConfiguration;
import scraper.config.Configuration;
import scraper.domain.Property;
import scraper.parser.TextParser;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


/**
 * @author Poshivalov Nikita
 * @since 02.04.17.
 */
public class EngineTests {

    private static WebScraperEngine scraperEngine;
    private static TextCollector textCollector = mock(TextCollector.class);
    private static WordAnalyzer wordAnalyzer = mock(WordAnalyzer.class);
    private static CharsAnalyzer charsAnalyzer = mock(CharsAnalyzer.class);
    private static SentencesAnalyzer sentencesAnalyzer = mock(SentencesAnalyzer.class);
    private static TextParser textParser = mock(TextParser.class);
    private static WebPagesCollector webPagesCollector = mock(WebPagesCollector.class);

    @BeforeClass
    public static void createMock(){






        Configuration configuration = mock(ApplicationPropertiesConfiguration.class);
        when(configuration.getValue(Property.SENTENCES.name())).thenReturn("true");
        when(configuration.getValue(Property.WORDS.name())).thenReturn("true");
        when(configuration.getValue(Property.CHARS.name())).thenReturn("true");

        scraperEngine = (WebScraperEngine) EngineConfigurator
                .configure(configuration)
                .webPagesCollector(webPagesCollector)
                .textParser(textParser)
                .textCollector(textCollector)
                .wordAnalyzer(wordAnalyzer)
                .charsAnalyzer(charsAnalyzer)
                .sentencesAnalyzer(sentencesAnalyzer)
                .accept();
    }

    @Test
    public void run(){

        scraperEngine.run(new ArrayList<>());
        verify(textParser).parse(new ArrayList<>());
        verify(textCollector).collect(new ArrayList<>());
        verify(webPagesCollector).collect(new ArrayList<>());
        verify(textCollector, times(1)).collect(new ArrayList<>());
        verify(wordAnalyzer, times(1)).wordsAnalyze(null);
        verify(charsAnalyzer, times(1)).charsAnalyze();


    }






}