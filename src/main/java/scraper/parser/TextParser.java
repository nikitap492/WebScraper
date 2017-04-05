package scraper.parser;


import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public interface TextParser {

    /**
     *
     * @param text is data from URL
     */
    List<String> parse(List<String> text);
}
