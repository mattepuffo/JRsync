package com.mp.jrsync;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 *
 * @author Matteo Ferrone
 *
 */
public class StartSync implements Runnable {

    protected final JTextArea area;
    protected final JButton btn;
    protected Reader reader = null;
    private Thread thread;

    public StartSync(JTextArea area, JButton btn) {
        this.area = area;
        this.btn = btn;
    }

    public void commence(Process p) {
        InputStream in = p.getInputStream();
        reader = new InputStreamReader(in);
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();
        btn.setEnabled(false);
        try {
            while (reader != null) {
                int c = reader.read();
                if (c == -1) {
                    return;
                }
                sb.append((char) c);
                setText(sb.toString());
            }
        } catch (IOException ex) {
            sb.append("\n\nERROR:\n").append(ex.toString());
            setText(sb.toString());
        } finally {
            try {
                reader.close();
                sb.append("\n").append("SYNC COMPLETATO");
                setText(sb.toString());
                setTextLink("");
            } catch (IOException ex) {
                sb.append(ex.getMessage());
            }
        }
    }

    public void stop() {
        thread.interrupt();
        setText("SYNC CANCELLATO");
    }

    private void setText(final String text) {
        EventQueue.invokeLater(() -> {
            area.setText(text);
        });
    }

    private void setTextLink(final String text) {
        EventQueue.invokeLater(() -> {
            btn.setEnabled(true);
        });
    }
}
