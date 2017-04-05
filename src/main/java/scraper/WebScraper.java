package scraper;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scraper.config.Configuration;
import scraper.domain.ConsoleParseData;
import scraper.domain.EngineAnalyze;
import scraper.engine.impl.EngineConfigurator;
import scraper.parser.ConsoleParser;
import scraper.parser.impl.DefaultConsoleParser;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 *
 * WebScraper is application for data mining without using 3rd party libraries.
 * Application takes {@param args } from {@link WebScraper#main(String[])}
 * which must contains
 * 1) URL or path to file with urls
 * 2) word or words separated by delimeter ","
 * 3) Optional options:
 *              -e is analyze and print sentences in which were found word from 2)
 *              -w is word analyze (counter for each word from 2) on all sources)
 *              -c is char analyze (counts chars in web pages overall)
 * All components are interchangeable and expandable
 */
public class WebScraper {

    private static final Logger log = LoggerFactory.getLogger(WebScraper.class);

    /**
     * Main class of application
     * Give control to {@link scraper.engine.Engine}
     * Takes
     * @param args
     * that will be parsed by {@link scraper.parser.ConsoleParser}
     *
     * @see EngineConfigurator
     * @see scraper.engine.Engine
     */
    public static void main(String args[]) {
        log.info("Application starting ....");

        // Console parse

        ConsoleParser parser = new DefaultConsoleParser();
        ConsoleParseData consoleParseData = parser.parse(Arrays.stream(args)
                .collect(Collectors.toList()));

        Configuration configuration = consoleParseData.getConfiguration();
        List<URL> sources = consoleParseData.getUrls();
        List<String> words = consoleParseData.getWords();

        // Run engine
        EngineAnalyze analyze = EngineConfigurator
                .configure(configuration)
                .search(words)
                .useDefaultComponents()
                .run(sources);

        //simple output
        analyze.words().forEach((word, counter) -> log.info("Word : " + word + " was found in sources " + counter + " times"));
        analyze.sentences()
                .forEach((word, sentences) -> log.info("Word : " + word + " was found in sentences ' " + sentences + " '"));
        log.info("Sum of chars on web pages equals " + analyze.chars());
    }

}
