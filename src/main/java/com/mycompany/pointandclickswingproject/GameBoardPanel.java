/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pointandclickswingproject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Nikhil
 */
public class GameBoardPanel extends JPanel {
   private static final long serialVersionUID = 1L;  // to prevent serial warning

   // Define named constants for the game board properties
   public static final int GRID_SIZE = 9;    // Size of the board
   public static final int SUBGRID_SIZE = 3; // Size of the sub-grid
   // Define named constants for UI sizes
   public static final int CELL_SIZE = 60;   // Cell width/height in pixels
   public static final int BOARD_WIDTH  = CELL_SIZE * GRID_SIZE;
   public static final int BOARD_HEIGHT = CELL_SIZE * GRID_SIZE;
                                             // Board width/height in pixels

   // Define properties
   /** The game board composes of 9x9 Cells (customized JTextFields) */
   private static final Cell[][] cells = new Cell[GRID_SIZE][GRID_SIZE];
   private static final boolean[][] incorrectCells = new boolean[GRID_SIZE][GRID_SIZE];
   /** It also contains a Puzzle with array numbers and isGiven */
   private static final Puzzle puzzle = new Puzzle();

   /** Constructor */
   public GameBoardPanel() {
      super.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));

      for (int row = 0; row < GRID_SIZE; ++row) {
         for (int col = 0; col < GRID_SIZE; ++col) {
            cells[row][col] = new Cell(row, col);
            super.add(cells[row][col]);   // JPanel
         }
      }
      CellInputListener listener = new CellInputListener();
      for (int row = 0; row < GRID_SIZE; ++row) {
         for (int col = 0; col < GRID_SIZE; ++col) {
            if (cells[row][col].isEditable()) {
               cells[row][col].addKeyListener(listener);   // For all editable rows and cols
            }
         }
      }

      super.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
      
      puzzle.newPuzzle();

      // Initialize all the 9x9 cells, based on the puzzle.
      for (int row = 0; row < GRID_SIZE; ++row) {
         for (int col = 0; col < GRID_SIZE; ++col) {
            cells[row][col].newGame(puzzle.numbers[row][col], puzzle.isGiven[row][col]);
         }
      }
      
      initializeIncorrectCells();
   }
   
   private static void initializeIncorrectCells()
   {
       for(int row = 0; row < GRID_SIZE; row++)
       {
           for(int col = 0; col < GRID_SIZE; col++)
           {
               incorrectCells[row][col] = false;
           }
       }
   }
   
   public static int checkSudokuSolution()
   {
       int subtractedScore = 0;
       
       for(int row = 0; row < GRID_SIZE; row++)
       {
           for(int col = 0; col < GRID_SIZE; col++)
           {
               Cell c = cells[row][col];
               int num;
               
               if(!c.getText().equals(""))
               {
                    num = (int) Integer.parseInt(c.getText());
               }
               else
               {
                    num = -1;
               }
               
               // if the specific cell is wrong
               if(c.getCellStatus() != CellStatus.GIVEN
                       && 
                       !(num == puzzle.getSolution()[row][col])
                       )
               {
                   if(!incorrectCells[row][col])
                   {
                        subtractedScore += 10;
                        incorrectCells[row][col] = true;
                   }
               }
           }
       }
       
       System.out.println("Subtracted Score after Submission: " + subtractedScore);
       
       return subtractedScore;
   }
   
   public static boolean isPerfectSudokuSolution()
   {   
       for(int row = 0; row < GRID_SIZE; row++)
       {
           for(int col = 0; col < GRID_SIZE; col++)
           {
               Cell c = cells[row][col];
               int num;
               
               if(!c.getText().equals(""))
               {
                    num = (int) Integer.parseInt(c.getText());
               }
               else
               {
                    num = -1;
               }
               
               // if the specific cell is wrong
               if(c.getCellStatus() != CellStatus.GIVEN
                       && 
                       !(num == puzzle.getSolution()[row][col])
                       )
               {
                   return false;
               }
           }
       }
       
       return true;
   }
   
   public static void resetSudokuBoard()
   {
      for (int row = 0; row < GRID_SIZE; row++) {
         for (int col = 0; col < GRID_SIZE; col++) {
            Cell c = cells[row][col];
            
            if(c.getCellStatus() != CellStatus.GIVEN)
            {
                c.setText("");
            }
         }
      }
      
      initializeIncorrectCells();
   }

   private class CellInputListener extends KeyAdapter {
      
      public void keyTyped(KeyEvent e){
          
                  Object obj = e.getSource();
        Cell c = new Cell(0, 0);
        char ch = e.getKeyChar();
        
        if (!((ch >= '0') && (ch <= '9') ||    
           (ch == KeyEvent.VK_BACK_SPACE) ||
           (ch == KeyEvent.VK_DELETE))) {

            e.consume();
            return;
          }
        
        if(obj instanceof Cell cell)
        {
            c = cell;
        }
        
        if(c.getText().length() == 1 && c.getCellStatus() != CellStatus.GIVEN)
        {
            c.setText("");
        }
      }
   }
   
}
