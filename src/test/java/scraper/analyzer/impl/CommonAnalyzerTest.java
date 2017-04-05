package scraper.analyzer.impl;

import org.junit.Test;
import scraper.collector.impl.SimpleWordCollector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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


    @Test
    public void testSentencesAnalyzer(){
        Map<String, List<String>> test = commonAnalyzer.sentencesAnalyze(Stream.of("test").collect(Collectors.toList()));
        assertEquals(there+ is + just + forTest, test.get("test").get(0));
        assertTrue(test.get("test").size() == 1);

    }

    @Test
    public void testCharsAnalyzer(){
        String all = (hello + world + there + is + just + forTest);
        assertEquals((long) all.length() , commonAnalyzer.charsAnalyze().longValue());
    }

    @Test
    public void testWordsAnalyze(){
        Map<String, Long> test = commonAnalyzer.wordsAnalyze(Stream.of("test", "is")
                .collect(Collectors.toList()));
        assertEquals(Long.valueOf(1), test.get("test"));
        assertEquals(Long.valueOf(1), test.get("is"));
    }


}