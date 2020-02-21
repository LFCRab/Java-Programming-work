/* Author: Robbie Campbell
 * Copyright: Poole College(c)
 * Date: 21/02/2020
 * 
 * Description: This class uses loops to display 5 potential functions to the user,
 * this class uses user String input to present the with a result;
 * 1. All odd integers between 1 and 29 -- user input "Even"
 * 2. The squares of even integers of between 2 and 20 -- user input "Odd"
 * 3. The Sum of all of the squares of odd integers between 1 and 13 -- user input "squares"
 * 4/5. the full alphabet in lower or upper case -- user input "alpha" or "ALPHA"
 */
import javax.swing.*;
import java.awt.*; // Font, Color classes
import javax.swing.border.*; // Border classes
import java.awt.event.*; //ActionEvent, ActionListener classes
public class Loop_Tests implements ActionListener{
     JFrame frame;
     JPanel mainPanel, contentPanel, typeOfLoop;
     JTextArea description;
     JTextField userInput;
     JLabel loopOutput, inputPrompt;
     Border border;
     JButton enterLoopType;
     Font font;
     // a function to output all odd numbers
     private void Odd()
     {
         for (int odd = 1; odd<=29; odd+=2)
         {
             this.loopOutput.setText(loopOutput.getText() + " "+ odd);
         }
     }
     
     // a function to output the squares of of all the even numbers under 20
     private void Even()
     {
         for (int even = 2; even<=20; even+=2)
         {
             int squares = even * even;
             this.loopOutput.setText(loopOutput.getText() + " "+ squares);
         }
     }
     
     // a function to output the sum of all of the square numbers up to 13
     private void Squares()
     {
         int total = 0, squares = 13;
         for (int square = 0; square<=squares; ++square)
         {
             int list_of_squares = square * square;
             total += list_of_squares;
         }
         this.loopOutput.setText(loopOutput.getText() + total);
     }
     
     // a function to output the lower case alphabet
     private void alpha()
     {
         for (char a ='a';a <= 'z'; a++)
         {
             this.loopOutput.setText(loopOutput.getText() + " "+ a);
         }
     }
     
     // a function to output the upper case alphabet
     private void ALPHA()
     {
         for (char a ='A';a <= 'Z'; a++)
         {
             this.loopOutput.setText(loopOutput.getText() + " "+ a);
         }
     }
     
     // call the main function
     public Loop_Tests()
     {
         
         
         // create font object
         font = new Font("serif", font.BOLD, 15); 
         
         // create the frame object
         frame = new JFrame("Loop tester");
         frame.setVisible(true);
         frame.setBounds(200,200,600,600);
         frame.setResizable(false);
         
         //create the main panel and add it to the frame
         mainPanel = new JPanel();
         mainPanel.setLayout(null);
         frame.add(mainPanel);
         
         //create other panel to go onto the main panel and it's bevel border
         border = BorderFactory.createRaisedBevelBorder();
         contentPanel = new JPanel();
         mainPanel.add(contentPanel);
         contentPanel.setBorder(border);
         contentPanel.setBounds(20,20,540,200);
      
         
         // create the text area to describe the various outputs of this application
         
         description = new JTextArea("Welcome to the looper class! This class specialises in different types of loops! \nEnter one of these words to get a result! \n'Even' will list the squares of all even numbers up to 20.\n'Odd' will list all of the odd numbers up to 29.\n'Square' will list the sum of square number up to 13. \n'alpha' will print out the entire lower case alphabet. \n'ALPHA' will print the entire upper case alphabet.\n\n Thankyou for using the Loop_Tests Class!");
         description.setFont(font);
         contentPanel.add(description);
         
         //create the panel to hold the button and the type of loop to be displayed.
         typeOfLoop = new JPanel();
         typeOfLoop.setLayout(null);
         typeOfLoop.setBounds(20,250,540,300);
         typeOfLoop.setBorder(border);
         mainPanel.add(typeOfLoop);
         
         //create the button and the text field abjocts
         enterLoopType = new JButton("enter loop required");
         enterLoopType.setBounds(190,200,150,30);
         typeOfLoop.add(enterLoopType);
         enterLoopType.addActionListener(this);
         
         userInput = new JTextField("Even");
         userInput.setBounds(300,50,100,30);
         typeOfLoop.add(userInput);
         
         //create the prompt and the label for loop output
         inputPrompt = new JLabel("Please enter one of the values");
         inputPrompt.setBounds(50,50,180,30);
         typeOfLoop.add(inputPrompt);
         
         loopOutput = new JLabel("");
         loopOutput.setFont(font);
         loopOutput.setBounds(100,120,450,50);
         typeOfLoop.add(loopOutput);
     }
    public void actionPerformed (ActionEvent event)
    {
        
        
        // Tells the app to check the value in the textfield
        if (event.getSource() == enterLoopType)
        {
            
            //creates a variable for the textfield data
            String loopType = userInput.getText();
            
                // Executes the Even() function
                if (loopType.equals("Even"))
                {
                    loopOutput.setText("");
                    Even();
                }
                
                
                // Executes the Odd() function
                else if(loopType.equals("Odd"))
                {
                    loopOutput.setText("");
                    Odd();
                }
                
                // Executes the Squares() function
                else if(loopType.equals("Square"))
                {
                    loopOutput.setText("");
                    Squares();
                }
                
                // Executes the alpha() function
                else if(loopType.equals("alpha"))
                {
                    loopOutput.setText("");
                    alpha();
                }
                
                // Executes the ALPHA() function
                else if(loopType.equals("ALPHA"))
                {
                    loopOutput.setText("");
                    ALPHA();
                }
                
                // IF one of the inputs is not selected 
                else
                {
                    loopOutput.setText("Please enter one of the values");
                }
        }
    }
}