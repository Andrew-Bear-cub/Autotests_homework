package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    private final Properties properties = new Properties();
    private static TestProperties INSTANCE = null;

    private TestProperties() {
        try {
            properties.load(new FileInputStream(new File("./" + System.getProperty("environment", "environment") + ".properties")));
        } catch (IOException e) {
            System.out.println("Не найден файл environment.properties!!!");
        }
    }

    public static TestProperties getinstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }
    public Properties getProperties(){
        return properties;
    }
}
