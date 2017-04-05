package scraper.config;

import org.junit.Test;
import scraper.domain.Property;

import static org.junit.Assert.assertTrue;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public class ApplicationPropertiesConfigurationTest {
    @Test
    public void shouldPutAndGet(){

        Configuration configuration = new ApplicationPropertiesConfiguration();
        configuration.setProperty(Property.SENTENCES.name(), "" + true);
        String value = configuration.getValue(Property.SENTENCES.name());
        assertTrue(Boolean.valueOf(value));
    }

}