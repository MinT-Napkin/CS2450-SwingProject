/***************************************************************  
*  file: GameScreen1.java  
*  author: N. Kowdle / M. Tran / M. Flores / B. Chen
*  class: CS 2450 – User Interface Design and Programing 
*  
*  assignment: Swing Project v1.0 
*  date last modified: 9/27/2022  
*  
*  purpose: This program contains all the functionality of the Color game
*  in one screen
*  
****************************************************************/  

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pointandclickswingproject;
import static com.mycompany.pointandclickswingproject.PointAndClickSwingProject.w;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Nikhil
 */
public class GameScreen1 extends javax.swing.JPanel {
    Color red = new Color(200, 0, 0);
    Color red1 = new Color(240, 40, 40);
    Color yellow = new Color(215, 170, 53);
    Color yellow1 = new Color(255, 210, 93);
    Color green = new Color(0, 128, 0);
    Color green1 = new Color(40, 168, 40);
    Color blue = new Color(0, 64, 128);
    Color blue1 = new Color(40, 104, 168);
    Color purple = new Color(128, 0, 128);
    Color purple1 = new Color(168, 40, 168);
    
    private int attempts = 0;
    private String wordColor;
    private String correctColor;
    private Color foregroundColor;
    
    private final String[] DEFAULT_WORD_COLORS = {"red", "blue", "green", 
        "yellow", "purple"};
    
    private final Color[] foregroundColors = {red, blue, green, yellow, purple};
    
    // x restriction: 20 ~ 500
    // y restriction: 20 ~ 350
    private final int MAX_LOCATIONS = 20;
    private final ArrayList<Point> locations = new ArrayList<>(MAX_LOCATIONS);

    /**
     * Creates new form GameScreen1
     */
    public GameScreen1() {
        initComponents();
        redButton.setBackground(red);
        yellowButton.setBackground(yellow);
        greenButton.setBackground(green);
        blueButton.setBackground(blue);
        purpleButton.setBackground(purple);
        initializePossibleLocations();
        randomizeButtonLocations();
        randomizeCorrectColor();
        randomizeWordColor();
        
//        // these two should be same color / both randmoized in one new method (2)
//        correctColor = "green";
//        foregroundColor = green;
        
        colorLabel.setText(wordColor);
        colorLabel.setForeground(green);
        ScoreManager.setScoreLabel(scoreLabel);
        
        Clock clock = new Clock(time);
    }
    
    // method: updateScoreLabel()
    // purpose: update the score text from other screens
    public static void updateScoreLabel()
    {
        ScoreManager.setScoreLabel(scoreLabel);
    }
    
    // method: initializePossibleLocations()
    /*
    purpose: randomizes the possible location points the jbuttons can take
    */
    private void initializePossibleLocations()
    {
        locations.removeAll(locations);
        
        // leftmost x coord and topmost y coord
        int x = 50;
        int y = 50;
        
        for(int i = 0; i < MAX_LOCATIONS; i++)
        {
            if(y > 350)
            {
                break;
            }
            else if(x > 500)
            {
                x = 50;
                y += 100;
                
                Point p = new Point(x, y);
                locations.add(p);
                
                x += 100;
                
            }
            else
            {
                Point p = new Point(x, y);
                locations.add(p);
                
                x += 100;
                
            }
        }
    }
    
    // method: randomizeButtonLocations()
    /*
    purpose: randomizes the locations of the buttons based on the
    possible locations initialized by the initializePossibleLocations()
    */
    private void randomizeButtonLocations()
    {   
        
        for(int i = 1; i <= 5; i++)
        {
            int index = (int) Math.floor(Math.random()*locations.size());
            
            switch(i)
            {
                case 1 -> {
                    redButton.setLocation(locations.remove(index));
                }
                
                case 2 -> {
                    yellowButton.setLocation(locations.remove(index));
                }
                
                case 3 -> {
                    greenButton.setLocation(locations.remove(index));
                }
                
                case 4 -> {
                    blueButton.setLocation(locations.remove(index));
                }
                
                case 5 -> {
                    purpleButton.setLocation(locations.remove(index));
                    
//                    System.out.println("------LOCATIONS------");
//                    System.out.println(redButton.getLocation());
//                    System.out.println(yellowButton.getLocation());
//                    System.out.println(greenButton.getLocation());
//                    System.out.println(blueButton.getLocation());
//                    System.out.println(purpleButton.getLocation());
//                    System.out.println("---------------------");
                }
                    
            }
        }
        
        initializePossibleLocations();
    }

    // method: randomizeWordColor()
    /*
    purpose: Sets color label to a random color from DEFAULT_WORD_COLORS
    */
    private void randomizeWordColor()
    {
        int index = (int)Math.floor(Math.random()*DEFAULT_WORD_COLORS.length);
        wordColor = DEFAULT_WORD_COLORS[index];
        colorLabel.setText(wordColor);
    }
    
    /*
    method: randmizeCorrectColor()
    purpose: Randomizes correctColor and changes foregroundColor to match correctColor.
    */
    private void randomizeCorrectColor()
    {
        int index = (int)Math.floor(DEFAULT_WORD_COLORS.length*Math.random());
        correctColor = DEFAULT_WORD_COLORS[index];
        foregroundColor = foregroundColors[index];
        colorLabel.setForeground(foregroundColor);
    }        
    
    
    // method: checkIfCorrectButton()
    /*
    purpose: checks if the given button is the correct color to the 
    correctColor String, then adds score accordingly
    */
    private void checkIfCorrectButton(String color)
    {
        // randomize text and color methods here
        
        if(color.equals(correctColor))
        {
            ScoreManager.addScore(100);
            scoreLabel.setText("Score: " + ScoreManager.getScore());
        }
        
        attempts++;
        
        if(attempts >= 5)
        {
            GameOverScreen.setLabelScore(ScoreManager.getScore());
            w.switchPanes("gameover");
            attempts = 0; // resets the color game
        }
        
        randomizeWordColor();
        randomizeCorrectColor();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        redButton = new javax.swing.JButton();
        yellowButton = new javax.swing.JButton();
        greenButton = new javax.swing.JButton();
        blueButton = new javax.swing.JButton();
        purpleButton = new javax.swing.JButton();
        colorLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        time = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(600, 400));
        setLayout(null);

        redButton.setText("red");
        redButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                redButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                redButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                redButtonMousePressed(evt);
            }
        });
        add(redButton);
        redButton.setBounds(64, 124, 72, 23);

        yellowButton.setText("yellow");
        yellowButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                yellowButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                yellowButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                yellowButtonMousePressed(evt);
            }
        });
        add(yellowButton);
        yellowButton.setBounds(217, 124, 72, 23);

        greenButton.setText("green");
        greenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                greenButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                greenButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                greenButtonMousePressed(evt);
            }
        });
        add(greenButton);
        greenButton.setBounds(359, 124, 72, 23);

        blueButton.setText("blue");
        blueButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                blueButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                blueButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                blueButtonMousePressed(evt);
            }
        });
        add(blueButton);
        blueButton.setBounds(146, 225, 72, 23);

        purpleButton.setText("purple");
        purpleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                purpleButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                purpleButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                purpleButtonMousePressed(evt);
            }
        });
        add(purpleButton);
        purpleButton.setBounds(302, 225, 72, 23);

        colorLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        colorLabel.setText("color");
        add(colorLabel);
        colorLabel.setBounds(220, 12, 110, 30);

        scoreLabel.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        scoreLabel.setText("score");
        add(scoreLabel);
        scoreLabel.setBounds(10, 10, 190, 32);

        time.setBackground(new java.awt.Color(255, 255, 255));
        time.setText("timer");
        time.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(time);
        time.setBounds(410, 10, 180, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void redButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redButtonMouseEntered
        redButton.setBackground(red1);
//        System.out.println(jButton1.getLocation());
    }//GEN-LAST:event_redButtonMouseEntered

    private void redButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redButtonMouseExited
        redButton.setBackground(red);
    }//GEN-LAST:event_redButtonMouseExited

    private void yellowButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yellowButtonMouseEntered
        yellowButton.setBackground(yellow1);
//        System.out.println(jButton2.getLocation());
    }//GEN-LAST:event_yellowButtonMouseEntered

    private void yellowButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yellowButtonMouseExited
        yellowButton.setBackground(yellow);
    }//GEN-LAST:event_yellowButtonMouseExited

    private void greenButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_greenButtonMouseEntered
        greenButton.setBackground(green1);
//        System.out.println(jButton3.getLocation());
    }//GEN-LAST:event_greenButtonMouseEntered

    private void greenButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_greenButtonMouseExited
        greenButton.setBackground(green);
    }//GEN-LAST:event_greenButtonMouseExited

    private void blueButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blueButtonMouseEntered
        blueButton.setBackground(blue1);
//        System.out.println(jButton4.getLocation());
    }//GEN-LAST:event_blueButtonMouseEntered

    private void blueButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blueButtonMouseExited
        blueButton.setBackground(blue);
    }//GEN-LAST:event_blueButtonMouseExited

    private void purpleButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purpleButtonMouseEntered
        purpleButton.setBackground(purple1);
//        System.out.println(jButton5.getLocation());
    }//GEN-LAST:event_purpleButtonMouseEntered

    private void purpleButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purpleButtonMouseExited
        purpleButton.setBackground(purple);
    }//GEN-LAST:event_purpleButtonMouseExited

    private void redButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redButtonMousePressed
        // TODO add your handling code here:
        randomizeButtonLocations();
        checkIfCorrectButton("red");
    }//GEN-LAST:event_redButtonMousePressed

    private void yellowButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yellowButtonMousePressed
        // TODO add your handling code here:
        randomizeButtonLocations();
        checkIfCorrectButton("yellow");
    }//GEN-LAST:event_yellowButtonMousePressed

    private void greenButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_greenButtonMousePressed
        // TODO add your handling code here:
        randomizeButtonLocations();
        checkIfCorrectButton("green");
    }//GEN-LAST:event_greenButtonMousePressed

    private void blueButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blueButtonMousePressed
        // TODO add your handling code here:
        randomizeButtonLocations();
        checkIfCorrectButton("blue");
    }//GEN-LAST:event_blueButtonMousePressed

    private void purpleButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purpleButtonMousePressed
        // TODO add your handling code here:
        randomizeButtonLocations();
        checkIfCorrectButton("purple");
    }//GEN-LAST:event_purpleButtonMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton blueButton;
    private javax.swing.JLabel colorLabel;
    private javax.swing.JButton greenButton;
    private javax.swing.JButton purpleButton;
    private javax.swing.JButton redButton;
    private static javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel time;
    private javax.swing.JButton yellowButton;
    // End of variables declaration//GEN-END:variables
}
