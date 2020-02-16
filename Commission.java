
/*
 * Author: Robbie Campbell
 *          (c)Poole College
 *          
 * Date: 18/11/2019
 * 
 * Class Description:
 * This class will calculate commission owed to the sales person, it is based on a figure
 * entered by the user and is multiplied by the rate to provide both the amount owed and the 
 * rate it has been earned at to the user.
 * 
 * Rules
 *      The amount is less than 19999 the rate is 0%
 *      The amount is between 20000 and 31000 the rate is 5%
        The amount is between 31000 and 46000 the rate is 10%
        The amount is between 46000 and 60000 the rate is 12%
        The amount is over 60000 the rate is 15%
 * 
 */

import javax.swing.*; 
import javax.swing.border.*; // Border classes
import java.awt.*; // Font, Color classes
import java.awt.event.*; //ActionEvent, ActionListener classes
import javax.swing.BorderFactory;

public class Commission implements ActionListener
{
    
    //define all variables globally
    
    JFrame myFrame, printOut;
    JPanel mainPanel, headerPanel, leftPanel, rightPanel, printPanel, printText;;
    JButton calculate, refresh, exit, newFrame;
    JTextField employeeName, commissionInput;
    JLabel salesPrompt, header, namePrompt, printLabel;
    Font myFont1, myFont2, myFont3;
    Border border1, border2;
    JTextArea result;
    
    public Commission()
    {
        //make the frame and make size a constant
        
        myFrame = new JFrame("Sales Commission Calculator");
        myFrame.setResizable(false);
        
        //Panel objects
        
        mainPanel = new JPanel();
        headerPanel = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        
        //set layout for all of the panels
        
        mainPanel.setLayout(null);
        headerPanel.setLayout(null);
        leftPanel.setLayout(null);
        rightPanel.setLayout(null);
        
        //create font objects
        
        myFont1 = new Font("TimesRoman",Font.BOLD,30);
        myFont2 = new Font("TimesRoman",Font.BOLD,15);
        myFont3 = new Font("TimesRoman",Font.BOLD,12);
        
        //create border objects
        
        border1 = BorderFactory.createRaisedBevelBorder();
        border2 = BorderFactory.createLoweredBevelBorder();
        
        //apply borders to panels
        
        headerPanel.setBorder(border1);
        rightPanel.setBorder(border1);
        leftPanel.setBorder(border2);
        
        //put the panels on to the frame (and the main panel)
        
        myFrame.add(mainPanel);
        
        mainPanel.add(headerPanel);
        headerPanel.setBounds(20,20,550,50);
        
        leftPanel.setBounds(20,90,275,300);
        mainPanel.add(leftPanel);
        
        rightPanel.setBounds(300,90,275,300);
        mainPanel.add(rightPanel);
        
        //set the label and button objects
        
        header = new JLabel("Commission Calculator");
        salesPrompt = new JLabel("Value of sales");
        result = new JTextArea("");
        commissionInput = new JTextField("0");
        employeeName = new JTextField("John Smith");
        refresh = new JButton("Refresh");
        calculate = new JButton("Calculate commission");
        exit = new JButton("Exit");
        namePrompt = new JLabel("Enter name");
        newFrame = new JButton("Create commission slip");
        result.setEditable(false);
        
        //apply font to header label
        
        header.setFont(myFont1);
        
        //apply font 2 to all buttons
        
        namePrompt.setFont(myFont2);
        calculate.setFont(myFont2);
        refresh.setFont(myFont2);
        exit.setFont(myFont2);
        salesPrompt.setFont(myFont2);
        result.setFont(myFont2);
        newFrame.setFont(myFont2);
        
        //add everything to panels
        
        header.setBounds(110,10, 400,30);
        headerPanel.add(header);
        
        employeeName.setBounds(150,80,100,30);
        salesPrompt.setBounds(30,150,150,30);
        
        leftPanel.add(salesPrompt);
        leftPanel.add(employeeName);
        
        result.setBounds(10,80,250,100);
        rightPanel.add(result);
        
        commissionInput.setBounds(150,150,100,30);
        leftPanel.add(commissionInput);
        
        namePrompt.setBounds(30,80,150,30);
        leftPanel.add(namePrompt);

        //Add the buttons to panels
        
        calculate.setBounds(40,200,200,30);
        leftPanel.add(calculate);
        
        refresh.setBounds(100,400,100,30);
        mainPanel.add(refresh);
        
        exit.setBounds(440,400,100,30);
        mainPanel.add(exit);
        
        newFrame.setBounds(20,200,230,30);
        rightPanel.add(newFrame);
        
        //add event listeners to buttons
        
        calculate.addActionListener(this);
        refresh.addActionListener(this);
        exit.addActionListener(this);
        newFrame.addActionListener(this);
        
        //add borders to each panel
        
        calculate.setBorder(border1);
        exit.setBorder(border1);
        refresh.setBorder(border1);
        
        //set the bounds and make the frame visible
        
        myFrame.setBounds(350,100,600,500);
        myFrame.setVisible(true);
    }
    
    //implement action performed every time a button is clicked.
    
    public void actionPerformed (ActionEvent event)
    {
        
        //create variables for calculations later
        
        String str;
        str = commissionInput.getText();
        int money = Integer.valueOf(str);
        
        
        //create the exit option
        
        if ( event.getSource() == exit)
        {
           
                  int response = JOptionPane.showConfirmDialog(myFrame,"are you sure you want to exit?",
                                                                 "Are you sure?",
                                                                 JOptionPane.YES_NO_OPTION,
                                                                 JOptionPane.QUESTION_MESSAGE);
                  if (response == JOptionPane.YES_OPTION)
                  {
                      System.exit(0);
                  }
              
        }
        
        //reset the textbox button
        
        else if( event.getSource() == refresh)
        {
            commissionInput.setText("0");
            employeeName.setText("John Smith");
            result.setText("");
        }
        
        //create a slip for commission once calculated
        
        else if (event.getSource() == newFrame)
        {
            
            //add a condition for an invalid commission input (if input is less than 0 and no slip created for blank input)
            
            if(money<0)
            {
                result.setText("Enter an amount over 0");
                result.setForeground(Color.RED);
            }
            else if( result.getText().equals("")||result.getText().equals("Enter sales value to get a \ncommission calculation"))
            {
                result.setText("Enter sales value to get a \ncommission calculation");
                result.setForeground(Color.BLACK);
            }
            else
            {
            //create all elements for commission slip
            
            printOut = new JFrame("Your commission slip");
            printPanel = new JPanel();
            printText = new JPanel();
            printLabel = new JLabel();
            printOut.setVisible(true);
            
            //set all panel layouts
            
            printPanel.setLayout(null);
            printText.setLayout(null);
            
            //add all elements to panels
            
            printOut.add(printPanel);
            printPanel.add(printLabel);
            printPanel.add(printText);
            printText.add(printLabel);
            
            //set Bounds on all
            
            printText.setBounds(20,40,600,60);
            printOut.setBounds(350,200,650,200);
            printLabel.setBounds(10,20,600,25);
            
            // font style elements
            
            printLabel.setFont(myFont2);
            printText.setBorder(border2);
            
            //set slip text from the main calculator
            
            String slip = result.getText();
            printLabel.setText(slip);
            printOut.setResizable(false);
            }
        }
        
        //create the calculator
        
        else if (event.getSource() == calculate)
        {
            
            int rate;
            
            // all conditions for the rate
                
            if(money>= 0 && money<=19999)
            {
                rate = 0;
            }
            else if(money>=20000 && money<= 30999)
            {
                rate= 5;
            }
            else if(money>=31000 && money<=45999)
            {
                rate = 10;
            }
            else if(money>=46000 && money<=59999)
            {
                rate = 12;
            }
            else
            {
                rate=15;
            } 
        
            //condition for a negative entry
        
        if (money<0)
            {
                result.setText("Enter an amount over 0");
                result.setForeground(Color.red);
            }
            
            //the full display of the commission earned by the employee including the text color reset if incorrect value entered first
            
            else
            {
            int commission = money*rate/100;
            String name = employeeName.getText();
            result.setForeground(Color.black);
            String total = (name + ", You have \nearned £" + commission + " in commission at \na rate of " + rate + "%.");
            result.setText(total);
        }
      }
    }
}
    
