package tests.unit.utils;

import org.junit.Assert;
import org.junit.Test;
import utils.OSController;

public class OSControllerTest {

    @Test
    public void checkOS() {
        // TODO need add logic
        Assert.assertTrue("select correct method or assert", OSController.isUnix());
        Assert.assertFalse("select correct method", OSController.isWindows());
        Assert.assertFalse("select correct method", OSController.isSolaris());
        Assert.assertFalse("select correct method", OSController.isMac());
    }

}