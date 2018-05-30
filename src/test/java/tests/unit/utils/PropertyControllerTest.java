package tests.unit.utils;

import org.junit.Assert;
import org.junit.Test;
import utils.PropertyController;

public class PropertyControllerTest {

    private static final String TEST_PROP_NAME = "test.prop.name";

    @Test
    public void loadPropertyPositiveTest() {
        Assert.assertEquals("Something wrong with test.properties",
                "test.prop.value", PropertyController.loadProperty(TEST_PROP_NAME));
    }

    @Test
    public void loadPropertyNegativeTest() {
        Assert.assertNotEquals("Something wrong with test.properties",
                "test", PropertyController.loadProperty(TEST_PROP_NAME));
    }

    @Test
    public void loadPropertyNullTest() {
        // TODO assert message fix
        Assert.assertEquals("java.lang.String<null>", "null", PropertyController.loadProperty("test"));
//        Assert.assertNull("should be null", PropertyController.loadProperty("test"));
    }

}