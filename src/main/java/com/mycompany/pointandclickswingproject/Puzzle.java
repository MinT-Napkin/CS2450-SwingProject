/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pointandclickswingproject;

/**
 *
 * @author Nikhil
 */
public class Puzzle {
   // All variables have package access
   // The numbers on the puzzle
   int[][] numbers = new int[GameBoardPanel.GRID_SIZE][GameBoardPanel.GRID_SIZE];
   // The clues - isGiven (no need to guess) or need to guess
   boolean[][] isGiven = new boolean[GameBoardPanel.GRID_SIZE][GameBoardPanel.GRID_SIZE];

   // Constructor
   public Puzzle() {
      super();
   }

   // This method shall set (or update) the arrays numbers and isGiven
   public void newPuzzle() {
      int[][] hardcodedNumbers =
         {{8, 3, 5, 4, 1, 6, 9, 2, 7},
          {2, 9, 6, 8, 5, 7, 4, 3, 1},
          {4, 1, 7, 2, 9, 3, 6, 5, 8},
          {5, 6, 9, 1, 3, 4, 7, 8, 2},
          {1, 2, 3, 6, 7, 8, 5, 4, 9},
          {7, 4, 8, 5, 2, 9, 1, 6, 3},
          {6, 5, 2, 7, 8, 1, 3, 9, 4},
          {9, 8, 1, 3, 4, 5, 2, 7, 6},
          {3, 7, 4, 9, 6, 2, 8, 1, 5}};

      // Copy from hardcodedNumbers into the array "numbers"
      for (int row = 0; row < GameBoardPanel.GRID_SIZE; ++row) {
         for (int col = 0; col < GameBoardPanel.GRID_SIZE; ++col) {
            numbers[row][col] = hardcodedNumbers[row][col];
         }
      }

      // Need to use input parameter cellsToGuess!
      // Hardcoded for testing, only 2 cells of "8" is NOT GIVEN
      boolean[][] hardcodedIsGiven =
         {{true, false, false, true, false, true, false, false, true},
          {false, false, false, false, false, false, true, false, false},
          {false, true, false, false, false, false, true, true, false},
          {true, false, true, false, true, false, true, true, false},
          {false, false, false, false, true, false, false, false, false},
          {false, true, true, false, true, false, true, false, true},
          {false, true, true, false, false, false, false, true, false},
          {false, false, true, false, false, false, false, false, false},
          {true, false, false, true, false, true, false, false, true}};

      // Copy from hardcodedIsGiven into array "isGiven"
      for (int row = 0; row < GameBoardPanel.GRID_SIZE; ++row) {
         for (int col = 0; col < GameBoardPanel.GRID_SIZE; ++col) {
            isGiven[row][col] = hardcodedIsGiven[row][col];
         }
      }
   }
   
   public int[][] getSolution()
   {
       return numbers;
   }
   
   public boolean[][] getGivenNumbers()
   {
       return isGiven;
   }
}