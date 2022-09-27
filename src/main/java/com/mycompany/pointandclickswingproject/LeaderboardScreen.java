/***************************************************************  
*  file: LeaderboardScreen.java  
*  author: G. Waughan
*  class: CS 2450 – User Interface Design and Programing 
*  
*  assignment: Swing Project v1.0 
*  date last modified: 9/21/2022  
*  
*  purpose: This program contains all the necessary components to display
*  in the Leaderboard screen
*  
****************************************************************/ 

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pointandclickswingproject;

import static com.mycompany.pointandclickswingproject.PointAndClickSwingProject.w;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JLabel;
import java.io.FileWriter;
import java.io.IOException;


class highScore{
    
    public String initials;
    public int score;
    
    public highScore(String enteredInitials, int enteredScore)
    {
        this.initials = enteredInitials;
        this.score = enteredScore;
    }
    
    
    public String getInitials()
    {
        return initials;
    }
    
    public void setInitials(String enteredInitials)
    {
        this.initials = enteredInitials;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void setScore(int enteredScore)
    {
        this.score = enteredScore;
    }
    
    @Override
    public String toString()
    {
        String scoreFormat = String.format("%03d", score);
        return initials + " " + scoreFormat;
    }
    
}

public class LeaderboardScreen extends javax.swing.JPanel {
    
    
    
   // JLabel[] myLabels = new JLabel[5];
   // String[] myInitials = new String[5];
   // static int[] myScores = new int[5];
    
    ArrayList<highScore> highScores = new ArrayList<highScore>();
    boolean ignition = true;
    /**
     * Creates new form LeaderBoardScreen
     */
    public LeaderboardScreen() {
        initComponents();
        readThyFile();
        writeThyFile();
        readThyFile();
    }
    
    public void writeThyFile()
    {
       // int myUserScore = GameScreen.getScore();
        int myUserScore = 600;
        String test = "DIA";
     try {
            File myFile = new File("src/main/resources/myLeaderboard.txt");
            myFile.createNewFile();
            FileWriter myWriter = new FileWriter(myFile);
           // myWriter.write("Files in Java might be tricky, but it is fun enough!");
            
    
       // System.out.println(myUserScore);
        for(int n = 0; n < highScores.size(); n++)
        {
            if(highScores.get(n).getScore() < myUserScore)
            {
                //insert setInitials method here.       
                //meant to push down previous high scores, should list only top 5.
                for(int x = highScores.size()-1; x > n; x--)
                {
                    highScores.set(x, highScores.get(x-1));
                    System.out.println(highScores.toString());
                }
                //should set new highScore. 
                highScores.set(n, new highScore(test, myUserScore));
                System.out.println(highScores.toString());
                break;
            }
          
        }
        
        for(int n = 0; n < highScores.size(); n++)
        {
            myWriter.write(highScores.get(n).toString() + "\n");
        }
        
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
      } 
     catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }
    
    
    public void readThyFile()
    {
        int counter = 0;
        
        try {
            //extracting file contents into JLabel Array.
            File myObj = new File("src/main/resources/myLeaderboard.txt");
             Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine() && ignition) 
                  {
                   String data = myReader.nextLine();
                   String ghost = " ";
                   int ghoul = 0;
                   ghost = data.substring(0,3);
                   ghoul = Integer.parseInt(data.substring(4));
                    highScores.add(new highScore(ghost, ghoul));
                
                //   System.out.println(data);
                  // System.out.println(ghost);
                  // System.out.println(ghoul);
                   System.out.println(highScores.get(counter));
                   ++counter;
                  }
                
                   while (myReader.hasNextLine() && !ignition) 
                  {
                   String data = myReader.nextLine();
                   String ghost = " ";
                   int ghoul = 0;
                   ghost = data.substring(0,3);
                   ghoul = Integer.parseInt(data.substring(4));
                    highScores.set(counter, new highScore(ghost,ghoul));
                
                //   System.out.println(data);
                  // System.out.println(ghost);
                  // System.out.println(ghoul);
                  System.out.println(highScores.get(counter));
                   ++counter;
                  }
             myReader.close();
             
             highScore1.setText(highScores.get(0).toString());
             highScore2.setText(highScores.get(1).toString());
             highScore3.setText(highScores.get(2).toString());
             highScore4.setText(highScores.get(3).toString());
             highScore5.setText(highScores.get(4).toString());
             
             ignition = false;
            } 

        catch (FileNotFoundException e) {
      System.out.println("File not found.");
      e.printStackTrace();
    }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        highScoreLabel1 = new javax.swing.JLabel();
        highScore6 = new javax.swing.JLabel();
        highScore7 = new javax.swing.JLabel();
        highScore8 = new javax.swing.JLabel();
        highScore9 = new javax.swing.JLabel();
        highScore10 = new javax.swing.JLabel();
        backToMenu1 = new javax.swing.JButton();
        highScoreLabel = new javax.swing.JLabel();
        highScore2 = new javax.swing.JLabel();
        highScore5 = new javax.swing.JLabel();
        highScore4 = new javax.swing.JLabel();
        highScore1 = new javax.swing.JLabel();
        highScore3 = new javax.swing.JLabel();
        backToMenu = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(1, 66, 106));

        highScoreLabel1.setFont(new java.awt.Font("Heiti TC", 1, 36)); // NOI18N
        highScoreLabel1.setForeground(new java.awt.Color(225, 181, 0));
        highScoreLabel1.setText("Leaderboard");

        highScore6.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        highScore6.setForeground(new java.awt.Color(206, 184, 136));
        highScore6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore6.setText("ABC.....00000");
        highScore6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        highScore7.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        highScore7.setForeground(new java.awt.Color(206, 184, 136));
        highScore7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore7.setText("ABC.....00000");
        highScore7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        highScore8.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        highScore8.setForeground(new java.awt.Color(206, 184, 136));
        highScore8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore8.setText("ABC.....00000");
        highScore8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        highScore9.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        highScore9.setForeground(new java.awt.Color(206, 184, 136));
        highScore9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore9.setText("ABC.....00000");
        highScore9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        highScore10.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        highScore10.setForeground(new java.awt.Color(206, 184, 136));
        highScore10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore10.setText("ABC.....00000");
        highScore10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        backToMenu1.setFont(new java.awt.Font("Helvetica", 0, 13)); // NOI18N
        backToMenu1.setText("Back");
        backToMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMenu1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(backToMenu1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(highScoreLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(highScore6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highScore9, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highScore10, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highScore8, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highScore7, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)))
                .addGap(175, 175, 175))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(highScoreLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(highScore9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highScore6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highScore10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highScore8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highScore7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(backToMenu1)
                .addGap(16, 16, 16))
        );

        setBackground(new java.awt.Color(1, 66, 106));

        highScoreLabel.setFont(new java.awt.Font("Heiti TC", 1, 36)); // NOI18N
        highScoreLabel.setForeground(new java.awt.Color(225, 181, 0));
        highScoreLabel.setText("Leaderboard");

        highScore2.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        highScore2.setForeground(new java.awt.Color(206, 184, 136));
        highScore2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore2.setText("ABC.....00000");
        highScore2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        highScore5.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        highScore5.setForeground(new java.awt.Color(206, 184, 136));
        highScore5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore5.setText("ABC.....00000");
        highScore5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        highScore4.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        highScore4.setForeground(new java.awt.Color(206, 184, 136));
        highScore4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore4.setText("ABC.....00000");
        highScore4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        highScore1.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        highScore1.setForeground(new java.awt.Color(206, 184, 136));
        highScore1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore1.setText("ABC.....00000");
        highScore1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        highScore3.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        highScore3.setForeground(new java.awt.Color(206, 184, 136));
        highScore3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore3.setText("ABC.....00000");
        highScore3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        backToMenu.setFont(new java.awt.Font("Helvetica", 0, 13)); // NOI18N
        backToMenu.setText("Back");
        backToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(backToMenu)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(highScoreLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(highScore2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highScore1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highScore3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highScore4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highScore5, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)))
                .addGap(175, 175, 175))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(highScoreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(highScore1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highScore2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highScore3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highScore4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highScore5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(backToMenu)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMenuActionPerformed
        w.switchPanes("menu"); 
    }//GEN-LAST:event_backToMenuActionPerformed

    private void backToMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backToMenu1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToMenu;
    private javax.swing.JButton backToMenu1;
    private javax.swing.JLabel highScore1;
    private javax.swing.JLabel highScore10;
    private javax.swing.JLabel highScore2;
    private javax.swing.JLabel highScore3;
    private javax.swing.JLabel highScore4;
    private javax.swing.JLabel highScore5;
    private javax.swing.JLabel highScore6;
    private javax.swing.JLabel highScore7;
    private javax.swing.JLabel highScore8;
    private javax.swing.JLabel highScore9;
    private javax.swing.JLabel highScoreLabel;
    private javax.swing.JLabel highScoreLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
