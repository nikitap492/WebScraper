package scraper;


import scraper.engine.impl.EngineConfigurator;
import scraper.logger.Logger;
import scraper.logger.LoggerFactory;

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
 *              -v is verbose (enables debug)
 *              -e is analyze and print sentences in which were found word from 2)
 *              -w is word analyze (counter for each word from 2) on all sources)
 *              -c is char analyze (counts chars in web pages overall)
 * All components are interchangeable and expandable
 */
public class WebScraper {

    private static final Logger log = LoggerFactory.obtain(WebScraper.class);

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
        EngineConfigurator
                .configure()
                .defaultConfiguration()
                .run(args);
    }
}
