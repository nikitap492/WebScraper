package scraper.parser;

import scraper.domain.Parsable;
import scraper.domain.ParseEntity;

import java.util.List;

@FunctionalInterface
interface Parser {

    ParseEntity<? extends Parsable> parse(List<String> strings);
}
