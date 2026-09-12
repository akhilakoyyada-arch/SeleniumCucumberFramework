package com.framework.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    public static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config/global.properties")) {

            if (input == null) {
                throw new RuntimeException("global.properties file not found");
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load global.properties", e);
        }
    }

    public static Properties getAllProperties() {
        return properties;
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}