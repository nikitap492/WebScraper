package scraper.parser.impl;

import org.junit.Before;
import org.junit.Test;
import scraper.config.Configuration;
import scraper.domain.ConsoleParseData;
import scraper.domain.Property;
import scraper.exceptions.InputWasNotFoundException;
import scraper.exceptions.MissingWordsException;
import scraper.exceptions.UnknownOptionWasFoundException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 */
public class DefaultConsoleParserTest {

    private List<String> options;
    private DefaultConsoleParser parser = new DefaultConsoleParser();

    @Before
    public void init(){
        options = new ArrayList<>();
        options.add("http://www.google.com");
        options.add("Test,Word");
        options.add("-e");
        options.add("-w");
        options.add("-c");
    }


    @Test
    public void correctParse() throws Exception {
        ConsoleParseData dataParseEntity = parser.parse(options);
        Configuration configuration = dataParseEntity.getConfiguration();
        assertTrue(Boolean.valueOf(configuration.getValue(Property.SENTENCES.name())));
        assertTrue(Boolean.valueOf(configuration.getValue(Property.CHARS.name())));
        assertTrue(Boolean.valueOf(configuration.getValue(Property.WORDS.name())));
        List<String> words = dataParseEntity.getWords();
        assertEquals("TEST", words.get(0));
        assertEquals("WORD", words.get(1));
        assertTrue(words.size() == 2);
        List<URL> urls = dataParseEntity.getUrls();
        assertTrue(urls.size() == 1);
        assertEquals(options.get(0), urls.get(0).toString());
    }

    @Test(expected = MissingWordsException.class)
    public void exceptedMissingWordException(){
        options.remove(1);
        parser.parse(options);
    }

    @Test(expected = UnknownOptionWasFoundException.class)
    public void exceptedUnknownOptionWasFoundException(){
        options.add("-r");
        parser.parse(options);
    }

    @Test(expected = InputWasNotFoundException.class)
    public void exceptedInputWasNotFoundException(){
        options.clear();
        parser.parse(options);
    }



}