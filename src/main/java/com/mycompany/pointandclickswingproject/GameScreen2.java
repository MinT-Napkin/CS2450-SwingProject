/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pointandclickswingproject;

import static com.mycompany.pointandclickswingproject.PointAndClickSwingProject.w;

/**
 *
 * @author gardyion
 */
public class GameScreen2 extends javax.swing.JPanel {

    /**
     * Creates new form GameScreen2
     */
    public GameScreen2() {
        initComponents();
        Clock clock = new Clock(time);
    }
    public static void updateScoreLabel()
    {
        ScoreManager.setScoreLabel(scoreLabel);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scoreLabel = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        Quit = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        Sudoku = new javax.swing.JLabel();

        scoreLabel.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        scoreLabel.setText("score");

        time.setBackground(new java.awt.Color(255, 255, 255));
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        time.setText("timer");
        time.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Quit.setText("Quit");
        Quit.setToolTipText("Quit the game.");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.setToolTipText("Submit your Sudoku Puzzle Solution.");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        Sudoku.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        Sudoku.setText("SUDOKU!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Sudoku)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(submitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Quit)
                .addGap(73, 73, 73))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(time)
                    .addComponent(Sudoku))
                .addGap(7, 7, 7)
                .addComponent(scoreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Quit)
                    .addComponent(submitButton))
                .addGap(49, 49, 49))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        GameOverScreen.setLabelScore(ScoreManager.getScore());
        w.switchPanes("gameover");
    }//GEN-LAST:event_QuitActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Quit;
    private javax.swing.JLabel Sudoku;
    private static javax.swing.JLabel scoreLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
