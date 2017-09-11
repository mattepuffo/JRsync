package com.mp.jrsync;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 *
 * @author Matteo Ferrone
 */
public class FrameIstruzioni extends JFrame {

    /**
     * Creates new form FrameIstruzioni
     */
    public FrameIstruzioni() {
        initComponents();
        setLocationRelativeTo(null);
    }

//<editor-fold defaultstate="collapsed" desc=" Init Components ">
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Istruzioni");
        setResizable(false);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText(" Tipi di backup:\n -SYNCRO: sincronizza le cartella, rendendo la cartella di destinazione uguale alla cartella sorgente -> CANCELLA I FILE\n -COPY: copia tutti file nuovi o modificati, senza cancellare nulla nella cartella di destinazione\n\n Sulla parte sinistra ci sono tutti i SYNC impostati dall'utente.\n Per lanciarne uno, selezionalo e clicca sul tasto SYNC.\n Per cancellarlo, clicca con il tasto e poi clicca su Cancella.\n Per aggiungere un SYNC va su File -> Aggiungi sync.\n Nella finestra che appare devi inserire 4 dati:\n -Nome, che poi apparirà tra i SYNC disponibili\n -Tipo tra quelli a scelta\n -Sorgente, che corrisponde alla cartella di cui fare il backup\n -Destinazione, che corrisponde alla cartella in cui fare il backup\n");
        jScrollPane1.setViewportView(jTextArea1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents
//</editor-fold>


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
