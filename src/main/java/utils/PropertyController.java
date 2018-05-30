package utils;

import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.util.Properties;

@Log4j
public class PropertyController {

    private static final String PROPERTY_FILE = "/common.properties";

    public static String loadProperty(final String propertyName) {
        Properties properties = new Properties();
        try {
            properties.load(PropertyController.class.getResourceAsStream(PROPERTY_FILE));
        } catch (IOException e) {
            log.error(String.format("incorrect property name <%s>\n%s", propertyName, e.getMessage()));
        }
        String propertyValue = null;
        if (propertyName != null) {
            propertyValue = properties.getProperty(propertyName);
        }
        return propertyValue;
    }

}
