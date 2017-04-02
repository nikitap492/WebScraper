package scraper.url;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public interface URLFileReader extends URLReader{

    List<URL> urls(File file) throws IOException;
}
