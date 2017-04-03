package scraper.parser;

import scraper.domain.Parsable;
import scraper.domain.ParseEntity;

import java.util.List;

/**
 * Central parse interface
 */
@FunctionalInterface
interface Parser {

    /**
     *
     * @param strings is source
     * @return {@link Parsable} entity of parse process
     */
    ParseEntity<? extends Parsable> parse(List<String> strings);
}
