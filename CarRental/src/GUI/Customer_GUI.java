/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author aldo
 */
public class Customer_GUI extends JFrame {

    private CarRental controller;

    public Customer_GUI(int layout, String name, CarRental controller){
      JPanel panel=new JPanel();
      panel.setLayout(null);

      // Create the tab pages
      JPanel panel1=	findCarTab(controller);
      JPanel panel2=	rentedCarsTab();
      JPanel panel3=  accountHistoryTab();

        String accountName =  "My Account";
        JLabel accountNameLabel = new JLabel(accountName);
        accountNameLabel.setBounds(50, 50, 200, 25);
        panel.add(accountNameLabel);
        JTabbedPane tabbedPane = new JTabbedPane();

//      FIND CARS tab

        tabbedPane.addTab("Find Car", null, panel1,
                "Help customer find car");


//      Rented Cars tab
        tabbedPane.addTab("Rented Cars", null, panel2,
                            "See cars currently rented");


//      Returned Cars tab
        tabbedPane.addTab("Returned Cars", null, panel3,
                            "See customers returned cars");


        tabbedPane.setBounds(50,120,550,300);



        //panel.add(customerNameText);
        panel.add(tabbedPane);
        add(panel);



    }

    private JPanel findCarTab(CarRental controller) {
        JPanel panel1 = new JPanel();
        String[] columnNames = {"Make","Model","Size"};
        Object[][] tableData = {};
        JTable findCarTable = new JTable(new DefaultTableModel(tableData,columnNames));
        controller.populateFindCarTable(findCarTable);
        JScrollPane findCarScrollPane = new JScrollPane(findCarTable);
        findCarScrollPane.setBounds(50, 120, 550, 300);
        //tabbedPane.add(findCarScrollPane);
        findCarTable.setRowSelectionInterval(0, 0);
        findCarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//      Adding table to find car tab
        panel1.add(findCarScrollPane);
        return panel1;
    }

    private JPanel rentedCarsTab() {
        JPanel panel2 = new JPanel();
	panel2.setLayout( null );
        JButton returnCarButton = new JButton("Return Selected");
        returnCarButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Car Returned Successfully", "CAR RETURNED", JOptionPane.INFORMATION_MESSAGE);

            }
            });
        returnCarButton.setBounds(25, 15, 135, 25);
        panel2.add(returnCarButton);
         String[] columnNames = {"Select",
                                "Make",
                                "Model",
                                "Year",
                                "Rented"};
        Object[][] tableData = {{false,"Nissan", "Altima", "2012", "10/12/16"},{false,"","","", ""}};
        MyTableModel model = new MyTableModel(tableData, columnNames);

        JTable table = new JTable(model);



        //table.setBounds(50, 120, 550, 300);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(25, 50, 500, 300);
        panel2.add(scrollPane);
        table.setRowSelectionInterval(0, 0);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return panel2;
    }

    private JPanel accountHistoryTab() {
JPanel panel3 = new JPanel();
	panel3.setLayout( null );

         String[] columnNames = {"ID",
                                "Make",
                                "Model",
                                "Year",
                                "Rented",
                                "Returned"};
        Object[][] tableData = {{"123","Nissan", "Altima", "2012", "10/12/16", "10/15/16"},{"234","","","","", ""}};
        //TableModel model = new MyTableModel(tableData, columnNames);

        JTable table = new JTable(tableData, columnNames);



        //table.setBounds(50, 120, 550, 300);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(25, 50, 500, 300);
        panel3.add(scrollPane);
        table.setRowSelectionInterval(0, 0);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        return panel3;
    }
}

class MyTableModel extends DefaultTableModel {

    public MyTableModel(Object [][] tableData, String[] columnNames) {
      super(tableData, columnNames);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
      Class type = String.class;
      switch (columnIndex) {
        case 0:
          type = Boolean.class;
          break;
      }
      return type;
    }

     @Override
    public boolean isCellEditable(int row, int column) {
      return column == 0;
    }

        @Override
    public void setValueAt(Object aValue, int row, int column) {
      if (aValue instanceof Boolean && column == 0) {
        System.out.println(aValue);
        Vector rowData = (Vector)getDataVector().get(row);
        rowData.set(0, (boolean)aValue);
        fireTableCellUpdated(row, column);
      }
    }
}
