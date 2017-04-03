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

    /**
     * Collects urls form file
     * @param file is file with urls
     * @return url container
     * @throws IOException during reading
     */
    List<URL> urls(File file) throws IOException;
}
