package com.mp.jrsync;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author Matteo Ferrone
 * @since 2015-05-29
 */
public class ConfigurationProperties {

    /**
     * Legge le voci nel file di properties selezionato
     *
     * @param file Nome del file di proerties
     * @return HashMap<String, String> Mappa chiave -> valore delle voci
     * @throws IOException
     * @throws URISyntaxException
     */
    public static synchronized HashMap<String, String> getProperties(String file) throws IOException, URISyntaxException {
        File fileProperties = new File(file + ".properties");
        HashMap<String, String> map = new HashMap<>();
        Properties props = new Properties();
        props.load(new FileInputStream(fileProperties));
        props.stringPropertyNames().stream().forEach((name) -> {
            map.put(name, props.getProperty(name));
        });
        return map;
    }

    /**
     * Setta le voci del file di properties
     *
     * @param file Nome del file di proerties
     * @param key
     * @param value
     * @throws IOException
     * @throws URISyntaxException
     */
    public static synchronized void setProperties(String key, String value, String file) throws IOException, URISyntaxException {
        File fileProperties = new File(file + ".properties");
        Properties properties = new Properties();
        properties.load(new FileInputStream(fileProperties));
        properties.setProperty(key, value);
        properties.store(new FileOutputStream(fileProperties, false), null);
    }
}
