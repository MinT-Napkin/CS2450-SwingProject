/***************************************************************  
*  file: ScoreManager1.java  
*  author: M. Tran & N. Kowdle
*  class: CS 2450 – User Interface Design and Programing 
*  
*  assignment: Swing Project v1.0 
*  date last modified: 9/27/2022  
*  
*  purpose: This class contains the pong score1 and manipulated by all pong screens
*  
****************************************************************/  

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pointandclickswingproject;

import javax.swing.JLabel;

/**
 *
 * @author PC
 */
public class ScoreManager1 {
    
    private static int score;
    
    // method: getScore()
    // purpose: return user's current score
    public static int getScore()
    {
        return score;
    }
    
    // method: addScore()
    // purpose: for games that add onto the user's score
    public static int addScore(int s)
    {
        score += s;
        return score;
    }
    
    // method: subtractScore()
    // purpose: for games that subtract the user's score
    public static int subtractScore(int s)
    {
        score -= s;
        return score;
    }
    
    // method: setScore()
    // purpose: sets the user's score 
    public static void setScore(int s)
    {
        score = s;
    }
    
    // method: setScoreLabel()
    // purpose: handles setting the text of a score label
    public static void setScoreLabel(JLabel label)
    {
        label.setText("" + score);
    }
}
