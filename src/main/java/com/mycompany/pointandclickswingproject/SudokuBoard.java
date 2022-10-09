package com.mycompany.pointandclickswingproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JTextArea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author Nikhil
 */
public class SudokuBoard extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;
    private int DisplayWidth = 557; //sudoku display its 300 pixels wide
    private int DisplayHeight = 556; //sudoku display its 300 pixels high
    private final Color MB = new Color(0x00, 0x00, 0xcd);  //Medium blue
    private final Color B = new Color(0x00, 0x00, 0x00);  //Black

    
    /**
     * Creates new form SudokuBoard
     */
    public SudokuBoard() {
        initComponents();
    }

    protected void paintComponent(Graphics g)  //called whenever the display panel needs painting
    {
    	//Grid lines for the display
     	int BigLines[] = {0, 100, 200, 300};  //block of 3 x 3 numbers  2 pixels wide
     	int SmallLines[] = {34, 67, 134, 167, 234, 267};  //each number   1 pixel wide
        int NumberPosition[] = {2, 35, 68, 102, 135, 168, 202, 235, 268}; //number display
     	
        super.paintComponent(g); //paint the component's JPanel     
        g.setColor(MB);

        //horizontal lines
        byte count;  //counter for position 0 to 80
        for (count = 0; count < 4; count++) {
            g.fillRect(0, BigLines[count], DisplayWidth, 2);
        }
        for (count = 0; count < 6; count++) {
            g.drawLine(0, SmallLines[count], DisplayWidth, SmallLines[count]);
        }

        //vertical lines
        g.fillRect(BigLines[0], 0, 3, DisplayHeight);
        g.fillRect(BigLines[1], 0, 3, DisplayHeight);
        g.fillRect(BigLines[2], 0, 3, DisplayHeight);
        g.fillRect(BigLines[3], 0, 3, DisplayHeight);
        for (count = 0; count < 6; count++)
            g.drawLine(SmallLines[count], 0, SmallLines[count], DisplayHeight);
        
        JTextArea textArea = new JTextArea("This is an editable JTextArea. "
                        + "A text area is a \"plain\" text component, "
                        + "which means that although it can display text "
                        + "in any font, all of the text is in the same font.");
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        g.setColor(B);
        g.setFont(new Font("SansSerif", Font.ROMAN_BASELINE, 30));
        g.drawString( "8", 10, 30);
        g.drawString( "4", 110, 30);
        g.drawString( "6", 176, 30);
        g.drawString( "7", 276, 30);
        g.drawString( "4", 210, 65);
        g.drawString( "1", 43, 98);
        g.drawString( "6", 210, 98);
        g.drawString( "5", 243, 98);
        g.drawString( "5", 10, 130);
        g.drawString( "9", 76, 130);
        g.drawString( "3", 143, 130);
        g.drawString( "7", 210, 130);
        g.drawString( "8", 243, 130);
        g.drawString( "7", 143, 165);
        g.drawString( "4", 43, 198);
        g.drawString( "8", 76, 198);
        g.drawString( "2", 143, 198);
        g.drawString( "1", 210, 198);
        g.drawString( "3", 276, 198);
        g.drawString( "5", 43, 230);
        g.drawString( "2", 76, 230);
        g.drawString( "9", 243, 230);
        g.drawString( "1", 76, 265);
        g.drawString( "3", 10, 298);
        g.drawString( "9", 110, 298);
        g.drawString( "2", 176, 298);
        g.drawString( "5", 276, 298);
        
        
    }//end of paint sudoku display  
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 304, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
