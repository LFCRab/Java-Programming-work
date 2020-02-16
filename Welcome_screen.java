

/*
 * Author: Robbie Campbell
 *          (c)Poole College
 *          
 * Date: 18/11/2019
 * 
 * Class Description:
 * The welcome screen which extends the commission calculator
 * 
 */
import javax.swing.*; 
import javax.swing.border.*; // Border classes
import java.awt.*; // Font, Color classes
import java.awt.event.*; //ActionEvent, ActionListener classes
import javax.swing.BorderFactory;
public class Welcome_screen implements ActionListener
{
    JFrame welcome;
    JPanel mainPanel, titlePanel, descriptionPanel;
    JButton openCommission;
    JLabel title;
    JTextArea description;
    Border border1, border2;
    Font myFont1, myFont2;
    
    public Welcome_screen()
    {
        
        //set font sizes
        
        myFont1 = new Font("TimesRoman",Font.BOLD,16);
        myFont2 = new Font("TimesRoman",Font.BOLD,14);
        
        //define border elements
        
        border1 = BorderFactory.createRaisedBevelBorder();
        border2 = BorderFactory.createLoweredBevelBorder();
        
        //create welcome objects
        
        welcome = new JFrame("Welcome");
        welcome.setVisible(true);
        welcome.setBounds(500,200,360,400);
        welcome.setLocationRelativeTo(null);
        welcome.setResizable(false);
        
        //create, set layout and set bounds on all panels
        
        mainPanel = new JPanel();
        titlePanel = new JPanel();
        descriptionPanel = new JPanel();
        
        mainPanel.setLayout(null);
        titlePanel.setLayout(null);
        descriptionPanel.setLayout(null);
        
        titlePanel.setBounds(15,40,320,50);
        descriptionPanel.setBounds(15,110,320,120);
        
        titlePanel.setBorder(border1);
        descriptionPanel.setBorder(border1);
        
        //apply panels to frame
        
        welcome.add(mainPanel);
        mainPanel.add(titlePanel);
        mainPanel.add(descriptionPanel);
        
        // create Label objects
        
        title = new JLabel("Welcome to the commission calculator");
        description = new JTextArea("This application will be used to determine \n your current commission owed, press \n enter to calculate, and thankyou for \n your hard work.");
        description.setBorder(null);
        
        //add labels to panels
        
        titlePanel.add(title);
        title.setBounds(10,5,360,35);
        descriptionPanel.add(description);
        description.setBounds(10,5,300,100);
        title.setFont(myFont1);
        description.setFont(myFont2);
        
        //create the button object
        
        openCommission = new JButton("Enter");
        openCommission.setBounds(100,260,160,50);
        mainPanel.add(openCommission);
        openCommission.addActionListener(this);
        
        //apply colors to panels and text
        
        Color darkBlue = new Color(0,0,205);
        Color violet = new Color(106,90,205);
        Color cream = new Color(240,248,255);
        Color lightSky = new Color(135,206,250);
        
        mainPanel.setBackground(darkBlue);
        titlePanel.setBackground(violet);
        descriptionPanel.setBackground(lightSky);
        title.setForeground(cream);
        
    }
    public void actionPerformed (ActionEvent event){
        
        //open up the commission calculator
        
        if (event.getSource() == openCommission)
        {
            welcome.dispose();
            Commission open;
            open = new Commission();
        }
    }
}
