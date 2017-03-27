package com.mp.jrsync;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Matteo Ferrone
 */
public class JRsync extends JFrame {

    private final CustomActionListener cal;
    private Process p;
    private StartSync ss;
    private ArrayList<String> listProperties;
    private DefaultListModel<String> model;
    private Utils utils;

    /**
     * Creates new form JRsync
     */
    public JRsync() {
        cal = new CustomActionListener();
        model = new DefaultListModel<>();
        utils = new Utils();
        riempiList();
        initComponents();
        setLocationRelativeTo(null);
        itemExit.addActionListener(cal);
        itemSync.addActionListener(cal);
        itemAbout.addActionListener(cal);
        itemIstruzioni.addActionListener(cal);
        btnSync.addActionListener(cal);
        jListProperties.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (SwingUtilities.isRightMouseButton(me) && !jListProperties.isSelectionEmpty() && jListProperties.locationToIndex(me.getPoint()) == jListProperties.getSelectedIndex()) {
                    JPopupMenu popupMenu = new JPopupMenu();
                    JMenuItem ir = new JMenuItem("Cancella");
                    popupMenu.add(ir);
                    popupMenu.show(jListProperties, me.getX(), me.getY());
                    ir.addActionListener((ActionEvent ae) -> {
                        File f = new File(jListProperties.getSelectedValue().toLowerCase() + ".properties");
                        if (f.exists()) {
                            f.delete();
                            model.removeElementAt(jListProperties.getSelectedIndex());
                        }
                    });
                }
            }
        });
    }

    //<editor-fold defaultstate="collapsed" desc=" Init Components ">
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanel2 = new JPanel();
        btnSync = new JButton();
        jPanel3 = new JPanel();
        jScrollPane3 = new JScrollPane();
        jListProperties = new JList<>();
        jScrollPane4 = new JScrollPane();
        areaOutput = new JTextArea();
        jMenuBar1 = new JMenuBar();
        menuFile = new JMenu();
        itemSync = new JMenuItem();
        itemExit = new JMenuItem();
        menuAbout = new JMenu();
        itemAbout = new JMenuItem();
        itemIstruzioni = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnSync.setText("Sync");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSync)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSync)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jListProperties.setModel(model);
        jScrollPane3.setViewportView(jListProperties);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );

        areaOutput.setColumns(20);
        areaOutput.setRows(5);
        jScrollPane4.setViewportView(areaOutput);

        menuFile.setText("File");

        itemSync.setText("Aggiungi SYNC");
        itemSync.setToolTipText("");
        menuFile.add(itemSync);

        itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
        itemExit.setText("Exit");
        menuFile.add(itemExit);

        jMenuBar1.add(menuFile);

        menuAbout.setText("?");

        itemAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_QUOTE, InputEvent.CTRL_MASK));
        itemAbout.setText("About");
        menuAbout.add(itemAbout);

        itemIstruzioni.setText("Istruzioni");
        menuAbout.add(itemIstruzioni);

        jMenuBar1.add(menuAbout);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)))
        );

        pack();
    }//GEN-END:initComponents
//</editor-fold>

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        } else {
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

        EventQueue.invokeLater(() -> {
            new JRsync().setVisible(true);
        });
    }

    private void riempiList() {
        if (listProperties != null) {
            listProperties.clear();
        }
        listProperties = ListFileProperties.getFileProperties();
        model.clear();
        listProperties.stream().forEach((s) -> {
            String noExt = FilenameUtils.removeExtension(s);
            model.addElement(noExt.toUpperCase());
        });
    }

    private void start(String cmd) {
        try {
            p = Runtime.getRuntime().exec(cmd);
            ss.commence(p);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private class CustomActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ev) {
            Object source = ev.getSource();
            if (source == itemExit) {
                dispose();
            } else if (source == itemSync) {
                FrameAggiungi fa = new FrameAggiungi();
                fa.setVisible(true);
                fa.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent ev) {
                        riempiList();
                    }
                });
            } else if (source == btnSync) {
                String selected = jListProperties.getSelectedValue();
                if (StringUtils.isNotBlank(selected)) {
                    try {
                        ss = new StartSync(areaOutput, btnSync);
                        HashMap<String, String> map = ConfigurationProperties.getProperties(selected);
                        String command = utils.mapToProperties(map).getProperty("comando");
                        String from = utils.mapToProperties(map).getProperty("dir_from");
                        String to = utils.mapToProperties(map).getProperty("dir_to");
                        command += from + " " + to;
                        start(command);
                    } catch (IOException | URISyntaxException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            } else if (source == itemAbout) {
                FrameAbout fa = new FrameAbout();
                fa.setVisible(true);
            } else if (source == itemIstruzioni) {
                FrameIstruzioni fa = new FrameIstruzioni();
                fa.setVisible(true);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextArea areaOutput;
    private JButton btnSync;
    private JMenuItem itemAbout;
    private JMenuItem itemExit;
    private JMenuItem itemIstruzioni;
    private JMenuItem itemSync;
    private JList<String> jListProperties;
    private JMenuBar jMenuBar1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JMenu menuAbout;
    private JMenu menuFile;
    // End of variables declaration//GEN-END:variables
}
