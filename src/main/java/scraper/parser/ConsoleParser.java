package scraper.parser;

import scraper.domain.ConsoleParseData;
import scraper.domain.ParseEntity;

import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public interface ConsoleParser extends Parser {

    @Override
    ParseEntity<ConsoleParseData> parse(List<String> args);
}
