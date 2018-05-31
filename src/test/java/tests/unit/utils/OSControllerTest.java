package tests.unit.utils;

import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.junit.Test;
import utils.OSController;

import java.io.IOException;

@Log4j
public class OSControllerTest {

    private static final String WINDOWS_TEXT = "windows";
    private static final String UNIX_TEXT = "unix";
    private static final String SOLARIS_TEXT = "solaris";
    private static final String MAC_TEXT = "mac";
    private static final String ASSERT_MESSAGE = "OS isn't %s";

    @Test
    public void checkOS() {
        if (OSController.isWindows()) {
            log.info(WINDOWS_TEXT);
            Assert.assertTrue(String.format(ASSERT_MESSAGE, WINDOWS_TEXT.toUpperCase()), !OSController.isWindows());
        } else if (OSController.isUnix()) {
            log.info(UNIX_TEXT);
            Assert.assertTrue(String.format(ASSERT_MESSAGE, UNIX_TEXT.toUpperCase()), !OSController.isUnix());
        } else if (OSController.isSolaris()) {
            log.info(SOLARIS_TEXT);
            Assert.assertTrue(String.format(ASSERT_MESSAGE, SOLARIS_TEXT.toUpperCase()), !OSController.isSolaris());
        } else if (OSController.isMac()) {
            log.info(MAC_TEXT);
            Assert.assertTrue(String.format(ASSERT_MESSAGE, MAC_TEXT.toUpperCase()), !OSController.isMac());
        } else {
            try {
                throw new IOException();
            } catch (IOException e) {
                log.error("This isn't any OS", e);
            }
        }
    }

}