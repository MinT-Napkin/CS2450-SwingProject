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
        inquiryDialog.setVisible(true);
        initialsDialog.setVisible(true);
        
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

        inquiryDialog = new javax.swing.JDialog();
        HighScoreInquiry = new javax.swing.JLabel();
        YesButton = new javax.swing.JButton();
        NoButton = new javax.swing.JButton();
        initialsDialog = new javax.swing.JDialog();
        EnterInitialsLabel = new javax.swing.JLabel();
        initialsTextField = new javax.swing.JTextField();
        highScoreLabel = new javax.swing.JLabel();
        highScore2 = new javax.swing.JLabel();
        highScore5 = new javax.swing.JLabel();
        highScore4 = new javax.swing.JLabel();
        highScore1 = new javax.swing.JLabel();
        highScore3 = new javax.swing.JLabel();
        backToMenu = new javax.swing.JButton();

        inquiryDialog.setMinimumSize(new java.awt.Dimension(600, 400));
        inquiryDialog.setPreferredSize(new java.awt.Dimension(600, 400));

        HighScoreInquiry.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        HighScoreInquiry.setText("Would you like to save your high score?");

        YesButton.setText("Yes");
        YesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YesButtonActionPerformed(evt);
            }
        });

        NoButton.setText("No");
        NoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inquiryDialogLayout = new javax.swing.GroupLayout(inquiryDialog.getContentPane());
        inquiryDialog.getContentPane().setLayout(inquiryDialogLayout);
        inquiryDialogLayout.setHorizontalGroup(
            inquiryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inquiryDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(YesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(NoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
            .addGroup(inquiryDialogLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(HighScoreInquiry)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        inquiryDialogLayout.setVerticalGroup(
            inquiryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inquiryDialogLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(HighScoreInquiry)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addGroup(inquiryDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(YesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );

        initialsDialog.setAutoRequestFocus(false);
        initialsDialog.setMinimumSize(new java.awt.Dimension(600, 400));
        initialsDialog.setPreferredSize(new java.awt.Dimension(600, 400));

        EnterInitialsLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        EnterInitialsLabel.setText("Please enter your initials (Max 3 Letters please):");

        initialsTextField.setText("AAA");
        initialsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initialsTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout initialsDialogLayout = new javax.swing.GroupLayout(initialsDialog.getContentPane());
        initialsDialog.getContentPane().setLayout(initialsDialogLayout);
        initialsDialogLayout.setHorizontalGroup(
            initialsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(initialsDialogLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(initialsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, initialsDialogLayout.createSequentialGroup()
                        .addComponent(EnterInitialsLabel)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, initialsDialogLayout.createSequentialGroup()
                        .addComponent(initialsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(206, 206, 206))))
        );
        initialsDialogLayout.setVerticalGroup(
            initialsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(initialsDialogLayout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addComponent(EnterInitialsLabel)
                .addGap(92, 92, 92)
                .addComponent(initialsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(highScore2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highScore1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highScore3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highScore4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highScore5, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(highScoreLabel))
                .addGap(175, 175, 175))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(highScoreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highScore1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highScore2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highScore3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highScore4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highScore5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(backToMenu)
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMenuActionPerformed
        w.switchPanes("menu"); 
    }//GEN-LAST:event_backToMenuActionPerformed

    private void YesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YesButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YesButtonActionPerformed

    private void NoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoButtonActionPerformed

    private void initialsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initialsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initialsTextFieldActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EnterInitialsLabel;
    private javax.swing.JLabel HighScoreInquiry;
    private javax.swing.JButton NoButton;
    private javax.swing.JButton YesButton;
    private javax.swing.JButton backToMenu;
    private javax.swing.JLabel highScore1;
    private javax.swing.JLabel highScore2;
    private javax.swing.JLabel highScore3;
    private javax.swing.JLabel highScore4;
    private javax.swing.JLabel highScore5;
    private javax.swing.JLabel highScoreLabel;
    private javax.swing.JDialog initialsDialog;
    private javax.swing.JTextField initialsTextField;
    private javax.swing.JDialog inquiryDialog;
    // End of variables declaration//GEN-END:variables
}
