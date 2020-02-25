/* Author: Robbie Campbell
 * Copyright: Poole College(c)
 * Date: 21/02/2020
 * 
 * Description: This class is used to ensure that a certain blood
 * group is compatable with other blood groups, the user will
 * input a value using a combo box and it will then present 
 * which blood types are compatible in a JLabel
 */
import javax.swing.*; // GUI widget
import java.awt.event.*; // ActionEvent, ActionListener classes
import javax.swing.BorderFactory.*;// Creates raised or lowered borders
import javax.swing.border.*;// Allows for border classes
import java.awt.*;// Color and font classes
public class Blood_Compatability
{
    //C reate all variables in the class
    
    JLabel output, inputPrompt, welcome, compatableTypes;
    JFrame frame;
    JPanel mainPanel, headerPanel, bloodPanel;
    Border lowered;
    Font mainFont, headerFont, outputFont;
    Color Background, Panels, Foreground;
    
    // Creates a function which loops through the different blood types by setting a int in the
    // method.
    private void Blood_Loop(int x)
    {
        
        // The different blood types
        for (int bloods = 0; bloods< x; bloods++)
         {   
             
             // Loops through the array to display the number of bloods specified in the method
             String bloodCompatable[] = {"O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+"};
             String compatable = bloodCompatable[bloods];
             this.output.setText(output.getText() + "  " + compatable);
         }
    }
    public Blood_Compatability()
    {
        
        // Create all of the styling elements for the GUI
        mainFont = new Font("serif", Font.PLAIN, 16);
        headerFont = new Font("serif", Font.BOLD, 26);
        outputFont = new Font("serif", Font.BOLD, 20);
        lowered = BorderFactory.createLoweredBevelBorder();
        Background = new Color(131,3,3);
        Panels = new Color(255,255,255);
        
        // Create the frame and set the layout to null
        frame = new JFrame("Blood compatability");
        frame.setVisible(true);
        frame.setBounds(100,100,600,300);
        frame.setResizable(false);
        
        // Add the main panel to the frame and set the color
        mainPanel = new JPanel();
        frame.add(mainPanel);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Background);
        
        // Create the header panel and the blood panel
        headerPanel = new JPanel();
        bloodPanel = new JPanel();
        headerPanel.setBounds(20,20,540,50);
        bloodPanel.setBounds(20,90,540,150);
        
        // Set the style of the panels
        headerPanel.setBackground(Panels);
        bloodPanel.setBackground(Panels);
        headerPanel.setBorder(lowered);
        bloodPanel.setBorder(lowered);
        bloodPanel.setLayout(null);
        
        // Add the panels to the frame
        mainPanel.add(headerPanel);
        mainPanel.add(bloodPanel);
        
        // Create the welcome label object
        welcome = new JLabel("Compatable blood type checker");
        welcome.setFont(headerFont);
        headerPanel.add(welcome);
        
        // Create the input prompt object
        inputPrompt = new JLabel("Please input the recipient blood type");
        inputPrompt.setFont(mainFont);
        inputPrompt.setBounds(20,20,300,20);
        bloodPanel.add(inputPrompt);
        
        // Create the output title object 
        compatableTypes = new JLabel("Compatable blood types are: ");
        compatableTypes.setBounds(20,70,200,20);
        compatableTypes.setFont(mainFont);
        bloodPanel.add(compatableTypes);
        
        // Create the output label
        output = new JLabel("");
        output.setBounds(20,100,300,20);
        output.setFont(outputFont);
        bloodPanel.add(output);
       
        // Create the JComboBox for user input
        String[] differentBloods = {"O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+"};
        JComboBox bloodTypes= new JComboBox(differentBloods);
        bloodTypes.setBounds(350,20,80,20);
        bloodPanel.add(bloodTypes);
        
        // Create the action listener for the combobox
        bloodTypes.addActionListener(new ActionListener()
        {
            
            //The action listener
            public void actionPerformed(ActionEvent e)
            {
                
                // The current comboBox entry
                String currentEntry = (String)bloodTypes.getSelectedItem();
                
                // O- result
                if (currentEntry.equals("O-"))
                {
                    output.setText("");
                    Blood_Loop(1);
                }
                
                // O+ result
                else if (currentEntry.equals("O+"))
                {
                    output.setText("");
                    Blood_Loop(2);
                }
                
                // A- result 
                else if (currentEntry.equals("A-"))
                {
                    output.setText("  O-  A-");
                }
                
                // A+ result
                else if (currentEntry.equals("A+"))
                {
                    output.setText("");
                    Blood_Loop(4);
                }
                
                // B- result
                else if (currentEntry.equals("B-"))
                {
                    output.setText("  O-  B-");
                }
                
                // B+ result
                else if(currentEntry.equals("B+"))
                {
                    output.setText("  O-  O+  B-  B+");
                }
                // AB- result
                else if (currentEntry.equals("AB-"))
                {
                    output.setText("  O-  A-  B-  AB-");
                }
                
                // AB+ result
                else
                {
                    output.setText("");
                    Blood_Loop(8);
                }
            }
        });
    }
}