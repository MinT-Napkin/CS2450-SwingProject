/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pointandclickswingproject;

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
}
