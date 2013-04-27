/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.crawler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author martin
 */
class Config {

    private static Logger logger = Logger.getLogger(Config.class);

    protected static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("config.properties"));
        } catch (FileNotFoundException ex) {
            logger.error("FileNotFound", ex);
        } catch (IOException ex) {
            logger.error("IO ex" + ex);
        }
        return properties;
    }
}
