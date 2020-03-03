/* Author: Robbie Campbell
 * Copyright: Poole College(c)
 * Date: 21/02/2020
 * 
 * Description: This class is to display the average of a list of numbers that a user defines,
 * the user also has the ability to choose how many numbers they wish to enter into the average
 * and no number less than 0 is to be included in the end calculation.
 * 
 */

import javax.swing.*; // gui stuff
import java.awt.event.*; // ActionEvent, ActionListener classes
public class Average_Of_Numbers implements KeyListener, ActionListener
{
    
        JFrame myFrame;
        JPanel mainPanel;
        JTextArea numberStore;
        JLabel inputPrompt, theAverage;
        JTextField enter;
        JButton inputNumber, exit,refresh;
        // 2 values for incrementing in the event listener
        int count;
        double sum;
        
        // A function to be called when either the action listener
        // Or the key listener is activated.
    public void averageFunction()
    {
               
             // Get the current value in the text area, convert them into string values
             // then add them into the text area.
             String numbers =  enter.getText();
             double Numbers = Double.valueOf(numbers);
             numberStore.append(numbers + "\n");
                    
             // Keep a record of the total of all numbers input so far
             sum += Numbers;
                    
                    // Reveals the average of all of the numbers.
                if (Numbers==0.0)
                {
                    inputNumber.setEnabled(false);
                    double result = sum / Double.valueOf(count);
                    theAverage.setText("The average of the numbers entered is: " + String.valueOf(result));
                }
                    
                    // Skips any negative number input
                else if (Numbers < 0.0)
                {
                    count -=1;
                    sum -= Numbers;
                }  
                
             // Increments the number of inputs
             count++;
             
             // Resets the text field for ease of use.
             enter.setText("");
    }
    public Average_Of_Numbers(){
        
        // Initialise the Frame and main Panel
        myFrame = new JFrame("Average calculator");
        mainPanel = new JPanel();
        myFrame.add(mainPanel);
        mainPanel.setLayout(null);
        
        // Prompt the user for input
        inputPrompt = new JLabel("Please enter numbers to establish an average: ");
        inputPrompt.setBounds(50,50,300,30);
        mainPanel.add(inputPrompt);
        
        // User input field
        enter = new JTextField("");
        enter.setBounds(350,50,100,30);
        mainPanel.add(enter);
        
        // Adds a listener for the user to press enter.
        enter.addKeyListener(this);
        
        // Stores the numbers which have been input thus far.
        numberStore = new JTextArea("Please enter 0 to find the average: \n");
        numberStore.setBounds(50,100,300,200);
        numberStore.setEditable(false);
        mainPanel.add(numberStore);
        
        // The average output label
        theAverage = new JLabel("");
        theAverage.setBounds(50,400,400,30);
        mainPanel.add(theAverage);
        
        // Stores the number in the text area.
        inputNumber = new JButton("Lock In A Number");
        inputNumber.setBounds(50,350,180,30);
        inputNumber.addActionListener(this);
        mainPanel.add(inputNumber);
        
        // Create the exit button
        exit = new JButton("Exit");
        exit.setBounds(250,350,80,30);
        exit.addActionListener(this);
        mainPanel.add(exit);
        
        // Refresh the panel to start again
        refresh = new JButton("Refresh");
        refresh.setBounds(360,350,80,30);
        refresh.addActionListener(this);
        mainPanel.add(refresh);
        
        
        // Make the frame visible
        myFrame.setVisible(true);
        myFrame.setBounds(20,20,500,500);
    }
    
    // Executes the averagefunction() on pressing the enter
    // key.
    @Override
    public void keyTyped(KeyEvent ke) {
        int key = ke.getKeyCode();
        if (key == KeyEvent.VK_ENTER)
        {
            averageFunction();
            
        }
    }
 
    @Override
    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        if (key == KeyEvent.VK_ENTER)
        {
            averageFunction();
        }
    }
    
    // Does nothing as it would duplicate results
    @Override
    public void keyReleased(KeyEvent ke) {
        //none
    }
    public void actionPerformed(ActionEvent event){
                
            if (event.getSource() == inputNumber){
                averageFunction();
            }
            
            // Exit the application
            else if(event.getSource() == exit)
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
        
            // Refresh the application to work out another average
            else if(event.getSource() == refresh)
            {
                numberStore.setText("Please enter 0 to find the average: \n");
                sum = 0;
                count = 0;
                inputNumber.setEnabled(true);
                theAverage.setText("");
            }
        }        
}
