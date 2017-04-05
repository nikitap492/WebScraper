package scraper.exceptions;

/**
 * @author Poshivalov Nikita
 * @since 05.04.2017.
 */
public class AnalyzeWasNotEnable extends RuntimeException {

    public AnalyzeWasNotEnable() {
        super("Analyze was not enable in your configuration");
    }
}
