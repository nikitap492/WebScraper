package scraper.analyzer.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scraper.analyzer.CharsAnalyzer;
import scraper.analyzer.SentencesAnalyzer;
import scraper.analyzer.WordAnalyzer;
import scraper.collector.WordCollector;

import java.util.*;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 *
 * @link CommonAnalyzer
 * union all analyzer {@link scraper.analyzer.Analyzer} interfaces
 * {@link WordAnalyzer}, {@link CharsAnalyzer}, {@link SentencesAnalyzer}
 */
public class CommonAnalyzer implements WordAnalyzer, CharsAnalyzer, SentencesAnalyzer {

    private static final Logger log = LoggerFactory.getLogger(CommonAnalyzer.class);

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
    public Map<String, Long> wordsAnalyze(List<String> searchableWord){
        log.debug("Word analyze");
        Map<String, Long> result = new HashMap<>();
        searchableWord.forEach(word -> result.put(word, allWords
                                                            .stream()
                                                            .filter(word.toUpperCase()::equals)
                                                            .count()));
        return result;
    }

    /**
     * @see SentencesAnalyzer
     * @param searchableWord is words for which will be find sentences
     * @return map of words and sentences which contain word
     */
    @Override
    public Map<String, List<String>> sentencesAnalyze(List<String> searchableWord){
        log.debug("Sentences analyze");

        Map<String, List<String>> result = new HashMap<>();
        searchableWord
                .stream()
                .peek(word -> result.put(word, new ArrayList<>()))
                .forEach((word) -> sentences
                            .stream()
                            .filter(sentence -> Arrays.stream(sentence
                                            .toUpperCase()
                                            .replaceAll("[^A-Z0-9]", " ")
                                            .split(" "))
                                            .filter(word.toUpperCase()::equals)
                                            .count() > 0)
                            .forEach(result.get(word)::add));
        return result;
    }

    /**
     * @see CharsAnalyzer
     * @return Number of all chars on web pages
     */
    @Override
    public Long charsAnalyze(){
        log.debug("Chars analyze");
        return sentences
                .stream()
                .flatMapToInt(CharSequence::chars)
                .count();
    }


}
