package scraper.exceptions;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 */
public class UnknownOptionWasFoundException extends RuntimeException {

    public UnknownOptionWasFoundException(String option) {
        super("Unknown option : " + option);
    }
}
