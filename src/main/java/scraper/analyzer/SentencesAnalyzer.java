package scraper.analyzer;

import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public interface SentencesAnalyzer extends Analyzer {

    void sentencesAnalyze(List<String> searchableWord);
}
