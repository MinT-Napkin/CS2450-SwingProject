/***************************************************************  
*  file: PointAndClickSwingProject.java  
*  author: N. Kowdle
*  class: CS 2450 – User Interface Design and Programing 
*  
*  assignment: Swing Project v1.0 
*  date last modified: 10/17/2022  
*  
*  purpose: This file is an enum to define the status of each
*  cell either being a given number or a cell that can be editable
*  
****************************************************************/  

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
}
