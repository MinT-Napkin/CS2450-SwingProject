/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pointandclickswingproject;

/**
 *
 * @author Nikhil
 */
public enum CellStatus {
   GIVEN,         // clue, no need to guess
   TO_GUESS,      // need to guess - not attempted yet
      // The puzzle is solved if none of the cells have 
      //  status of TO_GUESS or WRONG_GUESS
}
