package scraper.parser.impl;

import scraper.config.ApplicationPropertiesConfiguration;
import scraper.domain.ConsoleParseData;
import scraper.domain.ParseEntity;
import scraper.domain.Property;
import scraper.exceptions.InputWasNotFoundException;
import scraper.exceptions.MissingWordsException;
import scraper.exceptions.URLParseException;
import scraper.exceptions.UnknownOptionWasFoundException;
import scraper.logger.Logger;
import scraper.logger.LoggerFactory;
import scraper.parser.ConsoleParser;
import scraper.url.URLFileReader;
import scraper.url.impl.DefaultURLFileReader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 */
public class DefaultConsoleParser implements ConsoleParser {

    private static final Logger log = LoggerFactory.obtain(DefaultConsoleParser.class);

   private URLFileReader urlFileReader = new DefaultURLFileReader();

    @Override
    public ParseEntity<ConsoleParseData> parse(List<String> args) {

        log.info("Parsing...");

        if (args.size() < 3) {
            log.error("You must input url, searching words and options");
            throw new InputWasNotFoundException();
        }

        if (args.get(1).startsWith("-")) {
            log.error("You should enter word (or world by delimeter ',')for searching ");
            throw new MissingWordsException();
        }

        setConfigurationProperties(args.subList(2, args.size()));

        List<URL> urls = obtainUrls(args.get(0));

        log.debug("Sources are " + urls
                .stream()
                .map(URL::getPath)
                .collect(Collectors.joining(", ")) );

        List<String> words = searchingWords(args.get(1));

        log.debug("Searching words are " + words
                .stream()
                .collect(Collectors.joining(", ")) );


        return ParseEntity.body(new ConsoleParseData(urls, words));
    }

    public void setURLFileReader(URLFileReader URLFileReader) {
        this.urlFileReader = URLFileReader;
        log.info("URLFileReader was configured");
    }



    private List<URL> obtainUrls(String path) {
        log.debug("Trying to obtain source from " + path);
        File file = new File(path);
        List<URL> urls = new ArrayList<>();
        try {
            if(file.exists()){
                log.debug("File was found");
                urls = urlFileReader.urls(file);
            }else {
                log.debug("File was not found. Trying create connection to " + path);
                urlFileReader.addURL(urls, path);
            }
        }catch (IOException e){
            throw new URLParseException(e.getMessage());
        }

        return urls;
    }

    private List<String> searchingWords(String words) {
        return Arrays.asList(words.toUpperCase().split(","));
    }

    private void quickSetter(Property property) {
        ApplicationPropertiesConfiguration.configuration().setProperty(property, true);
    }

    private void setConfigurationProperties(List<String> args) {
        for (String option : args) {
            switch (option.toUpperCase()) {
                case "-V":
                    quickSetter(Property.VERBOSE);
                    break;
                case "-C":
                    quickSetter(Property.CHARS_NUMBER);
                    break;
                case "-W":
                    quickSetter(Property.WORDS_NUMBER);
                    break;
                case "-E":
                    quickSetter(Property.SENTENCES);
                    break;
                default:
                    log.error(option + " is unknown option. Full list option is {-v, -c , -w, -e}");
                    throw new UnknownOptionWasFoundException(option);
            }
        }
        log.info("Setup of configuration is over");
    }


}
