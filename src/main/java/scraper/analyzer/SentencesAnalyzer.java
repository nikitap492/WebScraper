package scraper.analyzer;

import java.util.List;
import java.util.Map;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 *
 * {@link scraper.analyzer.SentencesAnalyzer}
 * Print all sentences of parsed text for all webpages
 */
public interface SentencesAnalyzer extends Analyzer {


    /**
     * @param searchableWord is words for which will be printed sentences
     */
    Map<String, List<String>> sentencesAnalyze(List<String> searchableWord);
}
