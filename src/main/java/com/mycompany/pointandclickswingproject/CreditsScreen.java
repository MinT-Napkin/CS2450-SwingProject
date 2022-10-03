/***************************************************************  
*  file: CreditsScreen.java  
*  author: G. Waughan
*  class: CS 2450 – User Interface Design and Programing 
*  
*  assignment: Swing Project v1.0 
*  date last modified: 9/21/2022  
*  
*  purpose: This program contains all the necessary components to display
*  in the Credits screen
*  
****************************************************************/  

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pointandclickswingproject;

import static com.mycompany.pointandclickswingproject.PointAndClickSwingProject.w;

public class CreditsScreen extends javax.swing.JPanel {

    /**
     * Creates new form CreditsScreen
     */
    public CreditsScreen() {
        initComponents();
    }
  
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

        setBackground(new java.awt.Color(1, 66, 106));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Heiti TC", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(225, 181, 0));
        jLabel1.setText("Credits:");
        jLabel1.setToolTipText("The Stars of our game!");

        backButton.setFont(new java.awt.Font("Helvetica", 0, 13)); // NOI18N
        backButton.setText("Back");
        backButton.setToolTipText("Back to main menu.");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        MinhCredit.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        MinhCredit.setForeground(new java.awt.Color(206, 184, 136));
        MinhCredit.setText("Minh Tran, 015051140");
        MinhCredit.setToolTipText("Codename: MinT");

        BenCredit.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        BenCredit.setForeground(new java.awt.Color(206, 184, 136));
        BenCredit.setText("Benjamin Chen, 015393066");
        BenCredit.setToolTipText("Codename: uu");

        NikhilCredit.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        NikhilCredit.setForeground(new java.awt.Color(206, 184, 136));
        NikhilCredit.setText("Nikhil Kowdle, 013608413");
        NikhilCredit.setToolTipText("Codename: Stormwolf");

        MartinCredit.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        MartinCredit.setForeground(new java.awt.Color(206, 184, 136));
        MartinCredit.setText("Martin Flores, 014072422");
        MartinCredit.setToolTipText("Codename: martin_418");

        GarethCredit.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        GarethCredit.setForeground(new java.awt.Color(206, 184, 136));
        GarethCredit.setText("Gareth G. Waughan, 013289471");
        GarethCredit.setToolTipText("Codename: Gary Primey");

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
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(BenCredit)
                .addGap(12, 12, 12)
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
    // End of variables declaration//GEN-END:variables
}
