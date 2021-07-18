package blogSite;
import javax.swing.*;

import components.*;
import java.awt.*;
import java.awt.event.*;
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

