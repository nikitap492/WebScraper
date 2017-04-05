package scraper.analyzer;

import java.util.List;
import java.util.Map;

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
    Map<String, Long> wordsAnalyze(List<String> words);
}
