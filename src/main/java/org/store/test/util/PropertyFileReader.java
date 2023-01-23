package org.store.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyFileReader {
    public static String getProperty(String propertyName) {
        String propertyValue = null;

        try (InputStream input = Files.newInputStream(Paths.get("./src/main/resources/config.properties"))) {
            Properties prop = new Properties();
            prop.load(input);
            propertyValue = prop.getProperty(propertyName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return propertyValue;
    }

}
