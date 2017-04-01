package scraper.parser;

import scraper.domain.ParseEntity;
import scraper.domain.WebPageText;

import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public interface TextParser extends Parser{

    @Override
    ParseEntity<WebPageText> parse(List<String> text);
}
