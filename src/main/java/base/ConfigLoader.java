package base;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigLoader {
    private static Properties prop = new Properties();
    static {
        try {
            FileInputStream fis = new FileInputStream("config/config.properties");
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
