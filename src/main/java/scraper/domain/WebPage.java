package scraper.domain;

import java.util.ArrayList;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 */
public class WebPage implements Parsable{

    private final ArrayList<String> text;

    public WebPage(ArrayList<String> text) {
        this.text = text;
    }

    public ArrayList<String> getText() {
        return text;
    }
}
