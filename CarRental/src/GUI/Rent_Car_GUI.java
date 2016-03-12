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
public class Rent_Car_GUI extends JFrame{
    public Rent_Car_GUI(){
        // Add Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        // Label for instruction
        JLabel instructionLabel = new JLabel("Enter Date in mm/dd/yy form");
        instructionLabel.setBounds(50,10,200,15);
        panel.add(instructionLabel);
        // Label for rent car date
        JLabel rentCarLabel = new JLabel("Please Select Rent Date: ");
        rentCarLabel.setBounds(05,45,200,10);
        panel.add(rentCarLabel);
        // Label for return car date
        JLabel returnCarLabel = new JLabel("Please Select Return Date: ");
        returnCarLabel.setBounds(05,95,200,10);
        panel.add(returnCarLabel);        
        // Text field for rent date
        JTextField rentTextField = new JTextField(20);
        rentTextField.setBounds(155, 37, 125, 25);
        panel.add(rentTextField);
        // Text field for return date
        JTextField returnTextField = new JTextField(20);
        returnTextField.setBounds(155, 87, 125, 25);
        panel.add(returnTextField);
        // confirm button
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(75, 125, 125, 25);
        panel.add(confirmButton);
        add(panel);
    }
}
