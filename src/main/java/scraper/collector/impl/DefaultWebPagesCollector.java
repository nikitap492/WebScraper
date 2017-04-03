package scraper.collector.impl;

import scraper.collector.WebPagesCollector;
import scraper.domain.WebPage;
import scraper.exceptions.CollectorProcessException;
import scraper.logger.Logger;
import scraper.logger.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 31.03.17.
 *
 * Implementation of {@link WebPagesCollector}
 */
public class DefaultWebPagesCollector implements WebPagesCollector {

    private static final Logger log = LoggerFactory.obtain(DefaultWebPagesCollector.class);

    @Override
    public List<WebPage> collect(Collection<URL> urls) throws CollectorProcessException {
        try {
            log.debug("Collect information from sources");
            List<WebPage> webPages = new ArrayList<>();
            for (URL url : urls) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
                    String str;
                    ArrayList<String> webPageText = new ArrayList<>();
                    while ((str = in.readLine()) != null) {
                        webPageText.add(str);
                    }
                    WebPage webPage = new WebPage(webPageText);
                    webPages.add(webPage);
                }
            }
            log.debug("Process is complete.");
            return webPages;
        } catch (Exception e) {
            log.error("Collection process error");
            throw new CollectorProcessException(e);
        }
    }

}
