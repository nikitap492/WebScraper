package scraper.config;

import scraper.domain.Property;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 *
 * {@link PropertiesConfiguration}
 * is container for properties
 * For further extension may be better convert to {@link java.util.Map<String, String>}
 * But for current task this is the best choice
 */
public interface PropertiesConfiguration extends Configuration {

    /**
     * Set
     * @param value
     * for
     * @param property
     */
    void setProperty(Property property, boolean value );

    /**
     *
     * @return values
     * for
     * @param property
     */
    boolean getValue(Property property);
}
