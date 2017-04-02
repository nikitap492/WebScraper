package scraper.logger;

import org.junit.Test;

import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * @author Poshivalov Nikita
 * @since 01.04.17.
 */
public class LoggerFactoryTest {

    private static MockPrintStream mockPrintStream = new MockPrintStream(System.out);
    private static Logger test = LoggerFactory.obtain(LoggerFactoryTest.class, mockPrintStream);


    @Test
    public void testInfo(){
        String info = "info";
        test.info(info);
        String withoutDate = mockPrintStream.getLastString()
                .substring(mockPrintStream.getLastString()
                        .indexOf(LoggerFactoryTest.class.getName()));
        assertEquals(LoggerFactoryTest.class.getName() + " info: " + info, withoutDate);
    }

    @Test
    public void testError(){
        String err = "error";
        test.error(err);
        String withoutDate = mockPrintStream.getLastString()
                .substring(mockPrintStream.getLastString()
                        .indexOf(LoggerFactoryTest.class.getName()));
        assertEquals(LoggerFactoryTest.class.getName() + " error: " + err, withoutDate);
    }


    public static class MockPrintStream extends PrintStream{

        private String lastString;

        public MockPrintStream(OutputStream out) {
            super(out);
        }

        @Override
        public void println(String x) {
            this.lastString = x;
        }

        public String getLastString() {
            return lastString;
        }
    }

}