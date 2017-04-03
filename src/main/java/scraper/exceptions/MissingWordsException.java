package scraper.exceptions;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 *
 * Then {@link scraper.parser.ConsoleParser} cannot find searchable words
 */
public class MissingWordsException extends RuntimeException {

    public MissingWordsException() {
        super("You should enter words for scrabbing");
    }
}
