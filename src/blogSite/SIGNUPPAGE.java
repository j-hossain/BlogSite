package blogSite;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import components.*;
import java.awt.*;
import java.awt.event.*;
import java.security.AlgorithmParameterGenerator;
import java.util.*;
public class SIGNUPPAGE extends mainFrame implements ActionListener{

	JLabel usrNmeLbl,flNmeLbl,emlLbl,passLbl,conPassLbl,warning;  
	JTextField usrNmeInp,flNmeInp,emlInp; 
	JPasswordField passInp,conPassInp;
	DIV warningPanel = new DIV(new BorderLayout());
	JButton sgnUpBtn=new BTN("SIGN UP"); 
	public SIGNUPPAGE(){
		this.setTitle("Signup page");
		setMenuBar();//etar aage content body take ready kore nite hobe
		//homepage e jemne content body er bhitre preview box gula die diechi, tarpor setmain body call korechi
		conBody = new JPanel();//conBody is declare in the mainFrame class and added in main body class
		// login box name ekta panel create kore, otar bhitre shob rekhe, otake content body te add kore dilei hobe i guess
//		ekta panel create korbo, suppose login box
//		login box er bhitore thake duita text box, r ekta log in button
		JPanel sgnUpPanel = new JPanel(); 
		//signUpPanel.setLayout(new GridLayout(4,1,10,10));
		sgnUpPanel.setPreferredSize(new Dimension(350,400));
		sgnUpPanel.setBackground(null); 
		sgnUpPanel.setLayout(new GridLayout(9,1,10,10));
		JPanel usrPanel= new JPanel(new BorderLayout());
		JPanel namePanel= new JPanel(new BorderLayout());
		JPanel emailPanel= new JPanel(new BorderLayout());
		JPanel passPanel= new JPanel(new BorderLayout());
		JPanel cpassPanel= new JPanel(new BorderLayout());
		
		warning = new JLabel();
		warning.setForeground(Color.red);
		warning.setFont(new Font("",Font.ITALIC,10));
	    usrNmeLbl=new JLabel("Username");  
	    flNmeLbl=new JLabel("Full Name");  
	    emlLbl=new JLabel("Email");  
	    passLbl=new JLabel("Password");  
	    conPassLbl=new JLabel("Confirm Password");  
	    usrNmeInp=new JTextField(20);   
	    flNmeInp=new JTextField(20);  
	    emlInp=new JTextField(20);  
	    passInp = new JPasswordField(20);
	    conPassInp = new JPasswordField(20);
	    sgnUpBtn.setMaximumSize(new Dimension(100,50));
	    sgnUpBtn.addActionListener(this);
	    
	    //giving some padding to the textboxes
	    usrNmeInp.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(5,5,5,5)));
	    flNmeInp.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(5,5,5,5)));
	    emlInp.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(5,5,5,5)));
	    passInp.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(5,5,5,5)));
	    conPassInp.setBorder(new CompoundBorder(new EtchedBorder(), new EmptyBorder(5,5,5,5)));
	    
	    usrPanel.add(usrNmeLbl,BorderLayout.WEST);
	    usrPanel.add(usrNmeInp,BorderLayout.EAST);
	    namePanel.add(flNmeLbl,BorderLayout.WEST);
	    namePanel.add(flNmeInp,BorderLayout.EAST);
	    emailPanel.add(emlLbl,BorderLayout.WEST);
	    emailPanel.add(emlInp,BorderLayout.EAST);
	    passPanel.add(passLbl,BorderLayout.WEST);
	    passPanel.add(passInp,BorderLayout.EAST);
	    cpassPanel.add(conPassLbl,BorderLayout.WEST);
	    cpassPanel.add(conPassInp,BorderLayout.EAST);
	    //adding dummy rows
	    sgnUpPanel.add(new DIV(new BorderLayout()));
	    sgnUpPanel.add(new DIV(new BorderLayout()));
	    sgnUpPanel.add(usrPanel);
	    sgnUpPanel.add(namePanel);
	    sgnUpPanel.add(emailPanel);
	    sgnUpPanel.add(passPanel);
	    sgnUpPanel.add(cpassPanel);
	    sgnUpPanel.add(warningPanel);
	    sgnUpPanel.add(sgnUpBtn);
	    
	    conBody.add(sgnUpPanel);
		setMainBody();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==sgnUpBtn) {
			String userName,fullname,email,pass,conPass;
			userName= usrNmeInp.getText();
			fullname = flNmeInp.getText();
			email = emlInp.getText();
			pass = new String(passInp.getPassword()) ;
			conPass = new String(conPassInp.getPassword()) ;
			if(sysInfo.dt.getCount("user_table WHERE username ='"+userName+"'")==0) {
				if(pass.equalsIgnoreCase(conPass)) {
					if(createAccount(userName,fullname,email,pass)) {
						this.setVisible(false);
						sysInfo.logged=true;
						sysInfo.userName = userName;
						new HOMEPAGE().setVisible(true);
					}
					else {
						showWarning("Account creation unsuccessfull");
					}
				}
				else {
					showWarning("Passwords dont match");
				}
			}
			else {
				showWarning("This username already exists");
			}
		}
	}
	public void showWarning(String msg) {
		warningPanel.setVisible(false);
		warning.setText(msg);
		warningPanel.add(warning);
		warningPanel.setVisible(true);
	}
	public boolean createAccount(String userName, String fullname, String email, String Pass) {
		return sysInfo.dt.sendData("INSERT INTO user_table VALUES(null,'"+userName+"','"+fullname+"','"+email+"','"+Pass+"')");
	}
}
