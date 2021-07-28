package blogSite;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicBorders;

import components.*;

import java.awt.*;
import java.awt.event.*;
import java.security.AlgorithmParameterGenerator;
import java.util.*;

public class LOGINPAGE extends mainFrame implements ActionListener{

	JPanel usrPanel= new JPanel(new BorderLayout());
	JPanel passPanel= new JPanel(new BorderLayout());
	JLabel usrNmeLbl,passLbl,warning;  
	JTextField usrNmeInp;
	JPasswordField passInp; 
	JButton sgnInBtn=new BTN("SIGN IN");
	DIV warningPanel = new DIV(new BorderLayout());
	public LOGINPAGE(){
		this.setTitle("Login page");
		setMenuBar();//etar aage content body take ready kore nite hobe
		//homepage e jemne content body er bhitre preview box gula die diechi, tarpor setmain body call korechi
		conBody = new JPanel();//conBody is declare in the mainFrame class and added in main body class
		// login box name ekta panel create kore, otar bhitre shob rekhe, otake content body te add kore dilei hobe i guess
//		ekta panel create korbo, suppose login box
//		login box er bhitore thake duita text box, r ekta log in button
		JPanel sgnInBox = new JPanel(); 
		sgnInBox.setLayout(new GridLayout(7,1,10,10));
		sgnInBox.setPreferredSize(new Dimension(300,280));
		sgnInBox.setBackground(null); 
		
		
		warning = new JLabel();
		warning.setForeground(Color.red);
		warning.setFont(new Font("",Font.ITALIC,10));
	    usrNmeLbl=new JLabel("Username");
	    passLbl=new JLabel("Password");  
	    usrNmeInp=new JTextField(20);   
	    passInp=new JPasswordField(20);  
	    usrNmeInp.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(5,5,5,5)));
	    passInp.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(5,5,5,5)));
	    usrPanel.add(usrNmeLbl,BorderLayout.WEST);
	    usrPanel.add(usrNmeInp,BorderLayout.EAST);
	    passPanel.add(passLbl,BorderLayout.WEST);
	    passPanel.add(passInp,BorderLayout.EAST);
	    sgnInBtn.setMaximumSize(new Dimension(100,50)); 
	    sgnInBtn.addActionListener(this);
	    //three dummy rows to bring it to the center, they are empty
	    sgnInBox.add(new DIV(new BorderLayout()));
	    sgnInBox.add(new DIV(new BorderLayout()));
	    sgnInBox.add(new DIV(new BorderLayout()));
	    sgnInBox.add(usrPanel);
	    sgnInBox.add(passPanel);
	    //one dummy row to make spac
	    sgnInBox.add(warningPanel);
	    sgnInBox.add(sgnInBtn);
	    
	    conBody.add(sgnInBox);
		setMainBody();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==sgnInBtn) {
			String usrName = usrNmeInp.getText();
			String pass = passInp.getText();
			if(sysInfo.dt.getCount("user_table WHERE username ='"+usrName+"' AND password='"+pass+"'")==1) {
				getSignedIn(usrName);
			}
			else {
				System.out.println(pass);
				showWarning("Wrong password or Username");
			}
		}
	}
	
	public void getSignedIn(String usrName) {
		this.setVisible(false);
		sysInfo.logged = true;
		sysInfo.userName = usrName;
		new HOMEPAGE().setVisible(true);
	}
	public void showWarning(String msg) {
		warningPanel.setVisible(false);
		warning.setText(msg);
		warningPanel.add(warning);
		warningPanel.setVisible(true);
	}
}

//login page
//sign up page
//search page
//post page
//profile page
//post edit page
//database connection

