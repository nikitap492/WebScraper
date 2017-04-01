package scraper.logger;

import scraper.config.ApplicationPropertiesConfiguration;
import scraper.domain.Property;

import java.time.LocalDateTime;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 */
public class LoggerFactory {

    public static Logger obtain(Class<?> clazz){
        return new SimpleLogger(clazz);
    }

    private LoggerFactory() {
    }

    private static class SimpleLogger implements Logger{

        private String className;

        SimpleLogger(Class<?> clazz) {
            this.className = clazz.getName();
        }

        public void error(String msg) {
            System.err.println(LocalDateTime.now() + " " + className+ " error: " + msg);
        }

        public void info(String msg) {
            System.out.println(LocalDateTime.now() + " " + className + " info: " + msg);
        }


        public void debug(String msg) {
            if (Debug.isEnable()) {
                System.out.println(LocalDateTime.now()  + " " + className + " debug: " + msg);
            }
        }


    }


    private static class Debug {
        private static Boolean enable = null;

        static boolean isEnable() {
            if (enable == null) {
                enable = ApplicationPropertiesConfiguration
                        .configuration()
                        .getValue(Property.VERBOSE);
            }
            return enable;
        }
    }

}
