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
public class Customer_GUI extends JFrame {
    public Customer_GUI(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        
        JTextField customerNameText=new JTextField("Aldo's Account");
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Find Car", null, null,
                  "Help customer find car");
        tabbedPane.addTab("Rented Cars", null, null, 
                            "See cars currently rented");
        tabbedPane.addTab("Returned Cars", null, null,
                            "See customers returned cars");
        
        
        tabbedPane.setBounds(50,120,550,300);
    
        panel.add(customerNameText);
        panel.add(tabbedPane);
        
        add(panel);
    }
}
