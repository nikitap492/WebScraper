package scraper.domain;

import scraper.exceptions.AnalyzeWasNotEnable;

import java.util.List;
import java.util.Map;

/**
 * @author Poshivalov Nikita
 * @since 05.04.2017.
 *
 * Implementation of {@link EngineAnalyze}
 */
public class WebScraperEngineAnalyze implements EngineAnalyze{

    private Long chars = null;
    private Map<String, Long> words = null;
    private Map<String, List<String>> sentences = null;


    /**
     * {@inheritDoc}
     */
    @Override
    public Long chars() {
        if(chars == null){
            throw new AnalyzeWasNotEnable();
        }
        return chars;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Long> words() {
        if(words == null){
            throw new AnalyzeWasNotEnable();
        }
        return words;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, List<String>> sentences() {
        if(sentences == null){
            throw new AnalyzeWasNotEnable();
        }
        return sentences;
    }

    public void setChars(Long chars) {
        this.chars = chars;
    }

    public void setWords(Map<String, Long> words) {
        this.words = words;
    }

    public void setSentences(Map<String, List<String>> sentences) {
        this.sentences = sentences;
    }
}
