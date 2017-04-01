package scraper.exceptions;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 */
public class MissingWordsException extends RuntimeException {

    public MissingWordsException() {
        super("You should enter words for scrabbing");
    }
}
