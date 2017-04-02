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

    private ApplicationPropertiesConfiguration() {
        this.map = new HashMap<>();
        for (Property property : Property.values()){
            map.put(property, false);
        }
    }

    @Override
    public void setProperty(Property property, boolean value) {
        map.put(property, value);
    }

    @Override
    public boolean getValue(Property property) {
        return map.get(property);
    }

    public static PropertiesConfiguration configuration(){
        if (configuration == null) {
            configuration = new ApplicationPropertiesConfiguration();
        }
        return configuration;
    }

}
