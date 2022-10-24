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

/**
 *
 * @author PC
 */
public class GameManager {
    
    private static boolean status;
    
    // method: getScore()
    // purpose: return game's current status
    public static boolean getStatus()
    {
        return status;
    }
    
    // method: setStatus()
    // purpose: sets the games's status
    public static void setStatus(boolean s)
    {
        status = s;
    }
}
