package unit.utils;

import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import controller.PropertyController;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Log4j
@DisplayName("PROPERTY CONTROLLER TESTS")
@RunWith(JUnit4.class)
public class PropertyControllerTest {

    private static final String TEST_PROP_NAME = "test.prop.name";

    @Test
    @RepeatedTest(2)
    @DisplayName("Test_00-01: PropertyController - positive test")
    @org.junit.Test
    public void loadPropertyPositiveTest() {
        Assert.assertEquals("Something wrong with test.properties",
                "test.prop.value", PropertyController.loadProperty(TEST_PROP_NAME));
    }

    @Test
    @DisplayName("Test_00-02: PropertyController - negative test")
    @org.junit.Test
    public void loadPropertyNegativeTest() {
        Assert.assertNotEquals("Something wrong with test.properties",
                "test", PropertyController.loadProperty(TEST_PROP_NAME));
    }

    @Test
    @DisplayName("Test_00-03: PropertyController - invalid property data")
    @org.junit.Test
    public void loadPropertyInvalidPropertyTest() {
        Assert.assertEquals("java.lang.String<null>", "null", PropertyController.loadProperty("test"));
    }

    @Test
    @Disabled(value = "loadPropertyNullPropertyTest method is disabled")
    @DisplayName("Test_00-04: PropertyLoader - null property data")
    @org.junit.Test
    public void loadPropertyNullPropertyTest() {
        try {
            String result = PropertyController.loadProperty(null);
            log.debug(result);
            Assert.assertNull("should be null", result);
        } catch (NullPointerException e) {
            log.error(String.format("%s", e), e);
        }
    }

}