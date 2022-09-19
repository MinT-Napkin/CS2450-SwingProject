/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pointandclickswingproject;

import static com.mycompany.pointandclickswingproject.PointAndClickSwingProject.w;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author Nikhil
 */
public class CreditsScreen extends javax.swing.JPanel {

    /**
     * Creates new form CreditsScreen
     */
    public CreditsScreen() {
        initComponents();
        Timer myTimer = new Timer (100, updateClock);
        myTimer.start();
    }
        ActionListener updateClock = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            SimpleDateFormat sdf = new SimpleDateFormat( "MMMMMMMMM dd, yyyy hh:mm:ss");
            testDate.setText(sdf.format(new Date())); 
        }
    };



  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
            
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        MinhCredit = new javax.swing.JLabel();
        BenCredit = new javax.swing.JLabel();
        NikhilCredit = new javax.swing.JLabel();
        MartinCredit = new javax.swing.JLabel();
        GarethCredit = new javax.swing.JLabel();
        testDate = new javax.swing.JLabel();

        setBackground(new java.awt.Color(1, 66, 106));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Heiti TC", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(225, 181, 0));
        jLabel1.setText("Credits:");

        backButton.setFont(new java.awt.Font("Helvetica", 0, 13)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        MinhCredit.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        MinhCredit.setForeground(new java.awt.Color(206, 184, 136));
        MinhCredit.setText("Minh Tran, 015051140");

        BenCredit.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        BenCredit.setForeground(new java.awt.Color(206, 184, 136));
        BenCredit.setText("Benjamin Chen, (Bronco ID)");

        NikhilCredit.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        NikhilCredit.setForeground(new java.awt.Color(206, 184, 136));
        NikhilCredit.setText("Nikhil Kowdle, 013608413");

        MartinCredit.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        MartinCredit.setForeground(new java.awt.Color(206, 184, 136));
        MartinCredit.setText("Martin Flores, (Bronco ID)");

        GarethCredit.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        GarethCredit.setForeground(new java.awt.Color(206, 184, 136));
        GarethCredit.setText("Gareth G. Waughan, 013289471");

        testDate.setForeground(new java.awt.Color(255, 255, 255));
        testDate.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BenCredit)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MartinCredit)
                                    .addComponent(NikhilCredit)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(MinhCredit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(GarethCredit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel1)))
                .addContainerGap(137, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(testDate, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(testDate)
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(BenCredit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MartinCredit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NikhilCredit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MinhCredit)
                .addGap(12, 12, 12)
                .addComponent(GarethCredit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
            w.switchPanes("menu");        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BenCredit;
    private javax.swing.JLabel GarethCredit;
    private javax.swing.JLabel MartinCredit;
    private javax.swing.JLabel MinhCredit;
    private javax.swing.JLabel NikhilCredit;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel testDate;
    // End of variables declaration//GEN-END:variables
}
