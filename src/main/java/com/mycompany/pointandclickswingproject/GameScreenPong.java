/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package com.mycompany.pointandclickswingproject;
import static com.mycompany.pointandclickswingproject.PointAndClickSwingProject.w;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import java.awt.Graphics;
import javax.swing.JLabel;
import java.awt.event.*;
import java.util.Random;
import javax.swing.Timer;


/**
 *
 * @author sirmu
 */

public class GameScreenPong extends javax.swing.JPanel {

  //  Graphics myGraphics;

    /** Creates new form PongGameScreen */
    public GameScreenPong() {
        initComponents();
       // myGraphics = jPanel1.getGraphics();
        Clock clock = new Clock(time);
       // paintComponent(myGraphics);
    }
    
//       private void setLetterBindings()
//    {
//        InputMap myInputMap;
//        ActionMap myActionMap;
//        
//        Action LetterA = new AbstractAction(){
//         public void actionPerformed(ActionEvent e) {
//                button_AActionPerformed(e);
//             }
//        };
//        
//         Action LetterB = new AbstractAction(){
//         public void actionPerformed(ActionEvent e) {
//                button_BActionPerformed(e);
//             }
//        };
//         Action LetterC = new AbstractAction(){
//         public void actionPerformed(ActionEvent e) {
//                button_CActionPerformed(e);
//             }
//        };
//        
//         Action LetterD = new AbstractAction(){
//         public void actionPerformed(ActionEvent e) {
//                button_DActionPerformed(e);
//             }
//        };
//         
//                // GameScreen = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
//        myInputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
//        myActionMap = this.getActionMap();
//        
//        
//        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "A");
//        myActionMap.put("A", LetterA);
//        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_B, 0), "B");
//        myActionMap.put("B", LetterB);
//        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "C");
//        myActionMap.put("C", LetterC);
//        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "D");
//        myActionMap.put("D", LetterD);
//         
//    }
    
    public static JLabel getSpaceLabel()
    {
        return spaceLabel;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        pongPanel = new myPongPanel();
        spaceLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jButton1.setText("Quit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        pongPanel.setBackground(new java.awt.Color(0, 0, 0));
        pongPanel.setPreferredSize(new java.awt.Dimension(350, 250));

        spaceLabel.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        spaceLabel.setForeground(new java.awt.Color(255, 255, 255));
        spaceLabel.setText("PRESS SPACE TO BEGIN!");
        spaceLabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                spaceLabelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pongPanelLayout = new javax.swing.GroupLayout(pongPanel);
        pongPanel.setLayout(pongPanelLayout);
        pongPanelLayout.setHorizontalGroup(
            pongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pongPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spaceLabel)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        pongPanelLayout.setVerticalGroup(
            pongPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pongPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spaceLabel)
                .addContainerGap(216, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("PONG");

        time.setBackground(new java.awt.Color(255, 255, 255));
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        time.setText("timer");
        time.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("PLAYER 1:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("PLAYER 2:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("0");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel4)
                        .addGap(59, 59, 59)
                        .addComponent(pongPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(29, 29, 29)))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(time))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pongPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(61, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(41, 41, 41))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        w.switchPanes("menu");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void spaceLabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spaceLabelKeyPressed
        // TODO add your handling code here:
        if(spaceLabel.isVisible())
        {
            //start game
            spaceLabel.setVisible(false);
        }
    }//GEN-LAST:event_spaceLabelKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel pongPanel;
    private static javax.swing.JLabel spaceLabel;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables

}


class myPongPanel extends javax.swing.JPanel{
 
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
    
    
    private JLabel spaceLabel;
    
    private boolean paused;
    private Direction bd;
    
    myPongPanel() {
        // set a preferred size for the custom panel.
        setPreferredSize(new Dimension(screenH,screenW)); 
        setKeyBindings();
        paused = true;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        spaceLabel = GameScreenPong.getSpaceLabel();

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
    
        
        
        
        
}