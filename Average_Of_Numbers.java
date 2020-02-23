/* Author: Robbie Campbell
 * Copyright: Poole College(c)
 * Date: 21/02/2020
 * 
 * Description: This class is to display the average of a list of numbers that a user defines,
 * the user also has the ability to choose how many numbers they wish to enter into the average
 * and no number less than 0 is to be included in the end calculation.
 * 
 */

import java.util.Scanner; // allows user input
public class Average_Of_Numbers
{
    
    //creates this as a global variable to calculate later
    Scanner numbersForAverage;
    
    public Average_Of_Numbers(){

        // Create a Scanner object and prompts user
        System.out.println("Enter an initial number to get an average, enter 0 to stop input: ");
        Scanner howManyNumbers = new Scanner(System.in);  
        // Read user input and converts to an double
        double initialInput = Double.valueOf(howManyNumbers.nextLine());
        
        //Creates a starting value for the total to be established
        double sum = initialInput;
        int start = 0;
        
        //removes negative numbers from the end result
        if (initialInput < 0)
        {
            start -=1;
            sum = 0;
        }
        
        // Creates a do while loop where the number of inputs is incremented indefinitely but
        // breaks the loop as soon as the value 0 has been entered
        do {
            start++;
            
            // Creates the user input   
            numbersForAverage = new Scanner(System.in);
            System.out.println("Please enter a value:");
            
            // Converts user input into a divisible format
            double numbers = Double.valueOf(numbersForAverage.nextLine());
            
            // Breaks the loop on 0 entry
            if (numbers==0.0)
            {
                break;
            }
            
            // Skips any negative number input in the loop
            else if (numbers < 0.0)
            {
                start -=1;
                continue;
            }
            
            //generates the total sum of all inputs
            sum += numbers;
        }while (start < start+1);
        
        // Generates the average of all of the numbers entered. 
        double result = sum / start;
        System.out.println("the average of your positive numbers is: " + result);
        
        // Allow the user to generate another average
        Scanner retry = new Scanner(System.in);
        System.out.println("Would you like to start again? type 'yes' to restart");
        
        String goAgain = String.valueOf(retry.nextLine());
        
        // Restarts the app
        if (goAgain.equals("yes"))
        {
            new Average_Of_Numbers();
        }
        
        //Ends the app
        else
        {
            System.out.println("Thankyou for using this average calculator!");
            return;
        }
    }
}