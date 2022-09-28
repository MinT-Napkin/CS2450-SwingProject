/***************************************************************  
*  file: ScoreManager.java  
*  author: M. Tran
*  class: CS 2450 – User Interface Design and Programing 
*  
*  assignment: Swing Project v1.0 
*  date last modified: 9/27/2022  
*  
*  purpose: This class contains the score and static methods meant to
*  be manipulated by all game screens
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
public class ScoreManager {
    
    private static int score;
    
    public static int getScore()
    {
        return score;
    }
    
    public static int addScore(int s)
    {
        score += s;
        return score;
    }
    
    public static int subtractScore(int s)
    {
        score -= s;
        return score;
    }
    
    public static void setScore(int s)
    {
        score = s;
    }
    
    public static void setScoreLabel(JLabel label)
    {
        label.setText("Score: " + score);
    }
}
