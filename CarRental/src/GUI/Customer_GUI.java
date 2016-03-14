/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.Controller;
import Logic.*;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Vector;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aldo
 */
public class Customer_GUI extends JFrame {

    private Controller controller;
    
    String[] rentedCarColumnNames = {"Select",
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
    
    String[] findCarColumnNames = {"Select","ID", "Make", "Model", "Year","Size"};

    public Customer_GUI(int layout, String name, Controller controller) {
        this.controller = controller;
        
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Create the tab pages
        JPanel panel1 = findCarTab(controller);
        JPanel panel2 = rentedCarsTab();
        JPanel panel3 = accountHistoryTab();

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
        
        populateFindCarTable();

    }

    private JPanel findCarTab(Controller controller) {
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
//      Add Search Bar
        JTextField customerSearchText = new JTextField(20);
        customerSearchText.setBounds(10, 15, 350, 25);
        panel1.add(customerSearchText);
        
        Object[][] tableData = controller.getAvailableCars();
        MyTableModel model = new MyTableModel(tableData, findCarColumnNames);
        JTable findCarTable = new JTable(model);
        
        //     Add Search Button       
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(365, 15, 100, 25);
         searchButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                LinkedList<CarSpec> carSpecs = controller.searchCarSpecs(customerSearchText.getText());
                model.setRowCount(0);
                
                for (CarSpec carSpec : carSpecs) {
                     for (Car car: carSpec.getCars()) {
                        model.addRow(new Object[]{false,car.getID(),carSpec.getMake(), carSpec.getModel(), carSpec.getYear(),carSpec.getSize()});
               // for(CarSpec spec :carSpecs){
               //     model.addRow(new Object[]{false,car.getID(),carSpec.getMake(), carSpec.getModel(), carSpec.getYear(),carSpec.getSize()};
               }
            }
            }
        });
        panel1.add(searchButton);
//      Add Rent Selected button
        JButton rentSelectedButton = new JButton("Rent Selected");
        //
        rentSelectedButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            
            Rent_Car_GUI rentCar = new Rent_Car_GUI();
            rentCar.setTitle("Rent Car");
            rentCar.setDefaultCloseOperation(EXIT_ON_CLOSE);
            rentCar.setLocation(400, 350);
            rentCar.setSize(300,200);
            rentCar.setMaximumSize(new Dimension(800, 400));
            rentCar.setVisible(true);
            
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
    
    private void populateFindCarTable() {
        //Object[][] cars = controller.getAvailableCars();
       // findCarTable.setModel(new DefaultTableModel(cars, findCarColumnNames));
    }

    private JPanel rentedCarsTab() {
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        JButton returnCarButton = new JButton("Return Selected");
        returnCarButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            
            Return_Car_GUI returnCar = new Return_Car_GUI();
            returnCar.setTitle("Return Car");
            returnCar.setDefaultCloseOperation(EXIT_ON_CLOSE);
            returnCar.setLocation(400, 350);
            returnCar.setSize(300,200);
            returnCar.setMaximumSize(new Dimension(800, 400));
            returnCar.setVisible(true);
            
        }
    });
        returnCarButton.setBounds(25, 15, 135, 25);
        panel2.add(returnCarButton);
        
        Object[][] tableData = {{false, "Nissan", "Altima", "2012", "10/12/16"}, {false, "", "", "", ""}};
        MyTableModel model = new MyTableModel(tableData, rentedCarColumnNames);

        JTable table = new JTable(model);

        //table.setBounds(50, 120, 550, 300);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 50, 550, 300);
        panel2.add(scrollPane);
        table.setRowSelectionInterval(0, 0);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        return panel2;
    }

    private JPanel accountHistoryTab() {
        JPanel panel3 = new JPanel();
        panel3.setLayout(null);

        
        Object[][] tableData = {{"123", "Nissan", "Altima", "2012", "10/12/16", "10/15/16"}, {"234", "", "", "", "", ""}};
        //TableModel model = new MyTableModel(tableData, columnNames);

        JTable table = new JTable(tableData, accountHistoryColumnNames);

        //table.setBounds(50, 120, 550, 300);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 50, 550, 300);
        panel3.add(scrollPane);
        table.setRowSelectionInterval(0, 0);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        return panel3;
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
            System.out.println(aValue);
            Vector rowData = (Vector) getDataVector().get(row);
            rowData.set(0, (boolean) aValue);
            fireTableCellUpdated(row, column);
        }
    }
}
