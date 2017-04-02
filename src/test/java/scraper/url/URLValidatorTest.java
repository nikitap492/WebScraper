package scraper.url;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public class URLValidatorTest {

    @Test
    public void shouldReturnFalseForStr(){
        assertFalse(URLValidator.validate("null"));
    }

    @Test
    public void shouldReturnFalseForList(){
        ArrayList<String> urls = new ArrayList<>();
        urls.add("null");
        assertFalse(URLValidator.validate(urls));
    }

    @Test
    public void shouldReturnTrueForList(){
        ArrayList<String> urls = new ArrayList<>();
        urls.add("http://www.google.com");
        assertTrue(URLValidator.validate(urls));
    }

    @Test
    public void shouldReturnTrueForStr(){
        assertTrue(URLValidator.validate("http://www.google.com"));
    }

}