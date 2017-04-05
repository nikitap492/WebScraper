package scraper.parser.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scraper.parser.TextParser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 31.03.17.
 *
 * Implementation of {@link TextParser}
 */
public class SimpleTextParser implements TextParser {

    private static final Logger log = LoggerFactory.getLogger(SimpleTextParser.class);


    /**
     * @param text is data from URL
     */
    @Override
    public List<String> parse(List<String> text) {
        log.debug("Parsing html text...");
        ArrayList<String> parseText = new ArrayList<>();
        for (String str : text) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; ) {
                if (chars[i] == 60) {
                    while (i < chars.length && chars[i] != 62) i++; // char "<"
                    i++;
                } else {
                    int k = i;
                    while (i < chars.length && chars[i] != 60) i++; // char ">"
                    if (k < i) parseText.add(str.substring(k, i));
                }

            }
        }
        log.debug("Parsing is complete");
        return parseText;
    }
}
