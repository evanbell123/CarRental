/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.Customer;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

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
        String Error="Please Select one Account";
        
        JTextField customerSearchText = new JTextField(20);
        customerSearchText.setBounds(50, 20, 350, 25);
        panel.add(customerSearchText);
        
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(425, 20, 100, 25);
        panel.add(searchButton);
        
        
        
        
        
        
         String[] columnNames = {"Name",
                                "Telephone",
                                "Address"};
        Object[][] customerTableData = {};
        DefaultTableModel customerModel = new DefaultTableModel(customerTableData, columnNames);

        JTable table = new JTable(customerModel);
        //table.setBounds(50, 120, 550, 300);

        for (Customer cust : this.controller.getCustomers()) {
            customerModel.addRow(new Object[]{cust.getName(), cust.getPhone(), cust.getAddress()});    
        }
    
            
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 120, 550, 300);
        panel.add(scrollPane);
        table.setRowSelectionInterval(0, 0);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JButton rentCarButton = new JButton("Rent Car");
        rentCarButton.setBounds(50, 70, 115, 25);
        
        
        searchButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                LinkedList<Customer> customers = controller.searchCustomers(customerSearchText.getText());
                customerModel.setRowCount(0);
                for(Customer cust :customers){
                    customerModel.addRow(new Object[]{cust.getName(), cust.getPhone(), cust.getAddress()});
                }
            }
        });
        
        rentCarButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //String CustomerName= jtable
                int layout =0;

                if(table.getSelectedRow() == -1){
                    JOptionPane.showMessageDialog(null, Error, "NO ACCOUNT SELECTED",JOptionPane.ERROR_MESSAGE);  
                }else{
                    String accountName =new String();
                    accountName = customerModel.getValueAt(table.getSelectedRow(),0).toString();
                    Customer_GUI frame=new Customer_GUI(layout, accountName, Search_GUI.this.controller);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    frame.setLocation(250, 250);
                    frame.setSize(700,500);
                    frame.setMaximumSize(new Dimension(800, 400));
                    frame.setVisible(true);
                
                
            }
            }});
        panel.add(rentCarButton);
        
        JButton rentedCarsButton = new JButton("Rented Cars");
        rentedCarsButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               // String accountName =new String();
               // accountName=model.getValueAt(0,0).toString();  
                if(table.getSelectedRow() == -1){
                    JOptionPane.showMessageDialog(null, Error, "NO ACCOUNT SELECTED",JOptionPane.ERROR_MESSAGE);  
                }else{
                    String accountName =new String();
                    accountName = customerModel.getValueAt(table.getSelectedRow(),0).toString();
                    int layout = 1;

                
                //String CustomerName= jtable
                Customer_GUI frame = new Customer_GUI(layout, accountName,Search_GUI.this.controller);
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setLocation(250, 250);
                frame.setSize(700,500);
                frame.setMaximumSize(new Dimension(800, 400));
                frame.setVisible(true);
            }
            }
                });
        
        rentedCarsButton.setBounds(200, 70, 115, 25);
        panel.add(rentedCarsButton);
        
       
        add(panel);
    }
}