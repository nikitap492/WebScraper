package scraper.exceptions;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 *
 * Then error occurs during collection process
 */
public class CollectorProcessException extends RuntimeException {
    public CollectorProcessException(Throwable cause) {
        super(cause);
    }
}
