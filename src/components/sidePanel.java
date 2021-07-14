package components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import blogSite.sysInfo;

public class sidePanel extends JPanel{
	public sidePanel(String type) {
		//setting its layout to null, so that i can set the elements myself
		this.setLayout(null);
		this.setPreferredSize(new Dimension((int)sysInfo.winWidth/5, sysInfo.winHeight-50));
		if(type=="left") {
			initLeft();
		}
		else {
			initRight();
		}
		
	}
	public void initLeft() {
		this.setLocation(0, 0);
	}
	public void initRight() {
		this.setLocation(((int)sysInfo.winWidth/5)*4, 0);
	}
}
