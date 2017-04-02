package scraper.config;

import scraper.domain.Property;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 */
public interface PropertiesConfiguration extends Configuration {

    void setProperty(Property property, boolean value );

    boolean getValue(Property property);
}
