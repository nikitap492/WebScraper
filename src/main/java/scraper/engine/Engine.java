package scraper.engine;

import scraper.domain.ConsoleParseData;
import scraper.domain.ParseEntity;
import scraper.domain.WebPage;
import scraper.domain.WebPageText;

import java.util.Collection;
import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public interface Engine {

    void run(String args[]);

    ParseEntity<ConsoleParseData> console(String[] args);

    Collection<WebPage> webPages(ParseEntity<ConsoleParseData> consoleResult);

    List<String> text(Collection<WebPage> webPages);

    ParseEntity<WebPageText> parse(List<String> text);

    void analyze(ParseEntity<WebPageText> parseEntity);

}
