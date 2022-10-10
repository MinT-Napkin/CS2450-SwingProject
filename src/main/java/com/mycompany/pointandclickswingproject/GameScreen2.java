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
        gameBoardPanel1 = new com.mycompany.pointandclickswingproject.GameBoardPanel();

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

        gameBoardPanel1.setMinimumSize(new java.awt.Dimension(300, 300));
        gameBoardPanel1.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Sudoku, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(submitButton)
                                .addGap(18, 18, 18)
                                .addComponent(gameBoardPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Quit)))
                        .addGap(0, 77, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Sudoku)
                    .addComponent(time))
                .addGap(1, 1, 1)
                .addComponent(scoreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Quit)
                    .addComponent(gameBoardPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton))
                .addContainerGap(31, Short.MAX_VALUE))
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
    private com.mycompany.pointandclickswingproject.GameBoardPanel gameBoardPanel1;
    private static javax.swing.JLabel scoreLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}