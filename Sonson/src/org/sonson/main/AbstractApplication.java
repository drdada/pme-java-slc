package org.sonson.main;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class AbstractApplication {
	public final double version = 0.01;
    protected Logger logger;
    
    public AbstractApplication() {
    	this.logger = Logger.getLogger(this.getClass());
        
        String filePath = "org/sonson/configuration/log4j.properties";
        Properties log4jFile = new Properties();
        try {
            log4jFile.load(AbstractApplication.class.getClassLoader().getResourceAsStream(filePath));
            PropertyConfigurator.configure(log4jFile);
           // logger.info("Log client initializated");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(
            		AbstractApplication.class.getName()).log(
                    java.util.logging.Level.SEVERE, "Wrong log4j properties path", ex);
        }
    }

	public Logger getLogger() {
		return logger;
	}

}
