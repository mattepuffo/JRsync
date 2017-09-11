package com.mp.jrsync;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author Matteo Ferrone
 */
public class ChooseDir {

    public static String choose(JFrame frame) throws FileNotFoundException {
        JFileChooser fc = null;
        File dir = null;
        if (fc == null) {
            fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int stato = fc.showOpenDialog(frame);
            if (stato == JFileChooser.APPROVE_OPTION) {
                dir = fc.getSelectedFile();
            }
        }
        return dir.toString();
    }
}
