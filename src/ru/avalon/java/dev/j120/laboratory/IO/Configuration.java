
package ru.avalon.java.dev.j120.laboratory.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Configuration {
    private static Configuration instance;
    
    public static Configuration getInstance() {
        if(instance == null) {
            try {
                instance = new Configuration();
            } catch (IOException ex) {
                System.out.println("Unable to load properties");
                System.exit(1);
            }
        }
        return instance;
    }
    
    private Properties properties;

    private Configuration() throws IOException {
        Properties defaultProperties = new Properties();
       
        defaultProperties.load(new FileInputStream("application.properties"));
        
        properties = new Properties(defaultProperties);
        
        try {
            properties.load(new FileInputStream("user.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }   
    }

    public Properties getProperties() {
        return properties;
    }
}
