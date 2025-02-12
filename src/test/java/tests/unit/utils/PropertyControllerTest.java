package unit.utils;

import lombok.extern.log4j.Log4j;
import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import controller.PropertyController;

@Log4j
@DisplayName("PROPERTY CONTROLLER TESTS")
public class PropertyControllerTest {

    private static final String TEST_TEXT = "test";
    private static final String TEST_PROP_NAME = "test.prop.name";
    private static final String TEST_PROP_VALUE = TEST_TEXT.toLowerCase().concat(".prop.value");
    private static final String ERROR_FOR_TEST_PROP_TEXT = "Something wrong with test.properties";

    @Test
    @RepeatedTest(2)
    @DisplayName("Test_00-01: PropertyController - positive test")
    @org.junit.Test
    public void loadPropertyPositiveTest() {
        Assert.assertEquals(ERROR_FOR_TEST_PROP_TEXT, TEST_PROP_VALUE, PropertyController.loadProperty(TEST_PROP_NAME));
    }

    @Test
    @DisplayName("Test_00-02: PropertyController - negative test")
    @org.junit.Test
    public void loadPropertyNegativeTest() {
        Assert.assertNotEquals(ERROR_FOR_TEST_PROP_TEXT,
                "test", PropertyController.loadProperty(TEST_PROP_NAME));
    }

    @Test
    @DisplayName("Test_00-03: PropertyController - invalid property data")
    @org.junit.Test
    public void loadPropertyInvalidPropertyTest() {
        Assert.assertEquals("java.lang.String<null>", "null", PropertyController.loadProperty("test"));
    }

    @Test
//    @Disabled(value = "loadPropertyNullPropertyTest method is disabled")
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