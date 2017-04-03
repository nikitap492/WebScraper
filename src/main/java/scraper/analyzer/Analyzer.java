package scraper.analyzer;

import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 *
 * Central interface of data analyze
 * {@code void data(List<String> words)} set data that will be analyzed
 */
public interface Analyzer {

    void data(List<String> words);
}
