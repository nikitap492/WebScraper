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

        ApplicationPropertiesConfiguration
                .configuration()
                .setProperty(Property.VERBOSE, true);

        boolean value = ApplicationPropertiesConfiguration
                .configuration()
                .getValue(Property.VERBOSE);

        assertTrue(value);
    }

}