package scraper.collector;

import java.util.Collection;
import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 */
@FunctionalInterface
public interface Collector<E, Source> {

    List<E> collect(Collection<Source> sources);

}
