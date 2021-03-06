package scraper.analyzer;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 *
 * {@link scraper.analyzer.CharsAnalyzer}
 * count all chars of parsed text for all web pages
 */
public interface CharsAnalyzer extends Analyzer {

    Long charsAnalyze();
}
