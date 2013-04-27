package cz.crawler;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author martin
 */
public class ProjectProperties {

    private static Logger logger = Logger.getLogger(ProjectProperties.class);
    public static final String S_DST_ADDRESS = "DST.ipAddress";
    private static ProjectProperties projectPropertiesInstance = null;
    public static String I_LASTCARDID = "I_LASTCARDID";
    public static final String DB_USER = "DB_USER";
    public static final String DB_PASSWD = "DB_PASSWD";
    public static final String DB_IP = "DB_IP";
    private Properties prop;

    private ProjectProperties() {
        prop = Config.getProperties();
    }

    public static ProjectProperties getInstance() {
        if (projectPropertiesInstance == null) {
            projectPropertiesInstance = new ProjectProperties();
        }
        return projectPropertiesInstance;
    }

    public void setIntProperty(String key, int value) {
        prop.setProperty(key, "" + value);
    }

    public int getIntProperty(String propertyName) {
        return Integer.parseInt(prop.getProperty(propertyName));
    }

    public void setDoubleProperty(String key, double value) {
        prop.setProperty(key, "" + value);
    }

    public double getDoubleProperty(String propertyName) {
        return Double.parseDouble(prop.getProperty(propertyName));
    }

    public void setColorProperty(String key, Color value) {
        setIntProperty(key, value.getRGB());
    }

    public Color getColorProperty(String propertyName) {
        return Color.decode(prop.getProperty(propertyName));
    }

    public void setBooleanProperty(String key, boolean value) {
        prop.setProperty(key, "" + value);
    }

    public boolean getBooleanProperty(String propertyName) {
        return Boolean.parseBoolean(prop.getProperty(propertyName));
    }

    public void setStringProperty(String key, String value) {
        prop.setProperty(key, value);
    }

    public String getStringProperty(String propertyName) {
        return prop.getProperty(propertyName);
    }

    public void store() {
        try {
            prop.store(new FileOutputStream("config.properties"), null);
        } catch (IOException ex) {
            logger.error("Error:", ex);
        }
    }
}
