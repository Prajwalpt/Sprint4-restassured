package config;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonReader {
    private static final String DATA_PATH = "src/test/resources/testdata/";

    public static Object get(String fileName, String key) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Object> data = mapper.readValue(
                    new File(DATA_PATH + fileName), Map.class
            );
            return data.get(key);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON data from " + fileName, e);
        }
    }
}
