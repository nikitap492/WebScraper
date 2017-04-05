package scraper.engine;


import scraper.domain.EngineAnalyze;

import java.net.URL;
import java.util.Collection;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 *
 *
 */
@FunctionalInterface
public interface Engine {

    EngineAnalyze run(Collection<URL> sources);

}
