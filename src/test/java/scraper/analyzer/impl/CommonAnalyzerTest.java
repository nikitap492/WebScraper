package scraper.analyzer.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import scraper.collector.impl.SimpleWordCollector;
import scraper.logger.LoggerFactory;
import scraper.logger.LoggerFactoryTest;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public class CommonAnalyzerTest {

    private String hello = "Hello, ";
    private String world = "World!";
    private String there = "There ";
    private String is = "is ";
    private String just = "just ";
    private String forTest = "for test.";

    private ArrayList<String> sentences = new ArrayList<>();{
        sentences.add(hello + world);
        sentences.add(there + is + just + forTest);
    }

    private CommonAnalyzer commonAnalyzer = new CommonAnalyzer(new SimpleWordCollector());{
        commonAnalyzer.data(sentences);
    }

    private static LoggerFactoryTest.MockPrintStream mockPrintStream
            = new LoggerFactoryTest.MockPrintStream(System.out);

    @BeforeClass
    public static void setupPrintStream(){
        LoggerFactory.setPrintStream(mockPrintStream);
    }

    @Test
    public void testSentencesAnalyzer(){
        commonAnalyzer.sentencesAnalyze(Stream.of("test")
                .collect(Collectors.toList()));
        assertEquals(there + is + just + forTest, mockPrintStream
                                                    .getLastString()
                                                    .substring(mockPrintStream.getLastString().lastIndexOf(": ") + 2));

        commonAnalyzer.sentencesAnalyze(Stream.of("world")
                .collect(Collectors.toList()));
        assertEquals(hello + world, mockPrintStream
                .getLastString()
                .substring(mockPrintStream.getLastString().lastIndexOf(": ") + 2));
    }

    @Test
    public void testCharsAnalyzer(){
        commonAnalyzer.charsAnalyze();
        String all = (hello + world + there + is + just + forTest);
        assertEquals("" + all.length(), mockPrintStream.getLastString().substring(
                mockPrintStream.getLastString().lastIndexOf("equals") +  "equals ".length()));
    }

    @Test
    public void testWordsAnalyze(){
        commonAnalyzer.wordsAnalyze(Stream.of("test")
                                        .collect(Collectors.toList()));
        int extractTimes = Integer.valueOf(mockPrintStream.getLastString().substring(
                mockPrintStream.getLastString().lastIndexOf("sources ") +  "sources ".length(),
                mockPrintStream.getLastString().indexOf(" times")));
        assertEquals(1, extractTimes);
    }


}