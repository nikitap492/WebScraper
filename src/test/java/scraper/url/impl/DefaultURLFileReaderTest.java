package scraper.url.impl;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import scraper.exceptions.URLParseException;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public class DefaultURLFileReaderTest {

    private static String path = "test";

    @BeforeClass
    public static void init() throws IOException {
        File file = new File(path);
        file.createNewFile();
        String test = "http://www.google.com";
        try(Writer out = new OutputStreamWriter(new FileOutputStream(file))){
            out.write(test);
        }

    }

    @Test
    public void testFileReader() throws IOException {
        DefaultURLFileReader reader = new DefaultURLFileReader();
        reader.urls(new File(path));
    }

    @Test(expected = URLParseException.class)
    public void shouldThrowError() throws MalformedURLException {
        String source = "error";
        DefaultURLFileReader reader = new DefaultURLFileReader();
        reader.addURL(new ArrayList<>(), source);
    }

    @Test
    public void shouldPutUrl() throws MalformedURLException {
        String source = "http://www.google.com";
        DefaultURLFileReader reader = new DefaultURLFileReader();
        List<URL> url = new ArrayList<>();
        reader.addURL(url, source);
        assertTrue(url.size() == 1);
        assertEquals(new URL(source), url.get(0));

    }


    @AfterClass
    public static void destroy() throws IOException {
        Files.delete(new File(path).toPath());
    }

}