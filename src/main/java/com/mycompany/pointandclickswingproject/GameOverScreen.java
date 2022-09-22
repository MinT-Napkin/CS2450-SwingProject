/***************************************************************  
*  file: mainJFrame.java  
*  author: B. Chen  
*  class: CS 2450 – User Interface Design and Programing 
*  
*  assignment: Swing Project v1.0 
*  date last modified: 9/21/2022  
*  
*  purpose: This file contains all the necessary components for the
*  Game Over screen.
*  
****************************************************************/  

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pointandclickswingproject;
import static com.mycompany.pointandclickswingproject.PointAndClickSwingProject.w;
import javax.swing.JLabel;


public class GameOverScreen extends javax.swing.JPanel {

    /**
     * Creates new form GameOverScreen
     */
    public GameOverScreen() {
        initComponents();
    //    labelScore.setText("Score: " + GameScreen.getScore());
    }
    
    // method: getLabelScore()
    // purpose: this method returns the JLabel that is meant to display the final score
    public JLabel getLabelScore()
    {
        return labelScore;
    }
    
    // method: setLabelScore()
    // purpose: this method sets the JLabel (not the text) to another JLabel
    public static void setLabelScore(int myScore)
    {
        if(myScore == 0)
            labelScore.setText("Game over!\nYour score is 0 points.");
        
        else
            labelScore.setText ("Congratulations!\n You scored " + myScore + " points.");
        
        
        //labelScore.setText("Score: " + myScore);
    }
    
//    private String getGameOverText() {
//        if (gameMethods.getScore() == 0) {
//            return "Game over!\nYour score is 0.";
//        }
//        else {
//            return "Congratulations!\n You scored" + gameMethods.getScore() + "points.";
//        }
//           
//    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonBackToMenu = new javax.swing.JButton();
        labelScore = new javax.swing.JLabel();
        bgGameOverScreen = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonBackToMenu.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        buttonBackToMenu.setText("END");
        buttonBackToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackToMenuActionPerformed(evt);
            }
        });
        add(buttonBackToMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, -1, -1));

        labelScore.setFont(new java.awt.Font("Haettenschweiler", 0, 24)); // NOI18N
        labelScore.setText("labelScore");
        add(labelScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        bgGameOverScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgGameOver.png"))); // NOI18N
        add(bgGameOverScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 270, 330));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBackToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackToMenuActionPerformed
        // TODO add your handling code here:
        w.switchPanes("menu");
    }//GEN-LAST:event_buttonBackToMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgGameOverScreen;
    private javax.swing.JButton buttonBackToMenu;
    static javax.swing.JLabel labelScore;
    // End of variables declaration//GEN-END:variables
}
