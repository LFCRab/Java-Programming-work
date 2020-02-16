
/*
 * 
 * Author: Robbie Campbell
 *          (c)Poole College
 *          
 * Date: 16/12/2019
 * 
 * Class description
 * This class is used to welcome the user to this application and extend the grade calculator
 */
import javax.swing.*; 
import javax.swing.border.*; // Border classes
import java.awt.*; // Font, Color classes
import java.awt.event.*; //ActionEvent, ActionListener classes
import javax.swing.BorderFactory;
public class welcomeScreen implements ActionListener
{
    
    //define all variables globally
    
    JFrame welcome;
    JPanel mainPanel, headerPanel;
    JButton enter;
    JLabel header;
    Font myFont1, myFont2;
    Border border1;
    public welcomeScreen()
    {
        
     //create style elements for later use
     
     myFont1 = new Font("Serif",Font.BOLD,20);
     myFont2 = new Font("Serif",Font.BOLD,18);
     border1 = BorderFactory.createLoweredBevelBorder();
     
     //create the frame object and position it
     
     welcome = new JFrame();
     welcome.setBounds(700,400,400,350);
     welcome.setLocationRelativeTo(null);
     welcome.setVisible(true);
     welcome.setResizable(false);
     
     //set the 2 panel objects
     
     mainPanel = new JPanel();
     welcome.add(mainPanel);
     mainPanel.setLayout(null);
     
     headerPanel = new JPanel();
     mainPanel.add(headerPanel);
     headerPanel.setBounds(20,20,350,60);
     headerPanel.setBorder(border1);
     headerPanel.setLayout(null);
     
     //create both label objects and style them
     
     header = new JLabel("Welcome to the grade calculator");
     header.setBounds(40,10,300,40);
     header.setFont(myFont1);
     headerPanel.add(header);
     
     //Create the button to enter the calculator
     
     enter = new JButton("Enter");
     mainPanel.add(enter);
     enter.setBounds(125,210,130,40);
     enter.addActionListener(this);
    }
    
    //open the gradeCalculator
    
    public void actionPerformed (ActionEvent event)
    {
     if (event.getSource() == enter)
     {
         welcome.dispose();
         gradeCalculator open;
         open = new gradeCalculator();
     }
    }
}
