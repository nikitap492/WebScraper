package scraper.domain;

import java.net.URL;
import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 31.03.17.
 *
 * Console parse entity is used to {@link scraper.parser.ConsoleParser}
 * implements marker interface {@link Parsable}
 */
public class ConsoleParseData implements Parsable {

    private List<URL> urls;
    private List<String> words;

    public ConsoleParseData(List<URL> urls, List<String> words) {
        this.urls = urls;
        this.words = words;
    }

    public List<URL> getUrls() {
        return urls;
    }

    public List<String> getWords() {
        return words;
    }
}
