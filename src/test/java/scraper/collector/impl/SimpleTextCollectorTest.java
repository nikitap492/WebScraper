package scraper.collector.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import scraper.domain.WebPage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public class SimpleTextCollectorTest {

    private static List<WebPage> webPages;
    private static String t1 = "Hello, World";
    private static String t2 = "This is";
    private static String t3 = "just";
    private static String t4 = "test sentences";

    @BeforeClass
    public static void init(){

        List<String> firstText = new ArrayList<>();
        firstText.add(t1);
        firstText.add(t2);
        List<String> secondText = new ArrayList<>();
        secondText.add(t3);
        secondText.add(t4);
        WebPage first = new WebPage(firstText);
        WebPage second = new WebPage(secondText);
        webPages = new ArrayList<>();
        webPages.add(first);
        webPages.add(second);
    }

    @Test
    public void shouldCollect(){
        SimpleTextCollector textCollector = new SimpleTextCollector();
        List<String> collect = textCollector.collect(webPages);
        assertEquals(t1, collect.get(0));
        assertEquals(t2, collect.get(1));
        assertEquals(t3, collect.get(2));
        assertEquals(t4, collect.get(3));
    }

}