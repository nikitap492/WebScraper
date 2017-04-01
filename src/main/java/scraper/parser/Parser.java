package scraper.parser;

import scraper.domain.Parsable;
import scraper.domain.ParseEntity;

import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 */
@FunctionalInterface
public interface Parser {

      ParseEntity<? extends Parsable> parse(List<String> strings);
}
