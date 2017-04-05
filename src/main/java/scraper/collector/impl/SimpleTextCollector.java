package scraper.collector.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scraper.collector.TextCollector;
import scraper.domain.WebPage;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 *
 * Implementation of {@link TextCollector}
 */
public class SimpleTextCollector implements TextCollector {

    private static final Logger log = LoggerFactory.getLogger(TextCollector.class);

    @Override
    public List<String> collect(Collection<WebPage> webPages) {
        log.debug("Starting collection web pages information");
        return webPages
                .stream()
                .flatMap(n -> n.getText().stream())
                .collect(Collectors.toList());
    }
}
