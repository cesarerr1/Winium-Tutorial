package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream inputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getApplicationPath() {
        return properties.getProperty("application.path");
    }

    public static String getWiniumDriverUrl() {
        return properties.getProperty("winium.driver.url");
    }
}
