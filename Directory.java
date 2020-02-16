/*
 * Author: Robbie Campbell
 *          (c)Poole College
 *          
 * Date: 18/11/2019
 * 
 * Description: The Directory which entends all of the assignment tasks
 */ 
import javax.swing.*; 
import javax.swing.border.*; // Border classes
import java.awt.*; // Font, Color classes
import java.awt.event.*; //ActionEvent, ActionListener classes
import javax.swing.BorderFactory;
public class Directory implements ActionListener
{
    
    //declare attributes
    
    JFrame frame;
    JPanel mainPanel, buttonPanel, headerPanel;
    JButton commission1, commission2, gradeCalculator, exit;
    Border border1;
    JLabel javaProgramming;
    Font myFont1;
    
    Directory()
    {
        
        //create a frame
        
        frame = new JFrame("Directory");
        frame.setBounds(0,0,600,500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        
        //create a font for title
        
        myFont1 = new Font("TimesRoman",Font.BOLD,26);
        
        //create panels
        
        mainPanel = new JPanel();
        buttonPanel = new JPanel();
        headerPanel = new JPanel();
        mainPanel.setLayout(null);
        frame.add(mainPanel);
        
        //create the border for all panels
        
        border1 = BorderFactory.createRaisedBevelBorder();
        
        //style and place panels on frame
        
        headerPanel.setBounds(20,20,550,60);
        buttonPanel.setBounds(20,100,550,300);
        
        buttonPanel.setLayout(null);
        
        headerPanel.setBorder(border1);
        buttonPanel.setBorder(border1);
        
        mainPanel.add(headerPanel);
        mainPanel.add(buttonPanel);
        
        //create and add title for header panel
        
        javaProgramming = new JLabel("Java Programming");
        javaProgramming.setFont(myFont1);
        headerPanel.add(javaProgramming);
        headerPanel.setLayout(null);
        javaProgramming.setBounds(180,0,500,60);
        
        //define all buttons, locate them and add action listeners
        
        commission1 = new JButton("Commission task 1");
        commission2 = new JButton("Commission task 2");
        gradeCalculator = new JButton("Grade Calculator");
        exit = new JButton("Exit");
        
        buttonPanel.add(commission1);
        buttonPanel.add(commission2);
        buttonPanel.add(gradeCalculator);
        buttonPanel.add(exit);
        
        commission1.setBounds(20,20,500,30);
        commission2.setBounds(20,60,500,30);
        gradeCalculator.setBounds(20,100,500,30);
        exit.setBounds(20,260,500,30);
        
        commission1.addActionListener(this);
        commission2.addActionListener(this);
        gradeCalculator.addActionListener(this);
        exit.addActionListener(this);
    }
    public void actionPerformed(ActionEvent event)
    {
        //exit button with choices
        if(event.getSource() == exit)
        {
            int response = JOptionPane.showConfirmDialog(frame,"are you sure you want to exit?",
                                                                 "Are you sure?",
                                                                 JOptionPane.YES_NO_OPTION,
                                                                 JOptionPane.QUESTION_MESSAGE);
                  if (response == JOptionPane.YES_OPTION)
                  {
                      System.exit(0);
                  }
        }
        //commission calculator 1
        else if(event.getSource() == commission1)
        {
            frame.dispose();
            Welcome_screen welcome;
            welcome = new Welcome_screen();
        }
        //commission calculator 2
        else if(event.getSource() == commission2)
        {
            frame.dispose();
            Welcome_screen2 welcome2;
            welcome2 = new Welcome_screen2();
        }
        //grade calculator
        else if(event.getSource() == gradeCalculator)
        {
            frame.dispose();
            welcomeScreen gradeWelcome;
            gradeWelcome = new welcomeScreen();
        }
    }
}
