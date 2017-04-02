package scraper.collector.impl;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public class SimpleWordCollectorTest {

    @Test
    public void shouldCollect(){
        SimpleWordCollector collector = new SimpleWordCollector();
        List<String> list = new ArrayList<>();
        String t1 = "first";
        String t2 = "second";
        list.add(t1 + " " + t2);
        String t3 = "third";
        list.add(t3);
        String t4 = "fourth";
        String t5 = "fifth";
        String t6 = "sixth";
        list.add(t4 + " " + t5  +  " " + t6);
        String t7 = "seventh";
        list.add(t7);
        List<String> result = collector.collect(list);
        assertEquals(t1.toUpperCase(), result.get(0));
        assertEquals(t2.toUpperCase(), result.get(1));
        assertEquals(t3.toUpperCase(), result.get(2));
        assertEquals(t4.toUpperCase(), result.get(3));
        assertEquals(t5.toUpperCase(), result.get(4));
        assertEquals(t6.toUpperCase(), result.get(5));
        assertEquals(t7.toUpperCase(), result.get(6));

    }

}