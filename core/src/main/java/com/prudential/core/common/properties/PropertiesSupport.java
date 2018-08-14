package com.prudential.core.common.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public abstract class PropertiesSupport {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesSupport.class);
    private static final String CBI_CONFIG = "CBIConfig";
    private final String configLocation;
    private static Map<String, Properties> loadedProperties;

    public PropertiesSupport() {
        super();
        configLocation = System.getProperty(CBI_CONFIG);
        loadedProperties = new HashMap<>();
    }
    
    public abstract String get(String property);

    protected void loadProperties(String fileName, Properties properties) {
        if (loadedProperties.containsKey(fileName)) {
            properties.putAll(loadedProperties.get(fileName));
        }
        else {
            InputStream is = null;
            try {
                is = locateInputStream(fileName);
                properties.load(is);
                loadedProperties.put(fileName, properties);
            } catch (Exception e) {
                throw new IllegalArgumentException("Failed to initialize using file [" + fileName + "]");
            }
            finally {
                closeSilently(is, fileName);
            }
        }
    }

    protected InputStream locateInputStream(String fileName) throws IOException {
        InputStream is = null;
        URL resource = null;
        
        try {
            if (StringUtils.hasText(configLocation)) {
                File configFolder = new File(configLocation);
                if (configFolder.isDirectory()) {
                    File configFile = new File(configFolder, fileName);
                    is = new FileInputStream(configFile);
                    logger.info("Loading ["+fileName+"] from path: "+configLocation);
                }
                else {
                    throw new IOException("[" + CBI_CONFIG + "] does not point to a folder, please check again. Trying alternate... ");
                }
            }
            else {
                logger.info("Failed to find property [-D"+CBI_CONFIG+"] to define the location of config folder, trying alternate...");
            }
        } catch (Exception e) {
            logger.debug("Failed to read ["+fileName+"], trying alternate...");
        }
        
        try {
            resource = this.getClass().getClassLoader().getParent().getResource(fileName);
            if (resource != null) {
                is = this.getClass().getClassLoader().getParent().getResourceAsStream(fileName);
                logger.info("Loading ["+fileName+"] from path: "+resource);
            } 
        } catch (Exception e) {
            logger.debug("Failed to read ["+fileName+"], trying alternate...");
        }
        
        try {
            if (is == null) {
                resource = this.getClass().getClassLoader().getResource(fileName);
                if (resource != null) {
                    is = this.getClass().getClassLoader().getResourceAsStream(fileName);
                    logger.info("Loading ["+fileName+"] from path: "+resource);
                }
            }
        } catch (Exception e) {
            logger.debug("Failed to read ["+fileName+"], trying alternate...");
        }
        
        
        try {
            if (is == null) {
                resource = Thread.currentThread().getContextClassLoader().getResource(fileName);
                if (resource != null) {
                    is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
                    logger.info("Loading ["+fileName+"] from path: "+resource);
                }
            }
        } catch (Exception e) {
            logger.debug("Failed to read ["+fileName+"], raising error", e);
        }
        
        if (is != null) {
            return is;
        }
    
        throw new IOException("Failed to locate ["+fileName+"]");
    }

    private void closeSilently(InputStream is, String fileName) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                logger.warn("Failed to close open InputStream for ["+fileName+"]");
            }
        }
    }

}