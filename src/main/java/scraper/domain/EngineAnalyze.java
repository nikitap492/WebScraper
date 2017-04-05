package scraper.domain;

import java.util.List;
import java.util.Map;

/**
 * @author Poshivalov Nikita
 * @since 05.04.2017.
 *
 * Engine analyze entity
 * Return all analyze component by default. But if analyze is not enable
 * throws {@link scraper.exceptions.AnalyzeWasNotEnable}
 */
public interface EngineAnalyze {

    /**
     * @return result of analyze of {@link scraper.analyzer.CharsAnalyzer}
     */
    Long chars();

    /**
     * @return result of analyze of {@link scraper.analyzer.WordAnalyzer}
     */
    Map<String, Long> words();

    /**
     * @return result of analyze of {@link scraper.analyzer.SentencesAnalyzer}
     */
    Map<String, List<String>> sentences();

}
