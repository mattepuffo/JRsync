package com.mp.jrsync;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Matteo Ferrone
 */
public class FrameAggiungi extends JFrame {

    private final CustomActionListener cal;
    private ArrayList<SyncType> listType;
    private DefaultComboBoxModel model;

    /**
     * Creates new form FrameAggiungi
     */
    public FrameAggiungi() {
        cal = new CustomActionListener();
        listType = new ArrayList<>();
        listType.add(new SyncType("SCEGLI...", "*"));
        listType.add(new SyncType("SYNCRO", "rsync -av --delete "));
        listType.add(new SyncType("COPY", "rsync -av "));
        model = new DefaultComboBoxModel(listType.toArray());
        initComponents();
        setLocationRelativeTo(null);
        btnFrom.addActionListener(cal);
        btnTo.addActionListener(cal);
        btnOk.addActionListener(cal);
    }

    //<editor-fold defaultstate="collapsed" desc=" Init Components ">
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        txtFrom = new JTextField();
        btnFrom = new JButton();
        txtTo = new JTextField();
        btnTo = new JButton();
        btnOk = new JButton();
        txtNome = new JTextField();
        comboType = new JComboBox<>();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setResizable(false);

        txtFrom.setEnabled(false);

        btnFrom.setText("Sorgente");

        txtTo.setEnabled(false);

        btnTo.setText("Destinazione");

        btnOk.setText("OK");

        comboType.setModel(model);

        jLabel1.setText("Nome");

        jLabel2.setText("Tipo Sync");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(comboType, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTo)
                    .addComponent(txtFrom, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnOk)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtNome))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnTo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFrom, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(comboType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFrom))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTo))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOk)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents
//</editor-fold>

    private class CustomActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ev) {
            Object source = ev.getSource();
            if (source == btnOk) {
                SyncType st = (SyncType) comboType.getSelectedItem();
                String nome = txtNome.getText();
                String from = txtFrom.getText();
                String to = txtTo.getText();
                String comando = st.getComando();
                if (StringUtils.isNotBlank(nome) && StringUtils.isNotBlank(from) && StringUtils.isNotBlank(to) && !comando.equals("*")) {
                    try {
                        File f = new File(nome.toLowerCase() + ".properties");
                        if (f.createNewFile()) {
                            ConfigurationProperties.setProperties("dir_from", from, nome);
                            ConfigurationProperties.setProperties("dir_to", to, nome);
                            ConfigurationProperties.setProperties("comando", comando, nome);
                        }
                    } catch (IOException | URISyntaxException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
                dispose();
            } else if (source == btnFrom) {
                try {
                    txtFrom.setText(ChooseDir.choose(FrameAggiungi.this) + "/");
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } else if (source == btnTo) {
                try {
                    txtTo.setText(ChooseDir.choose(FrameAggiungi.this));
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnFrom;
    private JButton btnOk;
    private JButton btnTo;
    private JComboBox<String> comboType;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField txtFrom;
    private JTextField txtNome;
    private JTextField txtTo;
    // End of variables declaration//GEN-END:variables
}
