package utils;

import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

@Log4j
public class PropertyController {

    private static final String[] PROPERTIES_FILES =
            {
                    "/common.properties",
                    "/test.properties"
            };
    private static Map propertiesMapping;

    private static void loadProperties() {
        Properties properties = new Properties();
        try {
            for (String PROPERTY : PROPERTIES_FILES) {
                properties.load(PropertyController.class.getResourceAsStream(PROPERTY));
                propertiesMapping = properties;
            }
        } catch (IOException e) {
            log.error(String.format("Something wrong with properties <%s>", PROPERTIES_FILES));
        }
    }

    public static synchronized String loadProperty(final String propertyName) {
        if (propertiesMapping == null) {
            loadProperties();
        }
        return String.valueOf(propertiesMapping.get(propertyName));
    }

}
