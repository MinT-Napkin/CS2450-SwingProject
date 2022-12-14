/***************************************************************  
*  file: GameScreen.java  
*  author: M. Tran
*  class: CS 2450 – User Interface Design and Programing 
*  
*  assignment: Swing Project v1.0 
*  date last modified: 9/21/2022  
*  
*  purpose: This program contains all the functionality of the Hangman game in
*  one Screen
*  
****************************************************************/  

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pointandclickswingproject;
import static com.mycompany.pointandclickswingproject.PointAndClickSwingProject.w;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class GameScreen extends javax.swing.JPanel {

    private int mistakes;
    private int correctGuesses;
    private String hiddenWord;
    
    private final int INITIAL_SCORE = 100;
    private final int INITIAL_MISTAKES = 0;
    private final int INITIAL_CORRECT_GUESSES = 0;
    
    private final int MAX_LETTERS = 8;
    private final JLabel[] UNDERSCORES = new JLabel[MAX_LETTERS];
    private final JLabel[] HIDDEN_LETTER_PLACEHOLDER = new JLabel[MAX_LETTERS];
    private final String[] DEFAULT_WORDS = {"Abstract", "Cemetery", "Nurse", "Pharmacy", "Climbing"};
    
    private final Timer alertTimer;
  
    /**
     * Creates new form GameScreen
     */
    public GameScreen() {    
        initComponents();
        
        prepareHiddenWordDisplay();
        resetHangman();
        
        ScoreManager.setScore(INITIAL_SCORE);
        myScore.setText("Score: " + ScoreManager.getScore());
        this.mistakes = INITIAL_MISTAKES;
        this.correctGuesses = INITIAL_CORRECT_GUESSES;
        
        this.alertTimer = new Timer (2000, updateAlert);
        
        Clock clock = new Clock(time);  
        
        setLetterBindings();
    }
    
    public static void updateScoreLabel()
    {
        ScoreManager.setScoreLabel(myScore);
    }
    
    private void setLetterBindings()
    {
        InputMap myInputMap;
        ActionMap myActionMap;
        
        Action LetterA = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_AActionPerformed(e);
             }
        };
        
         Action LetterB = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_BActionPerformed(e);
             }
        };
         Action LetterC = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_CActionPerformed(e);
             }
        };
        
         Action LetterD = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_DActionPerformed(e);
             }
        };
         Action LetterE = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_EActionPerformed(e);
             }
        };
        
         Action LetterF = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_FActionPerformed(e);
             }
        };
         Action LetterG = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_GActionPerformed(e);
             }
        };
        
         Action LetterH = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_HActionPerformed(e);
             }
        };
        Action LetterI = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_IActionPerformed(e);
             }
        };
        
         Action LetterJ = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_JActionPerformed(e);
             }
        };
         Action LetterK = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_KActionPerformed(e);
             }
        };
        
         Action LetterL = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_LActionPerformed(e);
             }
        };
         Action LetterM = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_MActionPerformed(e);
             }
        };
        
         Action LetterN = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_NActionPerformed(e);
             }
        };
         Action LetterO = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_OActionPerformed(e);
             }
        };
        
         Action LetterP = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_PActionPerformed(e);
             }
        };
         Action LetterQ = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_QActionPerformed(e);
             }
        };
        
         Action LetterR = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_RActionPerformed(e);
             }
        };
         Action LetterS = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_SActionPerformed(e);
             }
        };
        
         Action LetterT = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_TActionPerformed(e);
             }
        };
         Action LetterU = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_UActionPerformed(e);
             }
        };
        
         Action LetterV = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_VActionPerformed(e);
             }
        };
         Action LetterW = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_WActionPerformed(e);
             }
        };
        
         Action LetterX = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_XActionPerformed(e);
             }
        };
         Action LetterY = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_YActionPerformed(e);
             }
        };
        
         Action LetterZ = new AbstractAction(){
         public void actionPerformed(ActionEvent e) {
                button_ZActionPerformed(e);
             }
        };
         
       // GameScreen = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        myInputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        myActionMap = this.getActionMap();
        
        
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "A");
        myActionMap.put("A", LetterA);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_B, 0), "B");
        myActionMap.put("B", LetterB);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "C");
        myActionMap.put("C", LetterC);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "D");
        myActionMap.put("D", LetterD);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), "E");
        myActionMap.put("E", LetterE);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F, 0), "F");
        myActionMap.put("F", LetterF);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_G, 0), "G");
        myActionMap.put("G", LetterG);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_H, 0), "H");
        myActionMap.put("H", LetterH);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_I, 0), "I");
        myActionMap.put("I", LetterI);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_J, 0), "J");
        myActionMap.put("J", LetterJ);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_K, 0), "K");
        myActionMap.put("K", LetterK);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_L, 0), "L");
        myActionMap.put("L", LetterL);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_M, 0), "M");
        myActionMap.put("M", LetterM);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_N, 0), "N");
        myActionMap.put("N", LetterN);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_O, 0), "O");
        myActionMap.put("O", LetterO);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "P");
        myActionMap.put("P", LetterP);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), "Q");
        myActionMap.put("Q", LetterQ);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0), "R");
        myActionMap.put("R", LetterR);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "S");
        myActionMap.put("S", LetterS);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_T, 0), "T");
        myActionMap.put("T", LetterT);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_U, 0), "U");
        myActionMap.put("U", LetterU);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, 0), "V");
        myActionMap.put("V", LetterV);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "W");
        myActionMap.put("W", LetterW);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, 0), "X");
        myActionMap.put("X", LetterX);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, 0), "Y");
        myActionMap.put("Y", LetterY);
        myInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0), "Z");
        myActionMap.put("Z", LetterZ);
        
    }
    
    // action listener: updateAlert
    /* purpose: this action listener is meant for a timer of the alert
    * after the incorrect letter was picked, which makes the alert disappear
    * after a certain amount of time
    */
    ActionListener updateAlert = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            alert.setVisible(false);
        }
    };
    
    // method: getMistakes()
    // purpose: getter method for misakes variable
    public int getMistakes()
    {
        return this.mistakes;
    }
    
    // method: setMistakes()
    // purpose: setter method for mistakes variable
    public void setMistakes(int mistakes)
    {
        this.mistakes = mistakes;
    }
    
    // method: getCorrectGuesses()
    // purpose: getter method for correctGuesses variable
    public int getCorrectGuesses()
    {
        return this.correctGuesses;
    }
    
    // method: setCorrectGuesses()
    // purpose: setter method for score variable
    public void setCorrectGuesses(int correctGuesses)
    {
        this.correctGuesses = correctGuesses;
    }
    
    // method: prepareHiddenWordDisplay()
    /* purpose: this method prepares all the necessary components for the
    * word to be displayed on the screen, such as the underscores and letters
    */
    private void prepareHiddenWordDisplay()
    {
        int xcoord = 20;
        for(int i=0; i < MAX_LETTERS; i++)
        {
            UNDERSCORES[i] = new JLabel("_", SwingConstants.CENTER);
            UNDERSCORES[i].setFont(new java.awt.Font("Copperplate Gothic Light", 1, 48));
            wordArea.add(UNDERSCORES[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(xcoord, 60, 40, 60));
            UNDERSCORES[i].setVisible(false);
            xcoord+=40;
        }
        
        xcoord = 20;
        for(int i=0; i < MAX_LETTERS; i++)
        {
            HIDDEN_LETTER_PLACEHOLDER[i] = new JLabel("", SwingConstants.CENTER);
            HIDDEN_LETTER_PLACEHOLDER[i].setFont(new java.awt.Font("Copperplate Gothic Light", 1, 36));
            wordArea.add(HIDDEN_LETTER_PLACEHOLDER[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(xcoord, 60, 40, 60));
            HIDDEN_LETTER_PLACEHOLDER[i].setVisible(false);
            xcoord += 40;
        }
    }
    
    // method: randomizeHiddenWord()
    // purpose: this method randmizes the hidden word used in Hangman
    private String randomizeHiddenWord()
    {
        int index = (int) Math.floor(Math.random()*DEFAULT_WORDS.length);
        hiddenWord = DEFAULT_WORDS[index].toUpperCase();
        System.out.println("Hidden Word Is: " + hiddenWord);
        
        for(int i=0; i < hiddenWord.length(); i++)
        {
            UNDERSCORES[i].setVisible(true);
        }
        
        for(int i=0; i < hiddenWord.length(); i++)
        {
            HIDDEN_LETTER_PLACEHOLDER[i].setText(hiddenWord.substring(i, i+1));
        }
        
        return hiddenWord;
    }
    
    /* method: checkLetter(String letter)
    * purpose: this method checks after the user clicks the corresponding letter
    * if it is right or wrong to the respective hidden word, and either displays
    * the letter(s) or hangman part respectively
    */
    private void checkLetter(String letter)
    {   
        String wLetter;
        boolean correctLetter = false;
        for(int i=0; i < hiddenWord.length(); i++)
        {
            wLetter = hiddenWord.substring(i, i+1);
            if(letter.equals(wLetter))
            {
                //In the event that the letter is correct
                correctLetter = true;
                displayHiddenLetter(letter);
                i = hiddenWord.length();
            }
        }
        
        if(!correctLetter)
        {
            mistakes++;
            ScoreManager.subtractScore(10);
            ScoreManager.setScoreLabel(myScore);
//            System.out.println("Mistakes " + mistakes);
            
            alertTimer.setRepeats(false);

            if(!alert.isVisible())
            {
                alert.setVisible(true);
                alertTimer.start();
            }
            else
            {
                alert.setVisible(true);
                alertTimer.restart();
            }
            
            switch(mistakes)
            {
                case 1 -> {
                    head.setVisible(true);
                    break;
                }
                
                case 2 -> {
                    body.setVisible(true);
                    break;
                }
                case 3 ->
                {
                    leftArm.setVisible(true);
                    break;
                }
                case 4 ->
                {
                    rightArm.setVisible(true);
                    break;
                }
                case 5 ->
                {
                    leftLeg.setVisible(true);
                    break;
                }
                case 6 ->
                {
                    rightLeg.setVisible(true);
                    break;
                }
                    
            }
            
            // user loses the game
            if(mistakes >= 6)
            {
                //end the game
                //GameOverScreen.setLabelScore(score);
                //this.setGameOverLabelScore();
                GameScreen1.updateScoreLabel();
                w.switchPanes("game1");
                this.resetHangman();
                
            }
        }
        else
        {       
            // user wins the game
            if(correctGuesses >= hiddenWord.length())
            {
               // this.setGameOverLabelScore();
                GameScreen1.updateScoreLabel();
                w.switchPanes("game1");
                this.resetHangman();
            }
        }
    }
    
    /* method: displayHiddenLetter(String letter)
    *purpose: this method is used in checkLetter(String letter) method,
    * which makes the previously placed JLabels made in the 
    *prepareHiddenWordDisplay() method visible depending on the letter
    */
    private void displayHiddenLetter(String letter)
    {
        for(int i=0; i < HIDDEN_LETTER_PLACEHOLDER.length; i++)
        {
            String hLetter = HIDDEN_LETTER_PLACEHOLDER[i].getText();
            if(letter.equals(hLetter))
            {
                HIDDEN_LETTER_PLACEHOLDER[i].setVisible(true);
                correctGuesses++;
            }
        }
    }
    
    // method: resetHangman()
    // purpose: this method allows the resetting of variables and components
    // after the game is finished for replayability
    private void resetHangman()
    {
        this.mistakes = INITIAL_MISTAKES;
        this.correctGuesses = INITIAL_CORRECT_GUESSES;
        
        head.setVisible(false);
        body.setVisible(false);
        leftArm.setVisible(false);
        rightArm.setVisible(false);
        leftLeg.setVisible(false);
        rightLeg.setVisible(false);
        
        alert.setVisible(false);
        
        button_A.setEnabled(true);
        button_B.setEnabled(true);
        button_C.setEnabled(true);
        button_D.setEnabled(true);
        button_E.setEnabled(true);
        button_F.setEnabled(true);
        button_G.setEnabled(true);
        button_H.setEnabled(true);
        button_I.setEnabled(true);
        button_J.setEnabled(true);
        button_K.setEnabled(true);
        button_L.setEnabled(true);
        button_M.setEnabled(true);
        button_N.setEnabled(true);
        button_O.setEnabled(true);
        button_P.setEnabled(true);
        button_Q.setEnabled(true);
        button_R.setEnabled(true);
        button_S.setEnabled(true);
        button_T.setEnabled(true);
        button_U.setEnabled(true);
        button_V.setEnabled(true);
        button_W.setEnabled(true);
        button_X.setEnabled(true);
        button_Y.setEnabled(true);
        button_Z.setEnabled(true);
        
        for(int i=0; i < MAX_LETTERS; i++)
        {
            UNDERSCORES[i].setVisible(false);
        }
        
        for(int i=0; i < MAX_LETTERS; i++)
        {
            HIDDEN_LETTER_PLACEHOLDER[i].setText("");
            HIDDEN_LETTER_PLACEHOLDER[i].setVisible(false);
        }
        
        randomizeHiddenWord();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        myScore = new javax.swing.JLabel();
        button_A = new javax.swing.JButton();
        button_B = new javax.swing.JButton();
        button_C = new javax.swing.JButton();
        button_D = new javax.swing.JButton();
        button_E = new javax.swing.JButton();
        button_F = new javax.swing.JButton();
        button_G = new javax.swing.JButton();
        button_H = new javax.swing.JButton();
        button_I = new javax.swing.JButton();
        button_J = new javax.swing.JButton();
        button_K = new javax.swing.JButton();
        button_L = new javax.swing.JButton();
        button_M = new javax.swing.JButton();
        button_N = new javax.swing.JButton();
        button_O = new javax.swing.JButton();
        button_P = new javax.swing.JButton();
        button_R = new javax.swing.JButton();
        button_S = new javax.swing.JButton();
        button_Q = new javax.swing.JButton();
        button_T = new javax.swing.JButton();
        button_U = new javax.swing.JButton();
        button_V = new javax.swing.JButton();
        button_W = new javax.swing.JButton();
        button_X = new javax.swing.JButton();
        button_Y = new javax.swing.JButton();
        button_Z = new javax.swing.JButton();
        button_Skip = new javax.swing.JButton();
        platform = new javax.swing.JLabel();
        head = new javax.swing.JLabel();
        body = new javax.swing.JLabel();
        leftArm = new javax.swing.JLabel();
        rightArm = new javax.swing.JLabel();
        leftLeg = new javax.swing.JLabel();
        rightLeg = new javax.swing.JLabel();
        wordArea = new javax.swing.JPanel();
        alert = new javax.swing.JLabel();
        time = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(600, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        jLabel1.setText("HANGMAN");
        jLabel1.setToolTipText("Guess the correct letters to win!");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 11, -1, -1));

        myScore.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        myScore.setText("SCORE: 0");
        myScore.setToolTipText("Your current score!");
        add(myScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 45, 100, -1));

        button_A.setText("A");
        button_A.setToolTipText("Guess A");
        button_A.setPreferredSize(new java.awt.Dimension(41, 41));
        button_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_AActionPerformed(evt);
            }
        });
        add(button_A, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 288, 40, 40));

        button_B.setText("B");
        button_B.setToolTipText("Guess B");
        button_B.setPreferredSize(new java.awt.Dimension(41, 41));
        button_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_BActionPerformed(evt);
            }
        });
        add(button_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 288, 40, 40));

        button_C.setText("C");
        button_C.setToolTipText("Guess C");
        button_C.setPreferredSize(new java.awt.Dimension(41, 41));
        button_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_CActionPerformed(evt);
            }
        });
        add(button_C, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 288, 40, 40));

        button_D.setText("D");
        button_D.setToolTipText("Guess D");
        button_D.setPreferredSize(new java.awt.Dimension(41, 41));
        button_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_DActionPerformed(evt);
            }
        });
        add(button_D, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 288, 40, 40));

        button_E.setText("E");
        button_E.setToolTipText("Guess E");
        button_E.setPreferredSize(new java.awt.Dimension(41, 41));
        button_E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_EActionPerformed(evt);
            }
        });
        add(button_E, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 288, 40, 40));

        button_F.setText("F");
        button_F.setToolTipText("Guess F");
        button_F.setPreferredSize(new java.awt.Dimension(41, 41));
        button_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_FActionPerformed(evt);
            }
        });
        add(button_F, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 288, 40, 40));

        button_G.setText("G");
        button_G.setToolTipText("Guess G");
        button_G.setPreferredSize(new java.awt.Dimension(41, 41));
        button_G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_GActionPerformed(evt);
            }
        });
        add(button_G, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 288, 40, 40));

        button_H.setText("H");
        button_H.setToolTipText("Guess H");
        button_H.setPreferredSize(new java.awt.Dimension(41, 41));
        button_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_HActionPerformed(evt);
            }
        });
        add(button_H, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 288, 40, 40));

        button_I.setText("I");
        button_I.setToolTipText("Guess I");
        button_I.setPreferredSize(new java.awt.Dimension(41, 41));
        button_I.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_IActionPerformed(evt);
            }
        });
        add(button_I, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 288, 40, 40));

        button_J.setText("J");
        button_J.setToolTipText("Guess J");
        button_J.setPreferredSize(new java.awt.Dimension(41, 41));
        button_J.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_JActionPerformed(evt);
            }
        });
        add(button_J, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 288, 40, 40));

        button_K.setText("K");
        button_K.setToolTipText("Guess K");
        button_K.setPreferredSize(new java.awt.Dimension(41, 41));
        button_K.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_KActionPerformed(evt);
            }
        });
        add(button_K, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 288, 40, 40));

        button_L.setText("L");
        button_L.setToolTipText("Guess L");
        button_L.setPreferredSize(new java.awt.Dimension(41, 41));
        button_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_LActionPerformed(evt);
            }
        });
        add(button_L, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 288, 40, 40));

        button_M.setText("M");
        button_M.setToolTipText("Guess M");
        button_M.setPreferredSize(new java.awt.Dimension(41, 41));
        button_M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_MActionPerformed(evt);
            }
        });
        add(button_M, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 288, 40, 40));

        button_N.setText("N");
        button_N.setToolTipText("Guess N");
        button_N.setPreferredSize(new java.awt.Dimension(41, 41));
        button_N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_NActionPerformed(evt);
            }
        });
        add(button_N, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 336, 40, 40));

        button_O.setText("O");
        button_O.setToolTipText("Guess O");
        button_O.setPreferredSize(new java.awt.Dimension(41, 41));
        button_O.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_OActionPerformed(evt);
            }
        });
        add(button_O, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 336, 40, 40));

        button_P.setText("P");
        button_P.setToolTipText("Guess P");
        button_P.setPreferredSize(new java.awt.Dimension(41, 41));
        button_P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_PActionPerformed(evt);
            }
        });
        add(button_P, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 336, 40, 40));

        button_R.setText("R");
        button_R.setToolTipText("Guess R");
        button_R.setPreferredSize(new java.awt.Dimension(41, 41));
        button_R.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_RActionPerformed(evt);
            }
        });
        add(button_R, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 336, 40, 40));

        button_S.setText("S");
        button_S.setToolTipText("Guess S");
        button_S.setPreferredSize(new java.awt.Dimension(41, 41));
        button_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_SActionPerformed(evt);
            }
        });
        add(button_S, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 336, 40, 40));

        button_Q.setText("Q");
        button_Q.setToolTipText("Guess Q");
        button_Q.setPreferredSize(new java.awt.Dimension(41, 41));
        button_Q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_QActionPerformed(evt);
            }
        });
        add(button_Q, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 336, 40, 40));

        button_T.setText("T");
        button_T.setToolTipText("Guess T");
        button_T.setPreferredSize(new java.awt.Dimension(41, 41));
        button_T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_TActionPerformed(evt);
            }
        });
        add(button_T, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 336, 40, 40));

        button_U.setText("U");
        button_U.setToolTipText("Guess U");
        button_U.setPreferredSize(new java.awt.Dimension(41, 41));
        button_U.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_UActionPerformed(evt);
            }
        });
        add(button_U, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 336, 40, 40));

        button_V.setText("V");
        button_V.setToolTipText("Guess V");
        button_V.setPreferredSize(new java.awt.Dimension(41, 41));
        button_V.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_VActionPerformed(evt);
            }
        });
        add(button_V, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 336, 40, 40));

        button_W.setText("W");
        button_W.setToolTipText("Guess W");
        button_W.setPreferredSize(new java.awt.Dimension(41, 41));
        button_W.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_WActionPerformed(evt);
            }
        });
        add(button_W, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 336, 40, 40));

        button_X.setText("X");
        button_X.setToolTipText("Guess X");
        button_X.setPreferredSize(new java.awt.Dimension(41, 41));
        button_X.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_XActionPerformed(evt);
            }
        });
        add(button_X, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 336, 40, 40));

        button_Y.setText("Y");
        button_Y.setToolTipText("Guess Y");
        button_Y.setPreferredSize(new java.awt.Dimension(41, 41));
        button_Y.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_YActionPerformed(evt);
            }
        });
        add(button_Y, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 336, 40, 40));

        button_Z.setText("Z");
        button_Z.setToolTipText("Guess Z");
        button_Z.setPreferredSize(new java.awt.Dimension(41, 41));
        button_Z.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ZActionPerformed(evt);
            }
        });
        add(button_Z, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 336, 40, 40));

        button_Skip.setText("SKIP");
        button_Skip.setToolTipText("Click to skip Hangman.");
        button_Skip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_SkipActionPerformed(evt);
            }
        });
        add(button_Skip, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 45, -1, -1));

        platform.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/platform.png"))); // NOI18N
        platform.setToolTipText("\"Please Help Me!\"");
        add(platform, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 80, 200, 200));

        head.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/head.png"))); // NOI18N
        add(head, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 200, 200));

        body.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/body.png"))); // NOI18N
        add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 200, 200));

        leftArm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leftArm.png"))); // NOI18N
        add(leftArm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 200, 200));

        rightArm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rightArm.png"))); // NOI18N
        add(rightArm, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 200, 200));

        leftLeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leftLeg.png"))); // NOI18N
        add(leftLeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 200, 200));

        rightLeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rightleg.png"))); // NOI18N
        add(rightLeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 200, 200));

        wordArea.setToolTipText("\"Wouldn't you like to know.\"");
        wordArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        alert.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        alert.setForeground(new java.awt.Color(255, 0, 51));
        alert.setText("INCORRECT LETTER");
        alert.setToolTipText("\"Oops!\"");
        wordArea.add(alert, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        add(wordArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 360, 180));

        time.setBackground(new java.awt.Color(255, 255, 255));
        time.setText("timer");
        time.setToolTipText("Tick tock.");
        time.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void button_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_BActionPerformed
        // TODO add your handling code here:
        button_B.setEnabled(false);
        checkLetter("B");
    }//GEN-LAST:event_button_BActionPerformed

    private void button_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AActionPerformed
        // TODO add your handling code here:
        button_A.setEnabled(false);
        checkLetter("A");
    }//GEN-LAST:event_button_AActionPerformed

    private void button_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_DActionPerformed
        // TODO add your handling code here:
        button_D.setEnabled(false);
        checkLetter("D");
    }//GEN-LAST:event_button_DActionPerformed

    private void button_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_CActionPerformed
        // TODO add your handling code here:
        button_C.setEnabled(false);
        checkLetter("C");
    }//GEN-LAST:event_button_CActionPerformed

    private void button_GActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_GActionPerformed
        // TODO add your handling code here:
        button_G.setEnabled(false);
        checkLetter("G");
    }//GEN-LAST:event_button_GActionPerformed

    private void button_EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_EActionPerformed
        // TODO add your handling code here:
        button_E.setEnabled(false);
        checkLetter("E");
    }//GEN-LAST:event_button_EActionPerformed

    private void button_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_FActionPerformed
        // TODO add your handling code here:
        button_F.setEnabled(false);
        checkLetter("F");
    }//GEN-LAST:event_button_FActionPerformed

    private void button_IActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_IActionPerformed
        // TODO add your handling code here:
        button_I.setEnabled(false);
        checkLetter("I");
    }//GEN-LAST:event_button_IActionPerformed

    private void button_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_HActionPerformed
        // TODO add your handling code here:
        button_H.setEnabled(false);
        checkLetter("H");
    }//GEN-LAST:event_button_HActionPerformed

    private void button_KActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_KActionPerformed
        // TODO add your handling code here:
        button_K.setEnabled(false);
        checkLetter("K");
    }//GEN-LAST:event_button_KActionPerformed

    private void button_JActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_JActionPerformed
        // TODO add your handling code here:
        button_J.setEnabled(false);
        checkLetter("J");
    }//GEN-LAST:event_button_JActionPerformed

    private void button_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_LActionPerformed
        // TODO add your handling code here:
        button_L.setEnabled(false);
        checkLetter("L");
    }//GEN-LAST:event_button_LActionPerformed

    private void button_MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_MActionPerformed
        // TODO add your handling code here:
        button_M.setEnabled(false);
        checkLetter("M");
    }//GEN-LAST:event_button_MActionPerformed

    private void button_VActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_VActionPerformed
        // TODO add your handling code here:
        button_V.setEnabled(false);
        checkLetter("V");
    }//GEN-LAST:event_button_VActionPerformed

    private void button_UActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_UActionPerformed
        // TODO add your handling code here:
        button_U.setEnabled(false);
        checkLetter("U");
    }//GEN-LAST:event_button_UActionPerformed

    private void button_XActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_XActionPerformed
        // TODO add your handling code here:
        button_X.setEnabled(false);
        checkLetter("X");
    }//GEN-LAST:event_button_XActionPerformed

    private void button_WActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_WActionPerformed
        // TODO add your handling code here:
        button_W.setEnabled(false);
        checkLetter("W");
    }//GEN-LAST:event_button_WActionPerformed

    private void button_OActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_OActionPerformed
        // TODO add your handling code here:
        button_O.setEnabled(false);
        checkLetter("O");
    }//GEN-LAST:event_button_OActionPerformed

    private void button_YActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_YActionPerformed
        // TODO add your handling code here:
        button_Y.setEnabled(false);
        checkLetter("Y");
    }//GEN-LAST:event_button_YActionPerformed

    private void button_NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_NActionPerformed
        // TODO add your handling code here:
        button_N.setEnabled(false);
        checkLetter("N");
    }//GEN-LAST:event_button_NActionPerformed

    private void button_ZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ZActionPerformed
        // TODO add your handling code here:
        button_Z.setEnabled(false);
        checkLetter("Z");
    }//GEN-LAST:event_button_ZActionPerformed

    private void button_QActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_QActionPerformed
        // TODO add your handling code here:
        button_Q.setEnabled(false);
        checkLetter("Q");
    }//GEN-LAST:event_button_QActionPerformed

    private void button_PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_PActionPerformed
        // TODO add your handling code here:
        button_P.setEnabled(false);
        checkLetter("P");
    }//GEN-LAST:event_button_PActionPerformed

    private void button_TActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_TActionPerformed
        // TODO add your handling code here:
        button_T.setEnabled(false);
        checkLetter("T");
    }//GEN-LAST:event_button_TActionPerformed

    private void button_RActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_RActionPerformed
        // TODO add your handling code here:
        button_R.setEnabled(false);
        checkLetter("R");
    }//GEN-LAST:event_button_RActionPerformed

    private void button_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_SActionPerformed
        // TODO add your handling code here:
        button_S.setEnabled(false);
        checkLetter("S");
    }//GEN-LAST:event_button_SActionPerformed

    private void button_SkipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_SkipActionPerformed
        // TODO add your handling code here:
        ScoreManager.setScore(0);
        GameScreen1.updateScoreLabel();
        w.switchPanes("game1");
        this.resetHangman();
    }//GEN-LAST:event_button_SkipActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alert;
    private javax.swing.JLabel body;
    private javax.swing.JButton button_A;
    private javax.swing.JButton button_B;
    private javax.swing.JButton button_C;
    private javax.swing.JButton button_D;
    private javax.swing.JButton button_E;
    private javax.swing.JButton button_F;
    private javax.swing.JButton button_G;
    private javax.swing.JButton button_H;
    private javax.swing.JButton button_I;
    private javax.swing.JButton button_J;
    private javax.swing.JButton button_K;
    private javax.swing.JButton button_L;
    private javax.swing.JButton button_M;
    private javax.swing.JButton button_N;
    private javax.swing.JButton button_O;
    private javax.swing.JButton button_P;
    private javax.swing.JButton button_Q;
    private javax.swing.JButton button_R;
    private javax.swing.JButton button_S;
    private javax.swing.JButton button_Skip;
    private javax.swing.JButton button_T;
    private javax.swing.JButton button_U;
    private javax.swing.JButton button_V;
    private javax.swing.JButton button_W;
    private javax.swing.JButton button_X;
    private javax.swing.JButton button_Y;
    private javax.swing.JButton button_Z;
    private javax.swing.JLabel head;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel leftArm;
    private javax.swing.JLabel leftLeg;
    public static javax.swing.JLabel myScore;
    private javax.swing.JLabel platform;
    private javax.swing.JLabel rightArm;
    private javax.swing.JLabel rightLeg;
    private javax.swing.JLabel time;
    private javax.swing.JPanel wordArea;
    // End of variables declaration//GEN-END:variables
}
