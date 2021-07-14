package components;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import blogSite.*;
//this class defines the properties of all mainframes that are created on any instances of the application
public class mainFrame extends JFrame{
	public mainBody mBody;//panel that contains the side panels and also the content panel in the middle
	public JPanel conBody;//panel that contains the main contents of the current page
	public mainFrame() {
		//specifying the width and height
		this.setSize(new Dimension(sysInfo.winWidth,sysInfo.winHeight));
		//taking it to the middle
		this.setLocationRelativeTo(null);
		//the look of the application will break down if resized, thats why its disabled
		this.setResizable(false);
		//setting the close operation
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}
	
	public void setMenuBar() {
		//adding the menuPanel here
		JPanel menu = new menubar();
		this.add(menu,BorderLayout.NORTH);
	}
	
	public void setMainBody() {
		//adding a mainBody
		mBody = new mainBody(conBody);
		this.add(mBody);
	}
}