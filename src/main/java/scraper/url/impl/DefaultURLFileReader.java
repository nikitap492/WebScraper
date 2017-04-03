package scraper.url.impl;

import scraper.exceptions.URLParseException;
import scraper.logger.Logger;
import scraper.logger.LoggerFactory;
import scraper.url.URLFileReader;
import scraper.url.URLValidator;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public class DefaultURLFileReader implements URLFileReader {

    private static final Logger log = LoggerFactory.obtain(URLFileReader.class);

    /**
     *
     * @param file is file with urls
     * @return container
     * @throws IOException, URLParseException
     */
    @Override
    public List<URL> urls(File file) throws IOException {
        List<URL> urls = new ArrayList<>();
        List<String> urlStrings = Files.lines(file.toPath())
                .collect(Collectors.toList());
        if (URLValidator.validate(urlStrings)) {
            for (String urlStr : urlStrings) {
                urls.add(new URL(urlStr));
            }
        } else {
            log.error("File contains no valid url");
            throw new URLParseException("File contains no valid url");
        }
        log.debug("Http connection was created successfully for all sources");
        return urls;
    }

    /**
     * @param urls is container
     * @param url is source
     * @throws MalformedURLException, URLParseException
     *
     */
    @Override
    public void addURL(List<URL> urls, String url) throws MalformedURLException {
        if(URLValidator.validate(url)){
            urls.add(new URL(url));
            log.debug("Http connection was created successfully");
        }
        else {
            log.error("Cannot create connection. Check your url " + url);
            throw new URLParseException("Attempt of creation connection was failed");
        }
    }
}
