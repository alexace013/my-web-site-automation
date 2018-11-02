package tests.unit.utils;

import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Log4j
public class ForSimpleTest {

    @Test
    @DisplayName("get user directory test")
    @org.junit.Test
    public void getUserDirectory() {
        String userDir = System.getProperty("user.dir");
        log.info(String.format("user directory: %s", userDir));
        Assert.assertNotNull("user directory is null", userDir);
    }

}
