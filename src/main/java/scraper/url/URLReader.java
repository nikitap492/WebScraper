package scraper.url;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public interface URLReader {

    void addURL(List<URL> urls , String url) throws MalformedURLException;

}
