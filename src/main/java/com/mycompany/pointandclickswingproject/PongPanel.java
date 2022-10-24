/***************************************************************  
*  file: PongPanel.java  
*  author: N. Kowdle, M. Tran, G. Waughan
*  class: CS 2450 – User Interface Design and Programing 
*  
*  assignment: Swing Project v1.3
*  date last modified: 10/24/2022  
*  
*  purpose: All the necessary components and features to have a playable Pong
*  game
*  
****************************************************************/  
package com.mycompany.pointandclickswingproject;

import static com.mycompany.pointandclickswingproject.PointAndClickSwingProject.w;
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
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 *
 * @author sirmu
 */
public class PongPanel extends javax.swing.JPanel {

    private final int screenW = 350;
    private final int screenH = 250;

    private int paddle1X;
    private int paddle1Y;
    private int paddle1W;
    private int paddle1H;

    private int paddle2X;
    private int paddle2Y;
    private int paddle2W;
    private int paddle2H;

    private int newY;

    private int paddleVelocity;

    private int ballSize;
    private double bx;
    private double by;
    private double ballSpeed;

    private final double MAX_BALLSPEED = 0.2;
    private final double INCREASING_BALLSPEED = 0.005;
    private final double INITIAL_BALLSPEED = 0.05;

    private boolean paused;
    
    private Direction bd;
    private Direction pd_p1;
    private Direction pd_p2;

    /**
     * Creates new form PongPanel
     */
    public PongPanel() {
        initComponents();
        // set a preferred size for the custom panel.
        setPreferredSize(new Dimension(screenH, screenW));
        setKeyBindings();

        ScoreManager1.setScore(0);
        ScoreManager2.setScore(0);
        GameManager.setStatus(true);

        initVariables();
    }

    // method: initVariables()
    // purpose: reset variables to default
    public final void initVariables() {
        paused = true;

        paddle1X = 15;
        paddle1Y = 75;
        paddle1W = 8;
        paddle1H = 60;

        newY = 0;

        paddle2X = 330;
        paddle2Y = 75;
        paddle2W = 8;
        paddle2H = 60;

        paddleVelocity = 14;

        ballSize = 10;
        bx = screenW / 2;
        by = screenH / 2;

        ballSpeed = INITIAL_BALLSPEED;

        GameScreenPong.updateScoreLabels();

        if (true == GameManager.getStatus()) {
            spaceLabel.setText("PRESS SPACE TO BEGIN!");
        } else if (false == GameManager.getStatus()) {
            spaceLabel.setText("PRESS ENTER TO EXIT TO MENU");
        }

        spaceLabel.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.white);
        // g.drawLine(100, 50, 100, 100);
        // g.drawLine(300, 50, 300, 100);
        g.fillRect(paddle1X, paddle1Y, paddle1W, paddle1H);
        g.fillRect(paddle2X, paddle2Y, paddle2W, paddle2H);
        g.fillOval((int) bx, (int) by, ballSize, ballSize);

        if (!paused) {
            moveBall();
            repaint();
        }
    }

    // enum: Direction
    // purpose: Define directions for the ball and paddles
    public enum Direction {
        UP_RIGHT,
        UP_LEFT,
        DOWN_RIGHT,
        DOWN_LEFT,
        UP,
        DOWN
    }

    // method: moveBall()
    // purpose: draws the ball according to the specified direction
    private void moveBall() {
        int offset = 2;
            
        if (!paused) {
            repaint((int) bx, (int) by, ballSize + offset, ballSize + offset);
            switch (bd) {
                case DOWN_RIGHT -> {
                    bx += ballSpeed;
                    by += ballSpeed;
                }
                case UP_RIGHT -> {
                    bx += ballSpeed;
                    by -= ballSpeed;
                }
                case DOWN_LEFT -> {
                    bx -= ballSpeed;
                    by += ballSpeed;
                }
                case UP_LEFT -> {
                    bx -= ballSpeed;
                    by -= ballSpeed;
                }
            }

            repaint((int) bx, (int) by, ballSize + offset, ballSize + offset);
        }

        // upper bound
        if (by <= 0) {
            if (bd == Direction.UP_RIGHT) {
                bd = Direction.DOWN_RIGHT;
            } else // Directino is UP_LEFT
            {
                bd = Direction.DOWN_LEFT;
            }
        }

        // lower bound
        if (by + ballSize >= screenH) {
            if (bd == Direction.DOWN_RIGHT) {
                bd = Direction.UP_RIGHT;
            } else // Directino is DOWN_LEFT
            {
                bd = Direction.UP_LEFT;
            }
        }

        // hits paddle 1
        if (((bx <= paddle1X + paddle1W)
                && (bx >= paddle1X))
                && ((by >= paddle1Y - 5)
                && (by <= paddle1Y + paddle1H - 5))) {
            if (bd == Direction.UP_LEFT) {
                bd = Direction.UP_RIGHT;
                checkBallSpeed();
            } else if (bd == Direction.DOWN_LEFT) {
                bd = Direction.DOWN_RIGHT;
                checkBallSpeed();
            }
        }

        // hits paddle 3
        if ((bx >= paddle2X - paddle2W
                && (bx <= paddle2X))
                && ((by >= paddle2Y - 5)
                && (by <= paddle2Y + paddle2H - 5))) {
            if (bd == Direction.UP_RIGHT) {
                bd = Direction.UP_LEFT;
                checkBallSpeed();
            } else if (bd == Direction.DOWN_RIGHT) {
                bd = Direction.DOWN_LEFT;
                checkBallSpeed();
            }
        }

        // Paddle 1 Loses / Paddle 2 Wins
        if (bx <= -10) {
            System.out.println("Player 2 Scored!");
            ScoreManager2.addScore(10);
            initVariables();
        }

        // Paddle 1 Wins / Paddle 2 Loses
        if (bx >= screenW) {
            System.out.println("Player 1 Scored!");
            ScoreManager1.addScore(10);
            initVariables();
        }
    }

    // method: checkBallSpeed()
    // purpose: makes sure the ball doesn't go too fast
    public void checkBallSpeed() {
//        System.out.println(ballSpeed);
        if (ballSpeed >= MAX_BALLSPEED) {
            ballSpeed = MAX_BALLSPEED;
        } else {
            ballSpeed += INCREASING_BALLSPEED;
        }
    }

    // method: movePaddle1()
    // purpose: moves player1's paddles based on their input
    private void movePaddle1() {
        if (!paused) {
            int y = 0;
            if (pd_p1 == Direction.UP) {
                y = paddle1Y - paddleVelocity;
            } else if (pd_p1 == Direction.DOWN) {
                y = paddle1Y + paddleVelocity;
            }

            int offset = 2;
            if (paddle1Y != y) {
                repaint(paddle1X, paddle1Y, paddle1W, paddle1H + offset);
                paddle1Y = y;
                repaint(paddle1X, paddle1Y, paddle1W, paddle1H + offset);
            }

            // upper bound
            if (paddle1Y <= 0) {
                paddle1Y = 0;
            }

            // lower bound
            if (paddle1Y + paddle1H >= screenH) {
                paddle1Y = screenH - paddle1H;
            }
        }
    }

    // method: movePaddle2()
    // purpose: moves player 2 paddle based on their input
    private void movePaddle2() {
        if (!paused) {
            int y = 0;
            if (pd_p2 == Direction.UP) {
                y = paddle2Y - paddleVelocity;
            } else if (pd_p2 == Direction.DOWN) {
                y = paddle2Y + paddleVelocity;
            }

            int offset = 2;

            if (paddle2Y != y) {
                repaint(paddle2X, paddle2Y, paddle2W, paddle2H + offset);
                paddle2Y = y;
                repaint(paddle2X, paddle2Y, paddle2W, paddle2H + offset);
            }

            // upper bound
            if (paddle2Y <= 0) {
                paddle2Y = 0;
            }

            // lower bound
            if (paddle2Y + paddle2H >= screenH) {
                paddle2Y = screenH - paddle2H;
            }
        }
    }

    // method: setKeyBindings()
    // purpose: initializes keybindings
    private void setKeyBindings() {

        InputMap myInputMap;
        ActionMap myActionMap;

        Timer movement_P1 = new Timer(25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movePaddle1();
            }
        });

        Timer movement_P2 = new Timer(25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movePaddle2();
            }
        });

        Action Player1Up = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
//             System.out.println("W pressed!");
                // p1velocity = -1;
                pd_p1 = Direction.UP;
                movement_P1.start();
            }
        };

        Action Player1Down = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
//            System.out.println("S pressed!");
                // p1velocity = -1;
                pd_p1 = Direction.DOWN;
                movement_P1.start();

            }
        };

        Action Player2Up = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                pd_p2 = Direction.UP;
                movement_P2.start();
            }
        };

        Action Player2Down = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                pd_p2 = Direction.DOWN;
                movement_P2.start();
            }

        };

        Action stopMovement_P1 = new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                movement_P1.stop();
            }

        };

        Action stopMovement_P2 = new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                movement_P2.stop();
            }

        };

        Action startGame = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                // TODO add your handling code here:
                if (spaceLabel.isVisible() && GameManager.getStatus()) {
                    Random rand = new Random();
                    int num = rand.nextInt(4);
                    switch (num) {
                        case 0 ->
                            bd = Direction.DOWN_RIGHT;
                        case 1 ->
                            bd = Direction.UP_RIGHT;
                        case 2 ->
                            bd = Direction.DOWN_LEFT;
                        case 3 ->
                            bd = Direction.UP_LEFT;

                        default ->
                            bd = Direction.DOWN_RIGHT;
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

        Action endGame = new AbstractAction() {

            public void actionPerformed(ActionEvent e) {
                w.switchPanes("menu");
                ScoreManager1.setScore(0);
                ScoreManager2.setScore(0);
                GameManager.setStatus(true);
                initVariables();
            }

        };

        // GameScreen = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        myInputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        myActionMap = this.getActionMap();

        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "W");
        myActionMap.put("W", Player1Up);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "W Released");
        myActionMap.put("W Released", stopMovement_P1);

        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "S");
        myActionMap.put("S", Player1Down);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "S Released");
        myActionMap.put("S Released", stopMovement_P1);

        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "Up");
        myActionMap.put("Up", Player2Up);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "Up Released");
        myActionMap.put("Up Released", stopMovement_P2);

        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "Down");
        myActionMap.put("Down", Player2Down);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "Down Released");
        myActionMap.put("Down Released", stopMovement_P2);

        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "Space");
        myActionMap.put("Space", startGame);

        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        myActionMap.put("Enter", endGame);
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
        if (spaceLabel.isVisible()) {
            //start game
            spaceLabel.setVisible(false);
        }
    }//GEN-LAST:event_spaceLabelKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel spaceLabel;
    // End of variables declaration//GEN-END:variables
}
