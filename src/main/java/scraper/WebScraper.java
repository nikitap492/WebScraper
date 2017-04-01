package scraper;


import scraper.engine.impl.WebScraperEngine;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 */
public class WebScraper {

    public static void main(String args[]) throws Exception {
        new WebScraperEngine().run(args);
    }
}
