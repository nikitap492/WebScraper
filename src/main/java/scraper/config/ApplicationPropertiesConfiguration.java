package scraper.config;

import scraper.domain.Property;
import scraper.logger.Logger;
import scraper.logger.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 */
public class ApplicationPropertiesConfiguration implements PropertiesConfiguration {

    private static final Logger log = LoggerFactory.obtain(ApplicationPropertiesConfiguration.class);
    private Map<Property, Boolean> map;
    private static PropertiesConfiguration configuration = null;

    /**
     * All properties disables by default
     */
    private ApplicationPropertiesConfiguration() {
        this.map = new HashMap<>();
        for (Property property : Property.values()){
            map.put(property, false);
        }
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void setProperty(Property property, boolean value) {
        map.put(property, value);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public boolean getValue(Property property) {
        return map.get(property);
    }

    /**
     * Singleton with lazy initialization for logger
     * @return {@link ApplicationPropertiesConfiguration}
     */
    public static PropertiesConfiguration configuration(){
        if (configuration == null) {
            configuration = new ApplicationPropertiesConfiguration();
        }
        return configuration;
    }

}
