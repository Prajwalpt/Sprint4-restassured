package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties props = new Properties();

    static {
        try (InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        String v = props.getProperty(key);
        if (v == null) throw new RuntimeException("Missing config key: " + key);
        return v.trim();
    }

    public static String getOrDefault(String key, String def) {
        String v = props.getProperty(key);
        return v == null ? def : v.trim();
    }
}
