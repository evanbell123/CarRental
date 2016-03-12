/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.*;

/**
 *
 * @author aldo
 */
public class Return_Car_GUI extends JFrame {

    public Return_Car_GUI() {
    
     // Add Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        // Label for instruction
        JLabel instructionLabel = new JLabel("Enter Date in mm/dd/yy form");
        instructionLabel.setBounds(75,10,200,15);
        panel.add(instructionLabel);
        // Label for rent car date
        JLabel returnCarLabel = new JLabel("Please Select Return Date: ");
        returnCarLabel.setBounds(75,55,200,10);
        panel.add(returnCarLabel);
       
        // Text field for rent date
        JTextField returnTextField = new JTextField(20);
        returnTextField.setBounds(75, 75, 125, 25);
        panel.add(returnTextField);
       
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(75, 115, 125, 25);
        panel.add(confirmButton);
        add(panel);
    }
}