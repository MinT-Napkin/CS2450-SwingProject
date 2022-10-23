/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pointandclickswingproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 *
 * @author sirmu
 */
public class PongPanel extends javax.swing.JPanel {

    private final int screenW = 350;
    private final int screenH = 250;
    
    private int paddle1X = 20;
    private int paddle1Y = 75;
    private int paddle1W = 8;
    private int paddle1H = 60;
   int newY = 0;
    private int paddle2X = 330;
    private int paddle2Y = 75;
    private int paddle2W = 8;
    private int paddle2H = 60;
    
    int p1velocity = 7;
    int p2velocity = 7;
    
    private int ballSize = 10;
    private double bx = screenW/2;
    private double by = screenH/2;
    
    private boolean paused;
    private Direction bd;
    
    /**
     * Creates new form PongPanel
     */
    public PongPanel() {
        initComponents();
        // set a preferred size for the custom panel.
        setPreferredSize(new Dimension(screenH,screenW)); 
        setKeyBindings();
        paused = true;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.white);
       // g.drawLine(100, 50, 100, 100);
       // g.drawLine(300, 50, 300, 100);
        g.fillRect(paddle1X, paddle1Y, paddle1W, paddle1H);
        g.fillRect(paddle2X, paddle2Y, paddle2W, paddle2H);
        g.fillOval((int)bx, (int)by, ballSize, ballSize);
        
        if(!paused)
        {
            moveBall();
        }
    }
    
    public enum Direction {
        UP_RIGHT,         
        UP_LEFT,
        DOWN_RIGHT,
        DOWN_LEFT
    }
   
    private void moveBall()
    {
        int offset = 2;
        repaint((int)bx, (int)by, ballSize + offset, ballSize + offset);
        
        switch (bd) {
            case DOWN_RIGHT -> {
                bx +=  0.1;
                by +=  0.1;
            }
            case UP_RIGHT -> {
                bx +=  0.1;
                by -=  0.1;
            }
            case DOWN_LEFT -> {
                bx -=  0.1;
                by +=  0.1;
            }
            case UP_LEFT -> {
                bx -=  0.1;
                by -=  0.1;
            }
        }

        repaint((int)bx, (int)by, ballSize + offset, ballSize + offset);
        
        // upper bound
//        if(by <= 0)
//        {
//            paddle1Y = 0;
//        }
//
//        // lower bound
//        if(paddle1Y + paddle1H >= screenH)
//        {
//            paddle1Y = screenH - paddle1H;
//        }
    }
        
    private void movePaddle1(int y)
    {
        if(!paused)
        {
            int offset = 2;
            if (paddle1Y != y)
            {
                repaint(paddle1X, paddle1Y, paddle1W, paddle1H + offset);
                paddle1Y = y;
                repaint(paddle1X, paddle1Y, paddle1W, paddle1H + offset);
            }

            // upper bound
            if(paddle1Y <= 0)
            {
                paddle1Y = 0;
            }

            // lower bound
            if(paddle1Y + paddle1H >= screenH)
            {
                paddle1Y = screenH - paddle1H;
            }
        }
    }
    
    private void movePaddle2(int y)
    {
        if(!paused)
        {
            int offset = 2;
            if (paddle2Y != y)
            {
                repaint(paddle2X, paddle2Y, paddle2W, paddle2H + offset);
                paddle2Y = y;
                repaint(paddle2X, paddle2Y, paddle2W, paddle2H + offset);
            }

            // upper bound
            if(paddle2Y <= 0)
            {
                paddle2Y = 0;
            }

            // lower bound
            if(paddle2Y + paddle2H >= screenH)
            {
                paddle2Y = screenH - paddle2H;
            }
        }
    }
    
    private void setKeyBindings()
    {
        
        InputMap myInputMap;
        ActionMap myActionMap;
        
        Action Player1Up = new AbstractAction(){
             public void actionPerformed(ActionEvent e) {
             System.out.println("W pressed!");
            // p1velocity = -1;
             newY = paddle1Y - p1velocity;
             movePaddle1(newY);
             }
        };

        Action Player1Down = new AbstractAction(){
        public void actionPerformed(ActionEvent e) 
        {
            System.out.println("S pressed!");
           // p1velocity = -1;
            newY = paddle1Y + p1velocity;
            movePaddle1(newY);

           }
        };
        
        Action Player2Up = new AbstractAction(){
        public void actionPerformed(ActionEvent e) 
        {
            System.out.println("Up Arrow pressed!");
           // p1velocity = -1;
            newY = paddle2Y - p2velocity;
            movePaddle2(newY);
        }
        };

        Action Player2Down = new AbstractAction(){
        public void actionPerformed(ActionEvent e) 
        {
           System.out.println("Down Arrow pressed!");
           // p1velocity = -1;
            newY = paddle2Y + p2velocity;
            movePaddle2(newY);
            }
        };

        Action startGame = new AbstractAction(){
            public void actionPerformed(ActionEvent e) 
            {
                // TODO add your handling code here:
                if(spaceLabel.isVisible())
                {
                    Random rand = new Random();
                    int num = rand.nextInt(4);
                    switch(num)
                    {
                        case 0 -> bd = Direction.DOWN_RIGHT;
                        case 1 -> bd = Direction.UP_RIGHT;
                        case 2 -> bd = Direction.DOWN_LEFT;
                        case 3 -> bd = Direction.UP_LEFT;
                        
                        default -> bd = Direction.DOWN_RIGHT;
                    }
                    paused = false;
                    System.out.println("Start Game!");
                    //start game
                    spaceLabel.setVisible(false);
                    Timer b = new Timer(1000, updateBall);
                    b.start();
                }
            }
            
            ActionListener updateBall = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    moveBall();
            }
        };
        };
         
                // GameScreen = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        myInputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        myActionMap = this.getActionMap();
        
        
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "W");
        myActionMap.put("W", Player1Up);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "S");
        myActionMap.put("S", Player1Down);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "Up");
        myActionMap.put("Up", Player2Up);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "Down");
        myActionMap.put("Down", Player2Down);
        
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "Space");
        myActionMap.put("Space", startGame);
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spaceLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(350, 250));

        spaceLabel.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        spaceLabel.setForeground(new java.awt.Color(255, 255, 255));
        spaceLabel.setText("PRESS SPACE TO BEGIN!");
        spaceLabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                spaceLabelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spaceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spaceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void spaceLabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spaceLabelKeyPressed
        // TODO add your handling code here:
        if(spaceLabel.isVisible())
        {
            //start game
            spaceLabel.setVisible(false);
        }
    }//GEN-LAST:event_spaceLabelKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel spaceLabel;
    // End of variables declaration//GEN-END:variables
}
