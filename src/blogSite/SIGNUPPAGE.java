package blogSite;
import javax.swing.*;
import components.*;
import java.awt.*;
import java.awt.event.*;
import java.security.AlgorithmParameterGenerator;
import java.util.*;
public class SIGNUPPAGE extends mainFrame{

	public SIGNUPPAGE(){
		this.setTitle("Signup page");
		setMenuBar();//etar aage content body take ready kore nite hobe
		//homepage e jemne content body er bhitre preview box gula die diechi, tarpor setmain body call korechi
		conBody = new JPanel();//conBody is declare in the mainFrame class and added in main body class
		// login box name ekta panel create kore, otar bhitre shob rekhe, otake content body te add kore dilei hobe i guess
//		ekta panel create korbo, suppose login box
//		login box er bhitore thake duita text box, r ekta log in button
		JPanel signUpPanel = new JPanel(); 
		//signUpPanel.setLayout(new GridLayout(4,1,10,10));
		signUpPanel.setPreferredSize(new Dimension(350,400));
		signUpPanel.setBackground(null); 
		signUpPanel.setLayout(new GridLayout(9,1,10,10));
		JPanel usrPanel= new JPanel(new BorderLayout());
		JPanel namePanel= new JPanel(new BorderLayout());
		JPanel emailPanel= new JPanel(new BorderLayout());
		JPanel passPanel= new JPanel(new BorderLayout());
		JPanel cpassPanel= new JPanel(new BorderLayout());
		
		JLabel l1,l2,l3,l4,l5;  
		JTextField t1,t2,t3; 
		JPasswordField p1,p2;
	    l1=new JLabel("Username");  
	    l2=new JLabel("Full Name");  
	    l3=new JLabel("Email");  
	    l4=new JLabel("Password");  
	    l5=new JLabel("Confirm Password");  
	    t1=new JTextField(20);   
	    t2=new JTextField(20);  
	    t3=new JTextField(20);  
	    p1 = new JPasswordField(20);
	    p2 = new JPasswordField(20);
	    JButton b1=new BTN("SIGN UP"); 
	    b1.setMaximumSize(new Dimension(100,50));
	    
	    usrPanel.add(l1,BorderLayout.WEST);
	    usrPanel.add(t1,BorderLayout.EAST);
	    namePanel.add(l2,BorderLayout.WEST);
	    namePanel.add(t2,BorderLayout.EAST);
	    emailPanel.add(l3,BorderLayout.WEST);
	    emailPanel.add(t3,BorderLayout.EAST);
	    passPanel.add(l4,BorderLayout.WEST);
	    passPanel.add(p1,BorderLayout.EAST);
	    cpassPanel.add(l5,BorderLayout.WEST);
	    cpassPanel.add(p2,BorderLayout.EAST);
	    //adding dummy rows
	    signUpPanel.add(new DIV(new BorderLayout()));
	    signUpPanel.add(new DIV(new BorderLayout()));
	    signUpPanel.add(usrPanel);
	    signUpPanel.add(namePanel);
	    signUpPanel.add(emailPanel);
	    signUpPanel.add(passPanel);
	    signUpPanel.add(cpassPanel);
	    signUpPanel.add(new DIV(new BorderLayout()));
	    signUpPanel.add(b1);
	    
	    conBody.add(signUpPanel);
		setMainBody();
	}
}
