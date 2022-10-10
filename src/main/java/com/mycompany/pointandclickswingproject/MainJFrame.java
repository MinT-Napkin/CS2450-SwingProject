/***************************************************************  
*  file: MainJFrame.java  
*  author: N. Kowdle  
*  class: CS 2450 – User Interface Design and Programing 
*  
*  assignment: program 1  
*  date last modified: 9/19/2022  
*  
*  purpose: This program displays each of the different screens of the game in a set JFrame.
*  
****************************************************************/  

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pointandclickswingproject;
import static com.mycompany.pointandclickswingproject.PointAndClickSwingProject.w;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 *
 * 
 */
public class MainJFrame extends javax.swing.JFrame {

    public final String SPLASH = "splash";
    public final String MENU = "menu";
    public final String LEADERBOARD = "leaderboard";
    public final String GAME = "game";
    public final String GAME1 = "game1";
    public final String GAME2 = "game2";
    public final String CREDITS = "credits";
    public final String GAMEOVER = "gameover";
    private final CardLayout cLayout;
    private final JPanel mainPane;
    
    /**
     * Creates new form Window
     * @param splashScreen1
     * @param menuScreen1
     * @param leaderboardScreen1
     * @param gameScreen1
     * @param creditsScreen1
     * @param gameOverScreen1
     * @param gameScreen2
     * @throws java.lang.InterruptedException
     */
    public MainJFrame(JPanel splashScreen1, 
            JPanel menuScreen1, 
            JPanel leaderboardScreen1, 
            JPanel gameScreen1, 
            JPanel creditsScreen1,
            JPanel gameOverScreen1,
            JPanel gameScreen2,JPanel gameScreen3) throws InterruptedException {
        
        initComponents();
        
        setTitle("SwingBeans - Swing Project v1.2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPane = new JPanel();
        mainPane.setPreferredSize(new Dimension(600,400));
        cLayout = new CardLayout();
        mainPane.setLayout(cLayout);

        mainPane.add(SPLASH, splashScreen1);
        mainPane.add(MENU, menuScreen1);
        mainPane.add(LEADERBOARD, leaderboardScreen1);
        mainPane.add(GAME, gameScreen1);
        mainPane.add(CREDITS, creditsScreen1);
        mainPane.add(GAMEOVER, gameOverScreen1);
        mainPane.add(GAME1,gameScreen2);
        mainPane.add(GAME2, gameScreen3);
        
        cLayout.show(mainPane, SPLASH);

        setLayout(new BorderLayout());
        add(mainPane,BorderLayout.CENTER);
        pack();
        setVisible(true);
        
        Timer timer = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cLayout.show(mainPane, MENU);
            }
        });
        timer.setRepeats(false);
        timer.start();
        
        
        setUpKeyBindings();
        
    }
    
    private void setUpKeyBindings()
    {
        InputMap myInputMap;
        ActionMap myActionMap;
        
        Action exitProgram = new AbstractAction(){
         public void actionPerformed(ActionEvent evt) {
                w.dispatchEvent(new WindowEvent(w, WindowEvent.WINDOW_CLOSING));
             }
        };
        
         Action showcaseDisplay = new AbstractAction(){
         public void actionPerformed(ActionEvent evt) {
                showcaseDialog.setLocationRelativeTo(null);
                showcaseDialog.setVisible(true);
             }
        };
        
       // GameScreen = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        myInputMap = mainPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        myActionMap = mainPane.getActionMap();
        
        
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "exit");
        myActionMap.put("exit", exitProgram);
        
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "Showcase");
        myActionMap.put("Showcase", showcaseDisplay);
        
    }
    
    
    
 
    // method: switchPanes(String swap)
    // purpose: this method allows to easily switch screens to the corresponding
    // name given for the screen
    void switchPanes(String swap) {
        cLayout.show(mainPane, swap);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        showcaseDialog = new javax.swing.JDialog();
        JProjTitle = new javax.swing.JLabel();
        projTerm = new javax.swing.JLabel();
        martinName = new javax.swing.JLabel();
        benName = new javax.swing.JLabel();
        nikhilName = new javax.swing.JLabel();
        minhName = new javax.swing.JLabel();
        garethName = new javax.swing.JLabel();

        showcaseDialog.setBackground(new java.awt.Color(255, 51, 255));
        showcaseDialog.setSize(new java.awt.Dimension(600, 400));

        JProjTitle.setBackground(new java.awt.Color(0, 0, 0));
        JProjTitle.setFont(new java.awt.Font("Futura", 1, 24)); // NOI18N
        JProjTitle.setForeground(new java.awt.Color(108, 194, 74));
        JProjTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JProjTitle.setText("Fun N Games with the SwingBeans!");
        JProjTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        projTerm.setFont(new java.awt.Font("Futura", 0, 16)); // NOI18N
        projTerm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        projTerm.setText("Fall 2022");
        projTerm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        martinName.setFont(new java.awt.Font("Helvetica", 0, 22)); // NOI18N
        martinName.setForeground(new java.awt.Color(1, 66, 106));
        martinName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        martinName.setText("Martin Flores, 014072422");
        martinName.setToolTipText("Codename: martin_418");
        martinName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        benName.setFont(new java.awt.Font("Helvetica", 0, 22)); // NOI18N
        benName.setForeground(new java.awt.Color(1, 66, 106));
        benName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        benName.setText("Benjamin Chen, 015393066");
        benName.setToolTipText("Codename: uu");
        benName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        nikhilName.setFont(new java.awt.Font("Helvetica", 0, 22)); // NOI18N
        nikhilName.setForeground(new java.awt.Color(1, 66, 106));
        nikhilName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nikhilName.setText("Nikhil Kowdle, 013608413");
        nikhilName.setToolTipText("Codename: Stormwolf");
        nikhilName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        minhName.setFont(new java.awt.Font("Helvetica", 0, 22)); // NOI18N
        minhName.setForeground(new java.awt.Color(1, 66, 106));
        minhName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minhName.setText("Minh Tran, 015051140");
        minhName.setToolTipText("Codename: MinT");
        minhName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        garethName.setFont(new java.awt.Font("Helvetica", 0, 22)); // NOI18N
        garethName.setForeground(new java.awt.Color(1, 66, 106));
        garethName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        garethName.setText("Gareth G. Waughan, 013289471");
        garethName.setToolTipText("Codename: Gary Primey");
        garethName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout showcaseDialogLayout = new javax.swing.GroupLayout(showcaseDialog.getContentPane());
        showcaseDialog.getContentPane().setLayout(showcaseDialogLayout);
        showcaseDialogLayout.setHorizontalGroup(
            showcaseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showcaseDialogLayout.createSequentialGroup()
                .addGroup(showcaseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showcaseDialogLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(showcaseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showcaseDialogLayout.createSequentialGroup()
                                .addComponent(projTerm)
                                .addGap(194, 194, 194))
                            .addComponent(JProjTitle, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(showcaseDialogLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(showcaseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(showcaseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(showcaseDialogLayout.createSequentialGroup()
                                    .addGap(45, 45, 45)
                                    .addComponent(minhName)
                                    .addGap(17, 17, 17))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showcaseDialogLayout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addGroup(showcaseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(martinName)
                                        .addComponent(nikhilName))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showcaseDialogLayout.createSequentialGroup()
                                .addComponent(benName)
                                .addGap(15, 15, 15))
                            .addComponent(garethName, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(0, 72, Short.MAX_VALUE))
        );
        showcaseDialogLayout.setVerticalGroup(
            showcaseDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showcaseDialogLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(JProjTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(projTerm)
                .addGap(30, 30, 30)
                .addComponent(benName)
                .addGap(18, 18, 18)
                .addComponent(martinName)
                .addGap(18, 18, 18)
                .addComponent(nikhilName)
                .addGap(18, 18, 18)
                .addComponent(minhName)
                .addGap(18, 18, 18)
                .addComponent(garethName)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JProjTitle;
    private javax.swing.JLabel benName;
    private javax.swing.JLabel garethName;
    private javax.swing.JLabel martinName;
    private javax.swing.JLabel minhName;
    private javax.swing.JLabel nikhilName;
    private javax.swing.JLabel projTerm;
    private javax.swing.JDialog showcaseDialog;
    // End of variables declaration//GEN-END:variables
}
