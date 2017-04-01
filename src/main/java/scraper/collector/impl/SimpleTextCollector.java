package scraper.collector.impl;

import scraper.collector.TextCollector;
import scraper.domain.WebPage;
import scraper.logger.Logger;
import scraper.logger.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public class SimpleTextCollector implements TextCollector {

    private static final Logger log = LoggerFactory.obtain(TextCollector.class);

    @Override
    public List<String> collect(Collection<WebPage> webPages) {
        log.debug("Starting collection web pages information");
        return webPages
                .stream()
                .flatMap(n -> n.getText().stream())
                .collect(Collectors.toList());
    }
}
