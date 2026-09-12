package com.framework.utils;

import java.util.Properties;

public final class Settings {
    private Settings() {
    }

    public static Properties getInstance() {
        return ConfigReader.getAllProperties();
    }

    public static String getProperty(String key) {
        return ConfigReader.getProperty(key);
    }
}
