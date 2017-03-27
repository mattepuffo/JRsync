package com.mp.jrsync;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Matteo Ferrone
 */
public class ListFileProperties {

    public static ArrayList<String> getFileProperties() {
        ArrayList<String> list = new ArrayList<>();
        File dir = new File(".");
        String[] files = dir.list((File file, String name) -> {
            return name.toLowerCase().endsWith("properties");
        });
        list.addAll(Arrays.asList(files));
        Collections.sort(list);
        return list;
    }
}
