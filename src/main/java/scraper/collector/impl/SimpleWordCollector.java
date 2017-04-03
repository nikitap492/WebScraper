package scraper.collector.impl;

import scraper.collector.WordCollector;
import scraper.logger.Logger;
import scraper.logger.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 *
 * Implementation {@link WordCollector}
 */
public class SimpleWordCollector implements WordCollector {

    private static final Logger log = LoggerFactory.obtain(SimpleWordCollector.class);

    @Override
    public List<String> collect(Collection<String> collection) {
        log.debug("Collecting words");
        return collection.stream()
                .flatMap(n -> Arrays.stream(n
                                .toUpperCase()
                                .replaceAll("[^A-Z0-9]"," ")
                                .split(" ")))
                .collect(Collectors.toList());
    }
}
