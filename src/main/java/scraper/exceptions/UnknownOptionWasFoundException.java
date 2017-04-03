package scraper.exceptions;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 *
 * Then {@link scraper.parser.ConsoleParser} cannot determinate option {@link scraper.domain.Property}
 */
public class UnknownOptionWasFoundException extends RuntimeException {

    public UnknownOptionWasFoundException(String option) {
        super("Unknown option : " + option);
    }
}
