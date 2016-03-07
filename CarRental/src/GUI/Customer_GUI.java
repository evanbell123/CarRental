/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author aldo
 */
public class Customer_GUI extends JFrame {
    
    private CarRental controller;

    public Customer_GUI(CarRental controller){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        
        JTextField customerNameText=new JTextField("Aldo's Account");
        JTabbedPane tabbedPane = new JTabbedPane();
        
//      FIND CARS tab
        String[] columnNames = {"Make","Model","Size"};
        Object[][] tableData = {};
        JTable findCarTable = new JTable(new DefaultTableModel(tableData,columnNames));
        controller.populateFindCarTable(findCarTable);
        JScrollPane findCarScrollPane = new JScrollPane(findCarTable);
        findCarScrollPane.setBounds(50, 120, 550, 300);
        tabbedPane.add(findCarScrollPane);
        findCarTable.setRowSelectionInterval(0, 0);
        findCarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//      Adding table to find car tab
        tabbedPane.addTab("Find Car", null, findCarScrollPane, 
                "Help customer find car");
        
        
//      Rented Cars tab
        tabbedPane.addTab("Rented Cars", null, null, 
                            "See cars currently rented");

        
//      Returned Cars tab
        tabbedPane.addTab("Returned Cars", null, null,
                            "See customers returned cars");
        
        
        tabbedPane.setBounds(50,120,550,300);
        

    
        panel.add(customerNameText);
        panel.add(tabbedPane);
        add(panel);
        
        
     
    }
}
