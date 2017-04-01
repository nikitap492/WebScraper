package scraper.exceptions;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public class URLParseException extends RuntimeException {

    public URLParseException() {
        super("Error has occured during parse process");
    }

    public URLParseException(Throwable cause) {
        super(cause);
    }

    public URLParseException(String message) {
        super(message);
    }
}
