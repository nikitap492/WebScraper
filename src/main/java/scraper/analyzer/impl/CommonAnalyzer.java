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
 *
 * @link CommonAnalyzer
 * union all analyzer {@link scraper.analyzer.Analyzer} interfaces
 * {@link WordAnalyzer}, {@link CharsAnalyzer}, {@link SentencesAnalyzer}
 */
public class CommonAnalyzer implements WordAnalyzer, CharsAnalyzer, SentencesAnalyzer {

    private static final Logger log = LoggerFactory.obtain(CommonAnalyzer.class);

    private List<String> sentences;

    private Collection<String> allWords;

    private WordCollector collector;

    /**
     * @param collector
     * Setter for collector
     */
    public CommonAnalyzer(WordCollector collector) {
        this.collector = collector;
    }

    /**
     * Set sentences data
     * @param data
     * and collect all {@link CommonAnalyzer#allWords}
     * by collector {@link CommonAnalyzer#collector}
     */
    @Override
    public void data(List<String> data){
        this.sentences = data;
        this.allWords = collector.collect(data);
        log.debug("Final data has obtained");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void wordsAnalyze(List<String> searchableWord){
        log.debug("Started word analyze");
        searchableWord.forEach(this::singleWordAnalyze);
    }

    /**
     * Analyze of single word
     * @param word
     */
    private void singleWordAnalyze(String word){
        long counter = allWords
                .stream()
                .filter(word.toUpperCase()::equals)
                .count();
        log.info("Word : " + word + " was found in sources " + counter + " times");
    }

    /**
     * @param searchableWord is words for which will be printed sentences
     */
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

    /**
     * @see CharsAnalyzer
     */
    @Override
    public void charsAnalyze(){
        log.debug("Started chars analyze");
        long chars = sentences
                .stream()
                .flatMapToInt(CharSequence::chars)
                .count();
        log.info("Sum of chars on web pages equals " + chars);
    }


}
