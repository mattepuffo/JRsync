package com.mp.jrsync;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.security.CodeSource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Classe con metodi di utlità
 *
 * @author Matteo Ferrone
 * @version 1.1
 * @since 2016-03-03
 */
public class Utils {

    /**
     * Identifica il path del jar
     *
     * @param cl Classe referente
     * @return Il path del jar
     * @throws UnsupportedEncodingException
     * @throws URISyntaxException
     */
    public static String jarPath(Class cl) throws UnsupportedEncodingException, URISyntaxException {
        CodeSource cd = cl.getProtectionDomain().getCodeSource();
        File pathJar = null;
        if (cd.getLocation() != null) {
            pathJar = new File(cd.getLocation().toURI());
        } else {
            String path = cl.getResource(cl.getSimpleName() + ".class").getPath();
            String jarFilePath = path.substring(path.indexOf(":") + 1, path.indexOf("!"));
            jarFilePath = URLDecoder.decode(jarFilePath, "UTF-8");
            pathJar = new File(jarFilePath);
        }
        return pathJar.getParentFile().getAbsolutePath();
    }

    /**
     * Converte le stringhe secondo l'algoritmo indicato
     *
     * @param convertString Stringa da convertire
     * @param algoritmo Stringa che identifica l'algoritmo
     * @return Stringa convertita
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String convert(String convertString, String algoritmo) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance(algoritmo);
        byte[] encode = md.digest(convertString.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder(encode.length * 2);
        for (int i = 0; i < encode.length; i++) {
            int v = encode[i] & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString();
    }

    /**
     * Converte una Map in Properties
     * 
     * @param map Mappa da convertire
     * @return Properties
     */
    public Properties mapToProperties(Map<String, String> map) {
        Properties prop = new Properties();
        Set<Map.Entry<String, String>> set = map.entrySet();
        set.stream().forEach((entry) -> {
            prop.put(entry.getKey(), entry.getValue());
        });
        return prop;
    }

    /**
     * Converte le Properties in Map
     * 
     * @param prop Properties da convertire
     * @return Map
     */
    public Map<String, String> propToMap(Properties prop) {
        HashMap<String, String> hashMap = new HashMap<>();
        Enumeration<Object> e = prop.keys();
        while (e.hasMoreElements()) {
            String s = (String) e.nextElement();
            hashMap.put(s, prop.getProperty(s));
        }
        return hashMap;
    }
}
