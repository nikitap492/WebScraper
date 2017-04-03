package scraper.collector;

import scraper.domain.WebPage;

import java.net.URL;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 *
 * {@link WebPagesCollector}
 * collects web pages data from URL
 * {@link URL}
 */
public interface WebPagesCollector extends Collector<WebPage, URL>{
}
