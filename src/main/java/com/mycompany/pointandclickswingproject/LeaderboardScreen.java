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
import java.awt.Dialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JLabel;
import java.io.FileWriter;
import java.io.IOException;

       /** Class: highScore
       Purpose: Saves information for scores and initials for each entry on 
       leaderboard. **/
class highScore{
    
    public String initials;
    public int score;
    
        /** Constructor: highScore(String, int)
       Purpose: Creates highScore object, 
       * setting initials and score for object. **/
    public highScore(String enteredInitials, int enteredScore)
    {
        this.initials = enteredInitials;
        this.score = enteredScore;
    }

       /** Method: getInitials()
       Purpose: returns initials for highScore object. **/
    public String getInitials()
    {
        return initials;
    }
    
       /** Method: setInitials(String)
       Purpose: sets initials for object from input string. **/
    public void setInitials(String enteredInitials)
    {
        this.initials = enteredInitials;
    }
       /** Method: getScore()
       Purpose: returns score for highScore object. **/
    public int getScore()
    {
        return score;
    }
    
       /** Method: setScore(int)
       Purpose: sets score for object from input int. **/
    public void setScore(int enteredScore)
    {
        this.score = enteredScore;
    }
    
       /** Method: toString()
       Purpose: overrides String.toString() function for object, to specifically
       * format string with initials first and score in specific format. **/
    @Override
    public String toString()
    {
        String scoreFormat = String.format("%03d", score);
        return initials + " " + scoreFormat;
    }
    
}

public class LeaderboardScreen extends javax.swing.JPanel {

    static ArrayList<highScore> highScores = new ArrayList<highScore>();
    static boolean ignition = true;
    static String userEnteredInitials = "";
    static int userEnteredScore = 0;

    /**
     * Creates new form LeaderBoardScreen
     */
    public LeaderboardScreen() {
        initComponents();
        readThyFile();        
    }
  
      /** Method: inquiryForUser(int)
       Purpose: Makes the inquiryDialog visible, asking user if they would
       like to save their high score. **/
    
    public static void inquiryForUser(int myUserScore)
    {
        
        for(int n = 0; n < highScores.size(); n++)
        {
             if(highScores.get(n).getScore() < myUserScore)
             {
                 inquiryDialog.setLocationRelativeTo(null);
                 inquiryDialog.setVisible(true);
                 inquiryDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                 userEnteredScore = myUserScore;
                 break;
             }
        }
    }
    
       /** Method: enterInitialsHere()
       Purpose: Makes initialsDialog visible, upon clicking yes for saving
       high score in inquiryDialog. **/
    
    public void enterInitialsHere()
    {
        initialsDialog.setLocationRelativeTo(null);
        initialsDialog.setVisible(true);
        inquiryDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        
        
    }
    
//    public static void updateScoreLabel()
//    {
//        scoreLabel.setText("Score: " + userEnteredScore);
//    }
   
    /** Method: writeThyFile(int, String)
       Purpose: write to the leaderboard text file 
       with the user's score and user's initials as input.
     * @param myUserScore
     * @param myUserInitials **/
    
    public void writeThyFile(int myUserScore, String myUserInitials)
    {
        
     try {
            File myFile = new File("src/main/resources/myLeaderboard.txt");
            myFile.createNewFile();
            FileWriter myWriter = new FileWriter(myFile);            
        
       //goes through highScore ArrayList (redundancy for inquiryForUser method).
        for(int n = 0; n < highScores.size(); n++)
        {
            if(highScores.get(n).getScore() < myUserScore)
            {
                    
                //sets existing highscores lower on the list. 
                for(int x = highScores.size()-1; x > n; x--)
                {
                    System.out.println("Write File: In nested for loop...");
                    highScores.set(x, highScores.get(x-1));
                    System.out.println(highScores.toString());
                }
                //should set new highScore at current loop iteration.
                highScores.set(n, new highScore(myUserInitials, myUserScore));
                System.out.println(highScores.toString());
                break;
            }
          
        }
        //separate loop writes to the text file. 
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
     
     readThyFile();
    }
    
    /** Method: readThyFile()
       Purpose: read from the leaderboard text file, 
       * adding (or setting) initials and scores
       to an ArrayList comprised of HighScore objects. **/
    
    public void readThyFile()
    {
        int counter = 0;
        
        try {
            File myObj = new File("src/main/resources/myLeaderboard.txt");
             Scanner myReader = new Scanner(myObj);
             //while loop to run during initial construction of leadershipScreen.
                while (myReader.hasNextLine() && ignition) 
                  {
                   String data = myReader.nextLine();
                   String ghost = " ";
                   int ghoul = 0;
                   ghost = data.substring(0,3);
                   ghoul = Integer.parseInt(data.substring(4));
                    highScores.add(new highScore(ghost, ghoul));
                   System.out.println(highScores.get(counter));
                   ++counter;
                  }
                //while loop to run while program still runs. 
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
             
             
             //sets highScore objects to jLabels from file.
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

        HighScoreInquiry.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        HighScoreInquiry.setText("Would you like to save your high score?");

        YesButton.setText("Yes");
        YesButton.setToolTipText("Do it!");
        YesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YesButtonActionPerformed(evt);
            }
        });

        NoButton.setText("No");
        NoButton.setToolTipText("Are you sure?");
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

        EnterInitialsLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        EnterInitialsLabel.setText("Please enter your initials (Max 3 Letters please):");
        EnterInitialsLabel.setToolTipText("3 Letters max.");

        initialsTextField.setText("AAA");
        initialsTextField.setToolTipText("\"your name?\"");
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
        highScoreLabel.setToolTipText("\"Who's winning?\"");

        highScore2.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        highScore2.setForeground(new java.awt.Color(206, 184, 136));
        highScore2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore2.setText("ABC.....00000");
        highScore2.setToolTipText("2nd place!");
        highScore2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        highScore5.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        highScore5.setForeground(new java.awt.Color(206, 184, 136));
        highScore5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore5.setText("ABC.....00000");
        highScore5.setToolTipText("5th place!");
        highScore5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        highScore4.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        highScore4.setForeground(new java.awt.Color(206, 184, 136));
        highScore4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore4.setText("ABC.....00000");
        highScore4.setToolTipText("4th place!");
        highScore4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        highScore1.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        highScore1.setForeground(new java.awt.Color(206, 184, 136));
        highScore1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore1.setText("ABC.....00000");
        highScore1.setToolTipText("1st place!");
        highScore1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        highScore3.setFont(new java.awt.Font("Helvetica", 0, 24)); // NOI18N
        highScore3.setForeground(new java.awt.Color(206, 184, 136));
        highScore3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        highScore3.setText("ABC.....00000");
        highScore3.setToolTipText("3rd place!");
        highScore3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        backToMenu.setFont(new java.awt.Font("Helvetica", 0, 13)); // NOI18N
        backToMenu.setText("Back");
        backToMenu.setToolTipText("Back to main menu!");
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
        inquiryDialog.setVisible(false);
        enterInitialsHere();
    }//GEN-LAST:event_YesButtonActionPerformed

    private void NoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoButtonActionPerformed
        inquiryDialog.setVisible(false);
    }//GEN-LAST:event_NoButtonActionPerformed

    private void initialsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initialsTextFieldActionPerformed
      
        //no matter text entry, only first 3 letters/symbols accepted.
        //future steps: format entry only for letters.
        try{
            userEnteredInitials = initialsTextField.getText(0, 3);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        writeThyFile(userEnteredScore,userEnteredInitials);
        initialsDialog.setVisible(false);
    }//GEN-LAST:event_initialsTextFieldActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EnterInitialsLabel;
    private javax.swing.JLabel HighScoreInquiry;
    private javax.swing.JButton NoButton;
    private javax.swing.JButton YesButton;
    private javax.swing.JButton backToMenu;
    private static javax.swing.JLabel highScore1;
    private static javax.swing.JLabel highScore2;
    private static javax.swing.JLabel highScore3;
    private static javax.swing.JLabel highScore4;
    private static javax.swing.JLabel highScore5;
    private javax.swing.JLabel highScoreLabel;
    private static javax.swing.JDialog initialsDialog;
    private javax.swing.JTextField initialsTextField;
    private static javax.swing.JDialog inquiryDialog;
    // End of variables declaration//GEN-END:variables
}
