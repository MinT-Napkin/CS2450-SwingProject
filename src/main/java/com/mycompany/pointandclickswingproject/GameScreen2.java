/***************************************************************  
*  file: GameScreen2.java  
*  author: G. Waughan / N. Kowdle / M. Tran / B. Chen
*  class: CS 2450 – User Interface Design and Programing 
*  
*  assignment: Swing Project v1.0 
*  date last modified: 10/17/2022  
*  
*  purpose: This file is a class file to define the panel for the
*  sudoku game board which includes 81 cells and a hard coded puzzle
****************************************************************/  


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pointandclickswingproject;

import static com.mycompany.pointandclickswingproject.PointAndClickSwingProject.w;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author gardyion
 */
public class GameScreen2 extends javax.swing.JPanel {
    
    private final int INITIAL_ADDEDSCORE = 540;
    private int addedScore;
    
    private final Timer alertTimer;
    
    /**
     * Creates new form GameScreen2
     */
    public GameScreen2() {
        initComponents();
        Clock clock = new Clock(time);
        addedScore = INITIAL_ADDEDSCORE;
        addScoreLabel.setText("+" + addedScore);
        
        alert.setVisible(false);
        this.alertTimer = new Timer (2000, updateAlert);
    }
    
    // action listener: updateAlert
    /* purpose: this action listener is meant for a timer of the alert
    * after the incorrect letter was picked, which makes the alert disappear
    * after a certain amount of time
    */
    ActionListener updateAlert = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            alert.setVisible(false);
        }
    };
    
    /*
    * method: updateScoreLabel()
    * purpose: updates scoreLabel
    */
    public static void updateScoreLabel()
    {
        ScoreManager.setScoreLabel(scoreLabel);
    }
    
    private void updateAddScoreLabel(int subtract)
    {
        addedScore -= subtract;
        
        if(addedScore <= 0)
        {
            addedScore = 0;
            addScoreLabel.setText("+" + addedScore);
        }
        else
        {
            addScoreLabel.setText("+" + addedScore);
        }
    }
    
    /*
    * method: endGame()
    * purpose: goes to the Game Over screen and resets any necessary variables
    */
    private void endGame()
    {
        ScoreManager.addScore(addedScore);
        System.out.println(ScoreManager.getScore());
        GameOverScreen.setLabelScore(ScoreManager.getScore());
//        LeaderboardScreen.updateScoreLabel();
        w.switchPanes("gameover");
        addedScore = 540;
        addScoreLabel.setText("+" + addedScore);
        GameBoardPanel.resetSudokuBoard();
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
        addScoreLabel = new javax.swing.JLabel();
        alert = new javax.swing.JLabel();

        scoreLabel.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        scoreLabel.setText("score");

        time.setBackground(new java.awt.Color(255, 255, 255));
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        time.setText("timer");
        time.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Quit.setText("Quit");
        Quit.setToolTipText("Quit the game. (You will get 0 points from this game)");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.setToolTipText("Submit your Sudoku Puzzle Solution. \n(-10 for each cell the first time you get wrong)\n(Score will be added once you find the perfect solution)");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        Sudoku.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        Sudoku.setText("SUDOKU!");

        gameBoardPanel1.setMinimumSize(new java.awt.Dimension(300, 300));
        gameBoardPanel1.setPreferredSize(new java.awt.Dimension(300, 300));

        addScoreLabel.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 18)); // NOI18N
        addScoreLabel.setText("jLabel1");

        alert.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        alert.setForeground(new java.awt.Color(255, 0, 51));
        alert.setText("INCORRECT SOLUTION");
        alert.setToolTipText("\"Oops!\"");

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
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(submitButton)
                            .addComponent(addScoreLabel))
                        .addGap(34, 34, 34)
                        .addComponent(gameBoardPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(Quit)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(alert)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Sudoku)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(scoreLabel)
                            .addComponent(alert)))
                    .addComponent(time))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(addScoreLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(submitButton))
                        .addComponent(gameBoardPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Quit, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed

        addedScore = 0;
        endGame();
    }//GEN-LAST:event_QuitActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        
        int subtractedScore = GameBoardPanel.checkSudokuSolution();
        
        updateAddScoreLabel(subtractedScore);
        
        if(GameBoardPanel.isPerfectSudokuSolution())
        {
           // perfect solution
           endGame();
        }
        else
        {
            // solution is wrong, alert them that they got it wrong!
            alertTimer.setRepeats(false);

            if(!alert.isVisible())
            {
                alert.setVisible(true);
                alertTimer.start();
            }
            else
            {
                alert.setVisible(true);
                alertTimer.restart();
            }
        }
    }//GEN-LAST:event_submitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Quit;
    private javax.swing.JLabel Sudoku;
    private javax.swing.JLabel addScoreLabel;
    private javax.swing.JLabel alert;
    private com.mycompany.pointandclickswingproject.GameBoardPanel gameBoardPanel1;
    private static javax.swing.JLabel scoreLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
