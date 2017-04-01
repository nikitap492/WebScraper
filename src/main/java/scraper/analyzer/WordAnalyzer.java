package scraper.analyzer;

import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public interface WordAnalyzer extends Analyzer {

    void wordsAnalyze(List<String> words);
}
