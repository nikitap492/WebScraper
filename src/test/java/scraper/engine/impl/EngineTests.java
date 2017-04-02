package scraper.engine.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import scraper.analyzer.CharsAnalyzer;
import scraper.analyzer.SentencesAnalyzer;
import scraper.analyzer.WordAnalyzer;
import scraper.collector.TextCollector;
import scraper.collector.WebPagesCollector;
import scraper.domain.ConsoleParseData;
import scraper.domain.ParseEntity;
import scraper.domain.WebPageText;
import scraper.parser.ConsoleParser;
import scraper.parser.TextParser;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

/**
 * @author Poshivalov Nikita
 * @since 02.04.17.
 */
public class EngineTests {



    private static WebScraperEngine scraperEngine;
    private static ArrayList<String> args = new ArrayList<>();
    private static ParseEntity<ConsoleParseData> consoleParseData
            = ParseEntity.body(new ConsoleParseData(new ArrayList<>(), new ArrayList<>()));

    private static ParseEntity<WebPageText> webPageTextParseEntity
            = ParseEntity.body(new WebPageText(new ArrayList<>()));

    @BeforeClass
    public static void createMock(){

        ConsoleParser consoleParser = mock(ConsoleParser.class);
        when(consoleParser.parse(args)).thenReturn(consoleParseData);

        WebPagesCollector webPagesCollector = mock(WebPagesCollector.class);
        TextParser textParser = mock(TextParser.class);
        when(textParser.parse(new ArrayList<>())).thenReturn(webPageTextParseEntity);

        TextCollector textCollector = mock(TextCollector.class);
        WordAnalyzer wordAnalyzer = mock(WordAnalyzer.class);
        CharsAnalyzer charsAnalyzer = mock(CharsAnalyzer.class);
        SentencesAnalyzer sentencesAnalyzer = mock(SentencesAnalyzer.class);

        scraperEngine = spy((WebScraperEngine) EngineConfigurator
                .configure()
                .consoleParser(consoleParser)
                .webPagesCollector(webPagesCollector)
                .textParser(textParser)
                .textCollector(textCollector)
                .wordAnalyzer(wordAnalyzer)
                .charsAnalyzer(charsAnalyzer)
                .sentencesAnalyzer(sentencesAnalyzer)
                .accept());
    }

    @Test
    public void run(){
        String[] strs = new String[]{};
        scraperEngine.run(strs);
        verify(scraperEngine, times(1)).console(strs);
        verify(scraperEngine, times(1)).webPages(consoleParseData);
        verify(scraperEngine, times(1)).text(new ArrayList<>());
        verify(scraperEngine, times(1)).parse(new ArrayList<>());
        verify(scraperEngine, times(1)).analyze(webPageTextParseEntity);
    }




}