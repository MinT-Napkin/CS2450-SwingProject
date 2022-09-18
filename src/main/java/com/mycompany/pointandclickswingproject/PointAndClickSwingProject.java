/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.pointandclickswingproject;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

/**
 *
 * @author sirmu
 */
public class PointAndClickSwingProject {
    
    public static mainJFrame w;

        public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    JPanel splashScreen = new com.mycompany.pointandclickswingproject.SplashScreen();
                    JPanel menuScreen = new com.mycompany.pointandclickswingproject.MenuScreen();
                    JPanel leaderboardScreen = new com.mycompany.pointandclickswingproject.LeaderboardScreen();
                    JPanel gameScreen = new com.mycompany.pointandclickswingproject.GameScreen();
                    JPanel creditsScreen = new com.mycompany.pointandclickswingproject.CreditsScreen();
                    w = new mainJFrame(splashScreen, menuScreen, leaderboardScreen, gameScreen, creditsScreen);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PointAndClickSwingProject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
