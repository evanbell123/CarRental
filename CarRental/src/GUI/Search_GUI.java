/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author aldo
 */
public class Search_GUI extends JFrame {
    private CarRental controller;
    
    public Search_GUI(CarRental controller) {
        this.controller = controller;
        JPanel panel=new JPanel();
        panel.setLayout(null);
        
        JTextField customerSearchText = new JTextField(20);
        customerSearchText.setBounds(50, 20, 350, 25);
        panel.add(customerSearchText);
        
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(425, 20, 100, 25);
        panel.add(searchButton);
        
        JButton rentCarButton = new JButton("Rent Car");
        rentCarButton.setBounds(50, 70, 115, 25);
        panel.add(rentCarButton);
        
        JButton rentedCarsButton = new JButton("Rented Cars");
        rentedCarsButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //String CustomerName= jtable
                Customer_GUI frame = new Customer_GUI(Search_GUI.this.controller);
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setLocation(250, 250);
                frame.setSize(700,500);
                frame.setMaximumSize(new Dimension(800, 400));
                frame.setVisible(true);
            }
                });
        
        rentedCarsButton.setBounds(200, 70, 115, 25);
        panel.add(rentedCarsButton);
        
        String[] columnNames = {"Name",
                                "Telephone",
                                "Address"};
        Object[][] tableData = {{"aldo", "123-456-789", "100 umkc"},{"","",""}};
        
        JTable table = new JTable(tableData, columnNames);
        //table.setBounds(50, 120, 550, 300);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 120, 550, 300);
        panel.add(scrollPane);
        table.setRowSelectionInterval(0, 0);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(panel);
    }
}