/***************************************************************  
*  file: Cell.java  
*  author: N. Kowdle
*  class: CS 2450 – User Interface Design and Programing 
*  
*  assignment: Swing Project v1.0 
*  date last modified: 10/17/2022  
*  
*  purpose: This file is a class for obj type Cell for the 
*  Sudoku game to input numbers
*  
****************************************************************/  

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pointandclickswingproject;
import java.awt.Font;
import javax.swing.JTextField;

/**
 *
 * @author Nikhil
 */
public class Cell extends JTextField {

    private static final long serialVersionUID = 1L;  // to prevent serial warning

    // Define named constants for JTextField's colors and fonts
    //  to be chosen based on CellStatus
    private static final Font FONT_NUMBERS = new Font("OCR A Extended", Font.PLAIN, 28);

    // Define properties (package-visible)
    // The row and column number [0-8] of this cell
    private int row;
    private int col;
    // The display row and column number [1-9] of this cell
    private int displayRow;
    private int displayCol;
    // The puzzle number [1-9] for this cell
    private int number;
    // The status of this cell defined in enum CellStatus
    private CellStatus status;    

    /**
     * Constructor
     * @param row
     * @param col
     */
    public Cell(int row, int col) {
        super();   // JTextField
        this.row = row;
        this.col = col;
        this.displayRow = row+1;
        this.displayCol = col+1;
        super.setHorizontalAlignment(JTextField.CENTER);
        super.setFont(FONT_NUMBERS);
        super.setToolTipText("Cell "+displayRow+", "+displayCol +"; Input a #");
    }

    /**
     * Reset this cell for a new game, given the puzzle number and isGiven
     * @param number
     * @param isGiven
     */
    public void newGame(int number, boolean isGiven) {
        this.number = number;
        status = isGiven ? CellStatus.GIVEN : CellStatus.TO_GUESS;
        paint();    // paint itself
    }

    /**
     * This Cell (JTextField) paints itself based on its status
     */
    public void paint() {
        if (status == CellStatus.GIVEN) {
            // Inherited from JTextField: Set display properties
            super.setText(number + "");
            super.setEditable(false);
        } else if (status == CellStatus.TO_GUESS) {
            // Inherited from JTextField: Set display properties
            super.setText("");
            super.setEditable(true);
        }
    }
    
    /*
    * method: getCellStatus()
    * purpose: returns CellStatus variable of the cell obj
    */
    public CellStatus getCellStatus()
    {
        return status;
    }
}
