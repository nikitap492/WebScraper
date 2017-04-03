package scraper.parser;

import scraper.domain.ConsoleParseData;
import scraper.domain.ParseEntity;
import scraper.exceptions.InputWasNotFoundException;
import scraper.exceptions.MissingWordsException;
import scraper.url.URLFileReader;

import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public interface ConsoleParser extends Parser {

    /**
     * @return  {@link ParseEntity<ConsoleParseData>} that contains
     * urls list sources {@link ConsoleParseData#urls}
     * and searchable words {@link ConsoleParseData#words}
     * Takes list params {@param args}
     * @throws InputWasNotFoundException and
     * @throws MissingWordsException
     */
    @Override
    ParseEntity<ConsoleParseData> parse(List<String> args);

    /**
     * Maybe useful
     * for further extensions
     * @param URLFileReader
     */
    void setURLFileReader(URLFileReader URLFileReader);
}
