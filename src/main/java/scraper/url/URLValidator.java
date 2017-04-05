package scraper.url;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Poshivalov Nikita
 * @since 31.03.2017.
 *
 * Validates url connection
 */
public final class URLValidator {
    private static final Logger log = LoggerFactory.getLogger(URLValidator.class);


    public static boolean validate(String urlStr){
        try {
            log.debug("Validating url " +urlStr);
            URL url = new URL(urlStr);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.connect();

            if (HttpURLConnection.HTTP_OK == urlConn.getResponseCode()){
                log.debug("url is correct");
                return true;
            }
        } catch (IOException e) {
            log.error("Cannot obtain HTTP connection");
            e.printStackTrace();
        }
        log.error("url is incorrect");
        return false;
    }


    public static boolean validate(Iterable<String> urls){
        for (String url: urls) {
            if (!validate(url)) return false;
        }
        return true;
    }




}
