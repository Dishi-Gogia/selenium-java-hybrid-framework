package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    // Static block → loads once
    static {
        try {
            String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            FileInputStream fis = new FileInputStream(path);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}