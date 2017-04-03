package scraper.engine;

import scraper.domain.ConsoleParseData;
import scraper.domain.ParseEntity;
import scraper.domain.WebPage;
import scraper.domain.WebPageText;

import java.util.Collection;
import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 *
 * Central interfaces for control and run
 * main application for processes
 */
public interface Engine {

    /**
     * Runs application.
     * Takes
     * @param args
     * from main
     */
    void run(String args[]);

    /**
     * Starts parse process
     * Takes
     * @param args
     * from {@link Engine#run(String[])
     * @see scraper.parser.ConsoleParser
     */
    ParseEntity<ConsoleParseData> console(String[] args);

    /**
     * Starts web pages collector process
     * Takes
     * @param consoleResult
     * from {@link Engine#console(String[])}
     * @see scraper.collector.WebPagesCollector
     */
    Collection<WebPage> webPages(ParseEntity<ConsoleParseData> consoleResult);

    /**
     * Starts text collector process
     * Takes
     * @param webPages
     * from {@link Engine#webPages(ParseEntity)}
     * @see scraper.collector.TextCollector
     */
    List<String> text(Collection<WebPage> webPages);

    /**
     * Starts text parse process
     * Takes
     * @param text
     * from {@link Engine#text(Collection)}
     * @see scraper.collector.TextCollector
     */
    ParseEntity<WebPageText> parse(List<String> text);

    /**
     * Last application process is analyze.
     * Witch analyze will be active configures from input params
     * Takes
     * @param parseEntity
     * from {@link Engine#parse(List)}
     * @see scraper.analyzer.SentencesAnalyzer
     * @see scraper.analyzer.CharsAnalyzer
     * @see scraper.analyzer.WordAnalyzer
     *
     */
    void analyze(ParseEntity<WebPageText> parseEntity);

}
