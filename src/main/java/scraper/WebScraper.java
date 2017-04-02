package scraper;


import scraper.engine.impl.EngineConfigurator;
import scraper.logger.Logger;
import scraper.logger.LoggerFactory;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 */
public class WebScraper {

    private static final Logger log = LoggerFactory.obtain(WebScraper.class);

    public static void main(String args[]) throws Exception {
        log.info("Application starting ....");
        EngineConfigurator
                .configure()
                .defaultConfiguration()
                .run(args);
    }
}
