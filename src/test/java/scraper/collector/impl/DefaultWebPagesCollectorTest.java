package scraper.collector.impl;

import org.junit.Test;
import scraper.exceptions.CollectorProcessException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public class DefaultWebPagesCollectorTest {


    @Test(expected = CollectorProcessException.class)
    public void shouldTrowException() throws MalformedURLException {
        List<URL> urls = new ArrayList<>();
        URL url = new URL("http://error");
        urls.add(url);
        new DefaultWebPagesCollector().collect(urls);
    }



}