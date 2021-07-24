package blogSite;
import javax.swing.*;

import components.*;
import java.awt.*;
import java.awt.event.*;
import java.security.AlgorithmParameterGenerator;
import java.util.*;

public class LOGINPAGE extends mainFrame {
	public LOGINPAGE(){
		this.setTitle("Login page");
		setMenuBar();//etar aage content body take ready kore nite hobe
		//homepage e jemne content body er bhitre preview box gula die diechi, tarpor setmain body call korechi
		conBody = new JPanel();//conBody is declare in the mainFrame class and added in main body class
		// login box name ekta panel create kore, otar bhitre shob rekhe, otake content body te add kore dilei hobe i guess
//		ekta panel create korbo, suppose login box
//		login box er bhitore thake duita text box, r ekta log in button
		JPanel loginBox = new JPanel(); 
		loginBox.setLayout(new GridLayout(4,1,10,10));
		loginBox.setPreferredSize(new Dimension(300,200));
		loginBox.setBackground(null); 
		JPanel usrPanel= new JPanel();
		JPanel passPanel= new JPanel();
		JLabel l1,l2;  
		JTextField t1,t2; 
	    l1=new JLabel("Username");  
	    l2=new JLabel("Password");  
	    t1=new JTextField(20);   
	    t2=new JTextField(20);  
	    usrPanel.add(l1);
	    usrPanel.add(t1);
	    passPanel.add(l2);
	    passPanel.add(t2);
	    loginBox.add(usrPanel);
	    loginBox.add(passPanel);
	    
	     JButton b1=new BTN("LOGIN"); 
	     b1.setMaximumSize(new Dimension(100,50));       
	     loginBox.add(b1);
	     conBody.add(loginBox);
		 setMainBody();
	}
}

//login page
//sign up page
//search page
//post page
//profile page
//post edit page
//database connection

