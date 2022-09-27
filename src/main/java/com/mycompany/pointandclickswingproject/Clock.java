/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pointandclickswingproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author sirmu
 */
public class Clock {

    private JLabel tLabel;
    
    public Clock(JLabel timeLabel)
    {
        tLabel = timeLabel;
        Timer clock = new Timer (100, updateClock);
        clock.start();
    }
    
    public String getCurrentTime()
    {
        return tLabel.getText();
    }
    
    // action listener: updateClock
    /* purpose: this action listener is meant for a recurring timer that updates
    * every second to display the current time
    */
    ActionListener updateClock = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            SimpleDateFormat sdf = new SimpleDateFormat( " MMMMMMMMM dd, yyyy hh:mm:ss ");
            tLabel.setText(sdf.format(new Date())); 
        }
    };
    
}
