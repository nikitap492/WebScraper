package scraper.analyzer.impl;

import scraper.analyzer.CharsAnalyzer;
import scraper.analyzer.SentencesAnalyzer;
import scraper.analyzer.WordAnalyzer;
import scraper.collector.WordCollector;
import scraper.logger.Logger;
import scraper.logger.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public class CommonAnalyzer implements WordAnalyzer, CharsAnalyzer, SentencesAnalyzer {

    private static final Logger log = LoggerFactory.obtain(CommonAnalyzer.class);

    private List<String> sentences;

    private Collection<String> allWords;

    private WordCollector collector;

    public CommonAnalyzer(WordCollector collector) {
        this.collector = collector;
    }

    @Override
    public void data(List<String> data){
        this.sentences = data;
        this.allWords = collector.collect(data);
        log.debug("Final data has obtained");
    }

    @Override
    public void wordsAnalyze(List<String> searchableWord){
        log.debug("Started word analyze");
        searchableWord.forEach(this::singleWordAnalyze);
    }

    private void singleWordAnalyze(String word){
        long counter = allWords
                .stream()
                .filter(word.toUpperCase()::equals)
                .count();
        log.info("Word : " + word + " was found in sources " + counter + " times");
    }

    @Override
    public void sentencesAnalyze(List<String> searchableWord){
        log.debug("Started sentences analyze");

        searchableWord
                .stream()
                .peek(n -> log.info("Trying find " + n + " in sentences"))
                .forEach((word) -> sentences
                            .stream()
                            .filter(sentence -> Arrays.stream(sentence
                                            .toUpperCase()
                                            .replaceAll("[^A-Z0-9]", " ")
                                            .split(" "))
                                            .filter(word.toUpperCase()::equals)
                                            .count() > 0)
                            .forEach(log::info));
    }

    public void charsAnalyze(){
        log.debug("Started chars analyze");
        long chars = sentences
                .stream()
                .flatMapToInt(CharSequence::chars)
                .count();
        log.info("Sum of chars on web pages equals " + chars);
    }


}
