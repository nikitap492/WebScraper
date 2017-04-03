package scraper.collector;

import java.util.Collection;
import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 *
 * Central interface of collection data
 * @param <E> is entities that are collected
 * @param <Source> is data sources
 */
@FunctionalInterface
public interface Collector<E, Source> {

    List<E> collect(Collection<Source> sources);

}
