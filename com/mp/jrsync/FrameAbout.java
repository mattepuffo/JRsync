package com.mp.jrsync;

import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *
 * @author Matteo Ferrone
 */
public class FrameAbout extends JFrame {

    /**
     * Creates new form FrameAbout
     */
    public FrameAbout() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code"> 
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanel1 = new JPanel();
        lblTitle = new JLabel();
        lblAuthor = new JLabel();
        lblSite = new JLabel();
        lblBlog = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        setResizable(false);

        jPanel1.setBackground(new Color(0, 0, 0));

        lblTitle.setBackground(new Color(0, 0, 0));
        lblTitle.setFont(new Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setForeground(new Color(0, 153, 255));
        lblTitle.setHorizontalAlignment(SwingConstants.TRAILING);
        lblTitle.setText("Mattepuffo JRsync");
        lblTitle.setVerifyInputWhenFocusTarget(false);

        lblAuthor.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        lblAuthor.setForeground(new Color(0, 153, 255));
        lblAuthor.setHorizontalAlignment(SwingConstants.TRAILING);
        lblAuthor.setText("Author: Matteo Ferrone");
        lblAuthor.setToolTipText("");

        lblSite.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        lblSite.setForeground(new Color(0, 153, 255));
        lblSite.setHorizontalAlignment(SwingConstants.TRAILING);
        lblSite.setText("Web Site: www.matteoferrone.com");
        lblSite.setToolTipText("");

        lblBlog.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        lblBlog.setForeground(new Color(0, 153, 255));
        lblBlog.setHorizontalAlignment(SwingConstants.TRAILING);
        lblBlog.setText("Blog: www.mattepuffo.com");
        lblBlog.setToolTipText("");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitle, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAuthor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblSite, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(lblBlog, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAuthor)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSite)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBlog)
                .addGap(0, 53, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 173, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents
    //</editor-fold>

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel jPanel1;
    private JLabel lblAuthor;
    private JLabel lblBlog;
    private JLabel lblSite;
    private JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
