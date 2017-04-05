package scraper.parser.impl;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public class SimpleTextParserTest {

    @Test
    public void shouldParse() throws Exception {
        SimpleTextParser parser = new SimpleTextParser();
        String str = "test";
        List<String> text = new ArrayList<>();
        text.add("<div>" + str + 1 + "</div>");
        text.add("<div>" + str + 2 + "<p>"  +str + 3 + "</p>" + "</div>");
        text.add("<div>" + "<p>" + str + 4 + "</p>" + "</div>");
        List<String> result = parser.parse(text);
        assertEquals(str + 1, result.get(0));
        assertEquals(str + 2 , result.get(1));
        assertEquals(str + 3, result.get(2));
        assertEquals(str + 4, result.get(3));
    }

}