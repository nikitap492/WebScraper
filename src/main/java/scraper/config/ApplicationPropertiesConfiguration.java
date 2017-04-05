package scraper.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 */
public class ApplicationPropertiesConfiguration implements Configuration {

    private static final Logger log = LoggerFactory.getLogger(ApplicationPropertiesConfiguration.class);
    private Properties properties;

    public ApplicationPropertiesConfiguration() {
       properties = new Properties();
    }

    public ApplicationPropertiesConfiguration(Properties properties) {
        this.properties = properties;
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void setProperty(String property, String value) {
        properties.setProperty(property, value);
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public String getValue(String property) {
        return properties.getProperty(property);
    }


}
