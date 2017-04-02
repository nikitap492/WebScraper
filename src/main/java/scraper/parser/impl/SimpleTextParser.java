package scraper.parser.impl;

import scraper.domain.ParseEntity;
import scraper.domain.WebPageText;
import scraper.logger.Logger;
import scraper.logger.LoggerFactory;
import scraper.parser.TextParser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 31.03.17.
 */
public class SimpleTextParser implements TextParser {

    private static final Logger log = LoggerFactory.obtain(SimpleTextParser.class);


    @Override
    public ParseEntity<WebPageText> parse(List<String> text) {
        log.debug("Parsing html text...");
        ArrayList<String> parseText = new ArrayList<>();
        for (String str : text) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; ) {
                if (chars[i] == 60) {
                    while (i < chars.length && chars[i] != 62) i++;
                    i++;
                } else {
                    int k = i;
                    while (i < chars.length && chars[i] != 60) i++;
                    if (k < i) parseText.add(str.substring(k, i));
                }

            }
        }
        log.debug("Parsing is complete");
        return ParseEntity.body(new WebPageText(parseText));
    }
}
