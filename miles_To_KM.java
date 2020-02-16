/** 
 * Author: Robbie Campbell
 * Copyright: Poole College (C)
 * Date: 16/02/2020
 * 
 * this is a class which will extend the miles to kilometers calculator
 **/

import javax.swing.*; 
import javax.swing.border.*; // Border classes
import java.awt.*; // Font, Color classes
import java.awt.event.*; //ActionEvent, ActionListener classes
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel; //imports a blank table with null values 
public class miles_To_KM{
    
    //define all of the variables
    
    JFrame mainFrame;
    JPanel headerPanel, mainPanel, converterPanel;
    Font myFont;
    JLabel title, miles, kilometers;
    Border raised;
    private static final Object[][] rowData = {}; 
    private static final String[] columnNames = {"Miles", "Kilometers"};
    public miles_To_KM(){

        //create the border and font objects
        
        raised = BorderFactory.createRaisedBevelBorder();
        myFont = new Font("serif",Font.PLAIN,18);
        
        //create the frame object
        
        mainFrame = new JFrame("Mile Converter");
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setBounds(200,100,400,350);
        
        //create the main Panel
        
        mainPanel = new JPanel();
        mainPanel.setBorder(raised);
        mainFrame.add(mainPanel);
        mainPanel.setLayout(null);
        
        //create the header panel
        
        headerPanel = new JPanel();
        headerPanel.setBounds(50,20,280,70);
        headerPanel.setBorder(raised);
        headerPanel.setLayout(null);
        mainPanel.add(headerPanel);
        
        //create the title label
        
        title = new JLabel("Welcome to the mile converter!");
        title.setFont(myFont);
        title.setBounds(25,10,300,50);
        headerPanel.add(title);
        
        //create the converterPanel
        
        converterPanel = new JPanel();
        converterPanel.setBounds(20,100,340,180);
        converterPanel.setBorder(raised);
        mainPanel.add(converterPanel);
        converterPanel.setLayout(null);
        
        /* create a loop to display both the miles and kilometers next to eachother, this will
         * be input into a table within a JTable object, so the output of the miles and kilometers
         * is displayed as an array
         */ 
        
        DefaultTableModel listTableModel;
        listTableModel = new DefaultTableModel(rowData, columnNames);
        
        for (int miles = 1; miles <21; miles++)
        {
            double DMiles = miles; 
            double Kilometers = DMiles *1.609;
            listTableModel.addRow(new Object[]{miles, Kilometers});
        }
        
        /*create the actual table and put it within a scrollpane object to allow for
         * the titles to be displayed and for the table to be scrollable.
         */
        
        JTable table = new JTable(listTableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20,20,300,150);
        table.setFillsViewportHeight(true);
        converterPanel.add(scrollPane);
    }
}