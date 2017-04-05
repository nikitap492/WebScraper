package scraper.domain;

import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 *
 * Web pages parse entity is obtained to {@link scraper.collector.WebPagesCollector}
 * and is parsed by {@link scraper.parser.TextParser}
 */
public class WebPage  {

    private final List<String> text;

    public WebPage(List<String> text) {
        this.text = text;
    }

    public List<String> getText() {
        return text;
    }
}
