/***************************************************************  
*  file: mainJFrame.java  
*  author: N. Kowdle  
*  class: CS 2450 – User Interface Design and Programing 
*  
*  assignment: program 1  
*  date last modified: 9/19/2022  
*  
*  purpose: This program displays each of the different screens of the game in a set JFrame.
*  
****************************************************************/  

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pointandclickswingproject;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * 
 */
public class MainJFrame extends javax.swing.JFrame {

    public final String SPLASH = "splash";
    public final String MENU = "menu";
    public final String LEADERBOARD = "leaderboard";
    public final String GAME = "game";
    public final String CREDITS = "credits";
    public final String GAMEOVER = "gameover";
    private final CardLayout cLayout;
    private final JPanel mainPane;
    
    /**
     * Creates new form Window
     * @param splashScreen1
     * @param menuScreen1
     * @param leaderboardScreen1
     * @param gameScreen1
     * @param creditsScreen1
     * @param gameOverScreen1
     */
    public MainJFrame(JPanel splashScreen1, 
            JPanel menuScreen1, 
            JPanel leaderboardScreen1, 
            JPanel gameScreen1, 
            JPanel creditsScreen1,
            JPanel gameOverScreen1) throws InterruptedException {
        
        setTitle("SwingBeans - Swing Project v1.0");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPane = new JPanel();
        mainPane.setPreferredSize(new Dimension(600,400));
        cLayout = new CardLayout();
        mainPane.setLayout(cLayout);

        mainPane.add(SPLASH, splashScreen1);
        mainPane.add(MENU, menuScreen1);
        mainPane.add(LEADERBOARD, leaderboardScreen1);
        mainPane.add(GAME, gameScreen1);
        mainPane.add(CREDITS, creditsScreen1);
        mainPane.add(GAMEOVER, gameOverScreen1);
        
        cLayout.show(mainPane, SPLASH);

        setLayout(new BorderLayout());
        add(mainPane,BorderLayout.CENTER);
        pack();
        setVisible(true);
        
        Timer timer = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cLayout.show(mainPane, MENU);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
 
    void switchPanes(String swap) {
        cLayout.show(mainPane, swap);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
