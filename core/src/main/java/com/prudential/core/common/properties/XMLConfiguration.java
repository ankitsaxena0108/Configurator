package com.prudential.core.common.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Represents unmarshalled XML Configuration specified via XML configuration file.
 * The file is searched in the following locations:
 * <ol>
 *  <li>Configuration Folder specified via -DconfigLocation</li>
 *  <li>Folder specified in External Classpath (of WebServer)</li>
 *  <li>WEB-INF/classes</li>
 * </ol>
 */
public class XMLConfiguration<T> {
    public static final String CONFIG_LOCATION = "configLocation";

    private static final Logger logger = LoggerFactory.getLogger(XMLConfiguration.class);

    private String configLocation;
    private String fileName = null;
    private Class<T> fileClazz;

    public XMLConfiguration(String fileName, Class<T> fileClazz) {
        if (StringUtils.isEmpty(fileName)) {
            throw new IllegalArgumentException("No fileName specified");
        }

        if (fileClazz == null) {
            throw new IllegalArgumentException("Class parameter required to read XML Configuration file");
        }

        this.fileName = fileName;
        this.fileClazz  = fileClazz;
        configLocation = System.getProperty(CONFIG_LOCATION);
    }

    public T value() {
        Object jaxbObject = null;
        InputStream is = null;

        try {
            is = locateInputStream();
            JAXBContext jaxbContext = JAXBContext.newInstance(fileClazz);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            jaxbObject = jaxbUnmarshaller.unmarshal(is);
            return fileClazz.cast(jaxbObject);
        } catch (Exception e) {
            logger.warn("Failed to find {}, default configuration applicable", fileName);
        }
        finally {
            closeSilently(is);
        }

        return null;
    }


    private InputStream locateInputStream() throws IOException {
        InputStream is = null;
        URL resource = null;

        try {
            if (StringUtils.hasText(configLocation)) {
                File configFolder = new File(configLocation);
                if (configFolder.isDirectory()) {
                    File file = new File(configFolder, fileName);
                    is = new FileInputStream(file);
                    logger.info("Loading {} from path {}", fileName, configLocation);
                }
                else {
                    throw new IOException("[" + CONFIG_LOCATION + "] does not point to a folder, please check again. Trying alternate... ");
                }
            }
            else {
                logger.info("Failed to find property [-D"+ CONFIG_LOCATION +"] to define the location of config folder, trying alternate...");
            }
        } catch (Exception e) {
            logger.debug("Failed to read {}, trying alternate...", fileName, e);
        }

        try {
            resource = this.getClass().getClassLoader().getParent().getResource(fileName);
            if (resource != null) {
                is = this.getClass().getClassLoader().getParent().getResourceAsStream(fileName);
                logger.info("Loading ["+fileName+"] from path: "+resource);
            }
        } catch (Exception e) {
            logger.debug("Failed to read ["+fileName+"], trying alternate...", e);
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
            logger.debug("Failed to read ["+fileName+"], trying alternate...", e);
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

    private void closeSilently(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                logger.warn("Failed to close open InputStream for ["+fileName+"]");
            }
        }
    }
}
