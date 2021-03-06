package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import blogSite.*;

//here we will add the basic features and look of the menu bar

public class menubar extends JPanel implements ActionListener {
//	emne declare korsi, jate ei class er jekono method theke egula access kora jay
	JPanel accountBtns;
	JButton sgnInBtn;
	JButton sgnUpBtn;
	JButton profileBtn;
	JButton sgnOutBtn;
	JButton homeBtn;
	JButton srchBtn;
	public JTextField srchTxt;
	public menubar(){
		this.setLayout(new BorderLayout(0,0));
		this.setBackground(sysInfo.darkCol);
		
		//sign in, sign out button panel
		accountBtns = new DIV(new FlowLayout(FlowLayout.CENTER,20,15));
		accountBtns.setPreferredSize(new Dimension(sysInfo.winWidth/5,50));
		sgnInBtn = new BTN("Sign in");
		sgnUpBtn = new BTN("Sign up");
		profileBtn = new BTN("Profile");
		sgnOutBtn = new BTN("Sign out");
		loadAccountBtns();
//		accountBtns.setBackground(Color.red);
		//adding the whole panel to the menu panel, to the east (right)
		this.add(accountBtns,BorderLayout.EAST);
		
		//home buttons panel
		JPanel hPan = new DIV(new FlowLayout(FlowLayout.LEFT,20,15));
		hPan.setPreferredSize(new Dimension(sysInfo.winWidth/5,50));
		homeBtn = new BTN("HOME");
		hPan.add(homeBtn);
		this.add(hPan,BorderLayout.WEST);
		
		//search box panel
		JPanel sPanel = new DIV(new FlowLayout(FlowLayout.CENTER,10,15));
		sPanel.setPreferredSize(new Dimension(sysInfo.winWidth/5*3,50));
		srchTxt = new JTextField(12);
		srchTxt.setBorder(null);
		srchTxt.setBorder(new EmptyBorder(4,4,4,4));
		srchBtn = new BTN("Search");
		sPanel.add(srchTxt);
		sPanel.add(srchBtn);
		this.add(sPanel,BorderLayout.CENTER);
		
		//now making the buttons works
		homeBtn.addActionListener(this);
		srchBtn.addActionListener(this);
		sgnInBtn.addActionListener(this);
		sgnUpBtn.addActionListener(this);
		profileBtn.addActionListener(this);
		sgnOutBtn.addActionListener(this);
	}
	
	//dynamic method dispatch is applied here
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==homeBtn) {
			loadHomePage();
		}
		else if(e.getSource()==srchBtn) {
			doSearch();
		}
		else if(e.getSource()==sgnInBtn) {
			loadSignInPage();
		}
		else if(e.getSource()==sgnUpBtn) {
			loadSignUpPage();
		}
		else if(e.getSource()==profileBtn) {
			loadProfilePage();
		}
		else if(e.getSource()==sgnOutBtn) {
			doSignOut();
		}
	}
	
	//home button e click korle ei method call hobe
	private void loadHomePage() {
		// getting the current active window
		Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
		activeWindow.setVisible(false);
		new HOMEPAGE().setVisible(true);
	}
	
	//search button e click korle ei method call hobe
	private void doSearch() {
		String keyWord = srchTxt.getText();
		if(keyWord.length()==0)
			return;
		//to be implemented later
		Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
		activeWindow.setVisible(false);
		new SEARCHPAGE(keyWord).setVisible(true);
	}
	
	//when clicked the sign in button
	private void loadSignInPage() {
		// getting the current active window
		Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
		activeWindow.setVisible(false);
		new LOGINPAGE().setVisible(true);
//		sysInfo.logged = true;
	}
	
//	when clicked the sign up button
	private void loadSignUpPage() {
//		// getting the current active window
		Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
		activeWindow.setVisible(false);
		new SIGNUPPAGE().setVisible(true);
	}
	
	
	private void loadProfilePage() {
		// getting the current active window
		Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
		activeWindow.setVisible(false);
		new PROFILEPAGE(sysInfo.userName).setVisible(true);
	}
	
	
	public void doSignOut() {
		// getting the current active window
		Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
		activeWindow.setVisible(false);
		sysInfo.logged= false;
		loadAccountBtns();
		new HOMEPAGE().setVisible(true);
	}
	
	//this checks which account buttons should be displayed according to the logged state
	public  void loadAccountBtns() {
		if(sysInfo.logged) {
			accountBtns.removeAll();
			accountBtns.add(profileBtn);
			accountBtns.add(sgnOutBtn);
		}
		else {
			accountBtns.removeAll();
			accountBtns.add(sgnInBtn);
			accountBtns.add(sgnUpBtn);
		}
		//ei duita na dile auto refresh hoy na
		//ei duita comment korlei bujha jay kan dite hobe ei line
		accountBtns.setVisible(false);
		accountBtns.setVisible(true);
	}
	
}
