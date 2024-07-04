package com.test.util;

import com.logger.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public Properties init_prop() {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
        } catch (FileNotFoundException e) {
            Log.error("File not found exception");
            throw new RuntimeException(e);
        } catch (IOException e) {
            Log.error("IO exception while loading file");
            throw new RuntimeException(e);
        }
    return properties;
    }
}
