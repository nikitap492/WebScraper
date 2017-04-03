package scraper.analyzer;

import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 *
 * {@link scraper.analyzer.WordAnalyzer}
 * counts quantity of found word for each from {@code List<String> words}
 */
public interface WordAnalyzer extends Analyzer {

    /**
     * For each from
     * @param words
     * will be printed quantity
     */
    void wordsAnalyze(List<String> words);
}
