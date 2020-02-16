
/*
 * Author: Robbie Campbell
 *          (c)Poole College
 *          
 * Date: 18/11/2019
 * 
 * Class Description:
 * This class will calculate commission owed to the sales person, it is based on a figure
 * entered by the user and the type of car the user has sold determines the rate, the user will
 * find the amount of commission owed and the rate of which it was calculated.
 * 
 * Rules
 *      The car type is ABC-A the rate is 5%
 *      The car type is ABC-B the rate is 10%
        The car type is ABC-C the rate is 12%
        The car type is ABC-D the rate is 15%
        The car type is ABC-E the rate is 17%
 * 
 */

import javax.swing.*; 
import javax.swing.border.*; // Border classes
import java.awt.*; // Font, Color classes
import java.awt.event.*; //ActionEvent, ActionListener classes
import javax.swing.BorderFactory;

   public class Commission2 implements ActionListener
   {
       
       //declare all variables globally
       
    JFrame myFrame, printOut;
    JPanel mainPanel, headerPanel, leftPanel, rightPanel, printPanel, printText;;
    JButton calculate, refresh, exit, newFrame;
    JTextField employeeName, salesNumber;
    JLabel salesPrompt, header, namePrompt, printLabel, carCat;
    Font myFont1, myFont2, myFont3;
    Border border1, border2;
    JTextArea result;
    JComboBox carCode;
    public Commission2()
    {
        //make the frame and make size a constant
        
        myFrame = new JFrame("Sales Commission Calculator");
        myFrame.setResizable(false);
        
        //create Panel objects
        
        mainPanel = new JPanel();
        headerPanel = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        
        //set panel layouts
        
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
        
        //create car codes using a loop
        
        carCode = new JComboBox();
        for (char carType = 'A';carType <= 'E'; carType++)
        {
            carCode.addItem("ABC-" + carType);
        }
        
        leftPanel.add(carCode);
        carCode.setBounds(150,30,100,30);
        carCat = new JLabel("Car Type");
        leftPanel.add(carCat);
        carCat.setBounds(30,30,80,30);
        carCat.setFont(myFont2);
        
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
        salesPrompt = new JLabel("Value of car");
        namePrompt = new JLabel("Enter name");
        
        result = new JTextArea("");
        
        salesNumber = new JTextField("0");
        employeeName = new JTextField("John Smith");
        
        refresh = new JButton("Refresh");
        calculate = new JButton("Calculate commission");
        exit = new JButton("Exit");
        newFrame = new JButton("Create commission slip");
        
        result.setEditable(false);
        
        //apply font to header label
        
        header.setFont(myFont1);
        
        //apply font 2 to labels and buttons
        
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
        
        employeeName.setBounds(150,90,100,30);
        leftPanel.add(employeeName);
        
        salesPrompt.setBounds(30,150,150,30);
        leftPanel.add(salesPrompt);
        
        result.setBounds(10,80,250,100);
        rightPanel.add(result);
        
        salesNumber.setBounds(150,150,100,30);
        leftPanel.add(salesNumber);
        
        namePrompt.setBounds(30,90,150,30);
        leftPanel.add(namePrompt);

        //Add the buttons
        
        calculate.setBounds(40,200,200,30);
        leftPanel.add(calculate);
        
        refresh.setBounds(100,400,100,30);
        mainPanel.add(refresh);
        
        exit.setBounds(440,400,100,30);
        mainPanel.add(exit);
        
        newFrame.setBounds(20,200,230,30);
        rightPanel.add(newFrame);
        
        //add event listeners to all buttons
        
        calculate.addActionListener(this);
        refresh.addActionListener(this);
        exit.addActionListener(this);
        newFrame.addActionListener(this);
        
        //add borders to style the panels
        
        calculate.setBorder(border1);
        exit.setBorder(border1);
        refresh.setBorder(border1);
        
        //set the bounds and make it visible
        
        myFrame.setBounds(350,100,600,500);
        myFrame.setVisible(true);
    }
    
    //implement action performed every time a button is clicked.
    
    public void actionPerformed (ActionEvent event)
    {
        
        //create variables for calculations later
        
            String str;
            str = salesNumber.getText();
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
            salesNumber.setText("0");
            employeeName.setText("John Smith");
            result.setText("");
        }
        
        //create a slip for commission once calculated
        
        else if (event.getSource() == newFrame)
        {
        
            //add conditions for an invalid commission input (if input is less than 0 or blank input in the textarea)
            
            if(money<0)
            {
                result.setText("Enter an amount over 0");
                result.setForeground(Color.RED);
            }
            else if(result.getText().equals("")||result.getText().equals("Enter sales value to get a \ncommission calculation"))
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
            
            //create variables  to calculate commission
            
            int rate;
            String carType = (String)carCode.getSelectedItem();
            
            // all conditions for the rate
            
            if(carType.equals("ABC-A"))
            {
                rate=5;
            }
            else if(carType.equals("ABC-B"))
            {
                rate = 10;
            }
            else if(carType.equals("ABC-C"))
            {
                rate = 12;
            }
            else if(carType.equals("ABC-D"))
            {
                rate = 15;
            }
            else
            {
                rate=17;
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
            String total = (name + ", You have earned \n£" + commission + 
            " in commission at a rate \nof " + rate + "%.");
            result.setText(total);
        }
      }
    }
        
   }
    
