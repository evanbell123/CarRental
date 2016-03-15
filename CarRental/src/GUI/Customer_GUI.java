/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.Controller;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Vector;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author aldo
 */
public final class Customer_GUI extends JFrame {

    private final Controller controller;

    LinkedList<String> selectedAvailableCars;
    LinkedList<Integer> selectedRentedCars;

    JTable findCarTable;
    JTable rentedCarsTable;
    JTable returnedCarsTable;
    
    MyTableModel findCarModel;
    JTextField customerSearchText;

    String[] rentedCarColumnNames = {"Select",
        "ID",
        "Make",
        "Model",
        "Year",
        "Rented"};

    String[] accountHistoryColumnNames = {"ID",
        "Make",
        "Model",
        "Year",
        "Rented",
        "Returned"};

    String[] findCarColumnNames = {"Select", "ID", "Make", "Model", "Year", "Size"};

    public Customer_GUI(int layout, String name, String phoneNumber, String address, Controller controller) {
        this.controller = controller;
        selectedAvailableCars = new LinkedList<>();
        selectedRentedCars = new LinkedList<>();

        Object[][] tableData = controller.getAvailableCars();

        findCarModel = new MyTableModel(tableData, findCarColumnNames);
        findCarTable = new JTable(findCarModel);

        MyTableModel rentedCarsModel = new MyTableModel(tableData, rentedCarColumnNames);
        rentedCarsTable = new JTable(rentedCarsModel);
        
        returnedCarsTable = new JTable(tableData, accountHistoryColumnNames);
        
        updateTables(name, phoneNumber, address);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Create the tab pages
        JPanel panel1 = findCarTab(name, phoneNumber, address, controller);
        JPanel panel2 = rentedCarsTab(name, phoneNumber, address, controller);
        JPanel panel3 = accountHistoryTab(name, phoneNumber, address, controller);

        String accountName = name + "'s Account";
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

        tabbedPane.setBounds(50, 120, 550, 300);
        tabbedPane.setSelectedIndex(layout);

        //panel.add(customerNameText);
        panel.add(tabbedPane);
        add(panel);

        //populateFindCarTable();
    }

    private JPanel findCarTab(String name, String phoneNumber, String address, Controller controller) {
        
        
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
//      Add Search Bar
        customerSearchText = new JTextField(20);
        customerSearchText.setBounds(10, 15, 350, 25);
        panel1.add(customerSearchText);
        //     Add Search Button       
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(365, 15, 100, 25);
        
        panel1.add(searchButton);
          searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSearchTable();
                
                
            }
        });
        
        //      Add Rent Selected button
        JButton rentSelectedButton = new JButton("Rent Selected");
        
        rentSelectedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (selectedAvailableCars.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a car to rent", null, JOptionPane.ERROR_MESSAGE);
                } else {
                    while (!selectedAvailableCars.isEmpty()) {
                        String rentDate = JOptionPane.showInputDialog("Enter the pickup date for Car # " + selectedAvailableCars.getLast() + " :");
                        controller.rentCar(name, phoneNumber, address, selectedAvailableCars.getLast(), rentDate);
                        selectedAvailableCars.removeLast();
                    }
                    updateTables(name, phoneNumber, address);
                }
            }
        });

        rentSelectedButton.setBounds(10, 45, 115, 25);
        panel1.add(rentSelectedButton);

        JScrollPane findCarScrollPane = new JScrollPane(findCarTable);
        findCarScrollPane.setBounds(0, 75, 550, 300);
        //tabbedPane.add(findCarScrollPane);
        //findCarTable.setRowSelectionInterval(0, 0);
        //findCarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//      Adding table to find car tab
        panel1.add(findCarScrollPane);
        return panel1;
    }
    /*
     private void populateFindCarTable() {
     Object[][] cars = controller.getAvailableCars();
     findCarTable.setModel(new MyTableModel(cars, findCarColumnNames));
     }
     */

    private JPanel rentedCarsTab(String name, String phoneNumber, String address, Controller controller) {
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);

        //rentedCarsTable.setModel(new MyTableModel(controller.getRentedCars(name, phoneNumber, address), findCarColumnNames));
        

        JButton returnCarButton = new JButton("Return Selected");
        returnCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedRentedCars.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select a car to rent", null, JOptionPane.ERROR_MESSAGE);
                } else {
                    while (!selectedRentedCars.isEmpty()) {
                        String returnDate = JOptionPane.showInputDialog("Enter the returnDate date for Car # " + selectedRentedCars.getLast() + " :");
                        controller.returnCar(name, phoneNumber, address, selectedRentedCars.getLast(), returnDate);
                        selectedRentedCars.removeLast();
                    }
                    //rentedCarsTable.setModel(new MyTableModel(controller.getRentedCars(name, phoneNumber, address), findCarColumnNames));
                    updateTables(name, phoneNumber, address);
                }
            }
        });
        returnCarButton.setBounds(25, 15, 135, 25);
        panel2.add(returnCarButton);

        //table.setBounds(50, 120, 550, 300);
        JScrollPane scrollPane = new JScrollPane(rentedCarsTable);
        scrollPane.setBounds(0, 50, 550, 300);
        panel2.add(scrollPane);
        //rentedCarsTable.setRowSelectionInterval(0, 0);
        rentedCarsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return panel2;
    }

    private JPanel accountHistoryTab(String name, String phoneNumber, String address, Controller controller) {
        JPanel panel3 = new JPanel();
        panel3.setLayout(null);

        //Object[][] tableData = {};
        //TableModel model = new MyTableModel(tableData, columnNames);

        //table.setBounds(50, 120, 550, 300);
        JScrollPane scrollPane = new JScrollPane(returnedCarsTable);
        scrollPane.setBounds(0, 50, 550, 300);
        panel3.add(scrollPane);
        //table.setRowSelectionInterval(0, 0);
        returnedCarsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        return panel3;
    }
    
    void updateSearchTable(){
        findCarTable.setModel(new MyTableModel(controller.getSearchCars(customerSearchText.getText()), findCarColumnNames));
    }

    void updateTables(String name, String phoneNumber, String address) {
        findCarTable.setModel(new MyTableModel(controller.getAvailableCars(), findCarColumnNames));
        findCarTable.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int col = e.getColumn();

                Boolean selected = (Boolean) findCarTable.getValueAt(row, col);
                String carID = (String) findCarTable.getValueAt(row, 1);

                if (selected) { //if the select box is checked
                    selectedAvailableCars.add(carID);
                } else {
                    selectedAvailableCars.remove(carID);
                }
            }
        });
        
        rentedCarsTable.setModel(new MyTableModel(controller.getRentedCars(name, phoneNumber, address), rentedCarColumnNames));
        rentedCarsTable.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int col = e.getColumn();

                Boolean selected = (Boolean) rentedCarsTable.getValueAt(row, col);
                
                int id = (int) rentedCarsTable.getValueAt(row, 1);

                if (selected) { //if the select box is checked
                    selectedRentedCars.add(id);
                } else {
                    selectedRentedCars.remove(id);
                }

                System.out.println(selectedRentedCars);
            }
        });
        
        returnedCarsTable.setModel(new DefaultTableModel(controller.getReturnedCars(name, phoneNumber, address), accountHistoryColumnNames));
    }
}

class MyTableModel extends DefaultTableModel {

    public MyTableModel(Object[][] tableData, String[] columnNames) {
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
            //System.out.println(aValue);
            Vector rowData = (Vector) getDataVector().get(row);
            rowData.set(0, (boolean) aValue);
            fireTableCellUpdated(row, column);
        }
    }
}
