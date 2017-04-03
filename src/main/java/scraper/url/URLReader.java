package scraper.url;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 *
 * Trying create connection and put it to
 * {@code List<URL>}
 */
public interface URLReader {

    /**
     *
     * @param urls is container
     * @param url is source
     * @throws MalformedURLException if URL iss incorrect
     */
    void addURL(List<URL> urls , String url) throws MalformedURLException;

}
