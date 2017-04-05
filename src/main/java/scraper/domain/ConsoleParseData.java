package scraper.domain;

import scraper.config.Configuration;

import java.net.URL;
import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 31.03.17.
 *
 * Console parse entity is used to {@link scraper.parser.ConsoleParser}
 */
public class ConsoleParseData  {

    private List<URL> urls;
    private List<String> words;
    private Configuration configuration;

    public ConsoleParseData(List<URL> urls, List<String> words, Configuration configuration) {
        this.urls = urls;
        this.words = words;
        this.configuration = configuration;
    }

    public List<URL> getUrls() {
        return urls;
    }

    public List<String> getWords() {
        return words;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
