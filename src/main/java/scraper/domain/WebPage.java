package scraper.domain;

import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 */
public class WebPage implements Parsable{

    private final List<String> text;

    public WebPage(List<String> text) {
        this.text = text;
    }

    public List<String> getText() {
        return text;
    }
}
