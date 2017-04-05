package scraper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import scraper.analyzer.impl.CommonAnalyzerTest;
import scraper.collector.impl.DefaultWebPagesCollectorTest;
import scraper.collector.impl.SimpleTextCollectorTest;
import scraper.collector.impl.SimpleWordCollectorTest;
import scraper.config.ApplicationPropertiesConfigurationTest;
import scraper.engine.impl.EngineTests;
import scraper.parser.impl.DefaultConsoleParserTest;
import scraper.parser.impl.SimpleTextParserTest;
import scraper.url.URLValidatorTest;
import scraper.url.impl.DefaultURLFileReaderTest;

/**
 * @author Poshivalov Nikita
 * @since 02.04.17.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({URLValidatorTest.class, DefaultURLFileReaderTest.class,
        DefaultConsoleParserTest.class, SimpleTextParserTest.class,
        EngineTests.class, ApplicationPropertiesConfigurationTest.class,
        DefaultWebPagesCollectorTest.class, SimpleWordCollectorTest.class,
        SimpleWordCollectorTest.class, CommonAnalyzerTest.class,
        SimpleTextCollectorTest.class
})
public class MainTestSuite {
}