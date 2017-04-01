package scraper.domain;

import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 31.03.17.
 */
public class WebPageText implements Parsable {

    private List<String> text;

    public WebPageText(List<String> text) {
        this.text = text;
    }

    public List<String> getText() {
        return text;
    }
}
