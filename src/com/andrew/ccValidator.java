package com.andrew;/*
 Created by Andrew on 10/25/2016.
 */

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ccValidator extends JFrame{
    private JTextField entryField;
    private JButton checkButton;
    private JButton exitButton;
    private JPanel rootPanel;
    private JLabel resultsLabel;

    ccValidator() {
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String ccNumber = entryField.getText();

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isValid = isValidCreditCard(ccNumber);

                if (isValid) {
                    resultsLabel.setText("This is a valid number.");
                } else {
                    resultsLabel.setText("This is **not** a valid credit card number.");
                }
            }
        });
    }

    public static boolean isValidCreditCard(String cc) {

        char[] ccArray = cc.toCharArray();
        String add = "";
        int total = 0;

        if (ccArray.length == 16 && ccArray[0] == '4') {
            for (int i = 0; i < ccArray.length; i++) {
                if (i % 2 == 0) {
                    if (ccArray[i] == '1') add += 2;
                    else if (ccArray[i] == '2') add += 4;
                    else if (ccArray[i] == '3') add += 6;
                    else if (ccArray[i] == '4') add += 8;
                    else if (ccArray[i] == '5') add += 1;
                    else if (ccArray[i] == '6') add += 3;
                    else if (ccArray[i] == '7') add += 5;
                    else if (ccArray[i] == '8') add += 7;
                    else if (ccArray[i] == '9') add += 9;
                } else add += ccArray[i];
            }
            char[] numsToAdd = add.toCharArray();
            for (int i = 0; i < numsToAdd.length; i++) {
                total += numsToAdd[i] - 48;
            }
            return total % 10 == 0;
        } else return false;
    }
}
