/*
 * 
 * Author: Robbie Campbell
 *          (c)Poole College
 *          
 * Date: 16/12/2019
 * 
 * Class description
 * This class is used to work out the correct grade for a student and display
 * what grade they have earned, this is based on both the assignment marks and the 
 * examination marks to establish a total grade
 * 
 * Rules
 *        If the student has earned less than 15 marks in either assignment it is a failing grade
 *        If the student has earned less than 40 marks it is a failing grade
 *        If the student earns 39 marks it is moderated up to a C grade
 *        If the student earns between 40 and 50 marks total it is a C grade
 *        If the student earns between 50 and 60 marks total it is a B grade
 *        If the student earns between 60 and 70 marks total it is a B+ grade
 *        If the student earns above 70 marks total it is a A grade
 */
import javax.swing.*; 
import javax.swing.border.*; // Border classes
import java.awt.*; // Font, Color classes
import java.awt.event.*; //ActionEvent, ActionListener classes
import javax.swing.BorderFactory;
public class gradeCalculator implements ActionListener
{
    
    //define all variables globally
    
    JFrame myFrame;
    JPanel mainPanel, headerPanel, gradePanel;
    JLabel header, writtenExamination, coursework, result;
    JComboBox written, coursew;
    JButton calculate, exit;
    Font myFont1, myFont2;
    Border border1;
    public gradeCalculator()
    {

     //create style elements for later use
     
     myFont1 = new Font("Serif",Font.BOLD,20);
     myFont2 = new Font("Serif",Font.BOLD,16);
     border1 = BorderFactory.createRaisedBevelBorder();
     
     //create frame with bevel border
     
     myFrame = new JFrame("Grade calculator");
     mainPanel = new JPanel();
     myFrame.add(mainPanel);
     mainPanel.setBorder(border1); 
     myFrame.setVisible(true);
     myFrame.setBounds(700,400,500,400);
     myFrame.setLocationRelativeTo(null);
     mainPanel.setLayout(null);
     myFrame.setResizable(false);
     
     //add and create other panels and add borders
     
     headerPanel = new JPanel();
     gradePanel = new JPanel();
     headerPanel.setBounds(50,30,400,40);
     mainPanel.add(headerPanel);
     headerPanel.setBorder(border1);
     gradePanel.setBounds(67,110,370,130);
     gradePanel.setBorder(border1);
     mainPanel.add(gradePanel);
     gradePanel.setLayout(null);
     
     //create all label objects and add to panels
     
     header = new JLabel("Grade Calculator");
     headerPanel.add(header);
     header.setFont(myFont1);
     
     writtenExamination = new JLabel("Written examination result");
     gradePanel.add(writtenExamination);
     writtenExamination.setFont(myFont2);
     writtenExamination.setBounds(20,10,200,35);
     
     coursework = new JLabel ("Coursework result");
     coursework.setFont(myFont2);
     coursework.setBounds(20,50,150,35);
     gradePanel.add(coursework);
     
     result = new JLabel("");
     result.setFont(myFont2);
     gradePanel.add(result);
     result.setBounds(20,90,350,35);
     
     
     //create the comboboxes and add them to the panel using a for loop
     
     written = new JComboBox();
     coursew = new JComboBox();
     
     for (int score = 0; score<=50; score++)
     {
        written.addItem(score);
        coursew.addItem(score);
     }
     
     gradePanel.add(written);
     gradePanel.add(coursew);
     
     written.setBounds(250,20,100,20);
     coursew.setBounds(250,60,100,20);
     
     //create the calculate and exit buttons and position them
     
     calculate = new JButton("Calculate grade");
     exit = new JButton("Exit");
     mainPanel.add(calculate);
     mainPanel.add(exit);
     calculate.setBounds(90,270,150,35);
     exit.setBounds(300,270,100,35);
     
     //add action listeners to both buttons
     
     calculate.addActionListener(this);
     exit.addActionListener(this);
    }
    public void actionPerformed(ActionEvent event)
    {
        
        //the exit condition
        
        if(event.getSource() == exit)
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
        
        // The calculation condition
        
        else if (event.getSource() == calculate)
        {
            int course = (int)coursew.getSelectedItem();
            int write = (int)written.getSelectedItem();
            int totalGrade = write+course;
            String grade = "";
            
            //for a c grade (including moderation from 39 marks so long as the previous
            //condition has been met)
            
            if (totalGrade >= 39 && totalGrade <=49)
            {
                grade = "a C";
            }
            
            //for a B grade
            
            else if (totalGrade >= 50 && totalGrade <=59)
            {
                grade = "a B";
            }
            
            //for a B+ grade
            
            else if (totalGrade >= 60 && totalGrade <=69)
            {
                grade = "a B+";
            }
            
            //for an A grade
            
            else
            {
                grade = "an A";
            }
            result.setText("Congratulations, you achieved " + grade + " grade.");
            
            //for a failed grade
            
            if(course<15 || write<15 || totalGrade<39)
            {
                result.setText("You were unable to achieve a passing grade");
            }
            
        }
    }
    
}
