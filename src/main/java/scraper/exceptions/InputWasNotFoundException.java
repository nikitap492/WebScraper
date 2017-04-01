package scraper.exceptions;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 */
public class InputWasNotFoundException extends RuntimeException {

    public InputWasNotFoundException() {
        super("No one option has been found");
    }
}
