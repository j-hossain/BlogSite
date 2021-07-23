package components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import blogSite.sysInfo;

public class sidePanel extends JPanel{
	public sidePanel(String type) {
		//setting its layout to null, so that i can set the elements myself
		this.setLayout(null);
		//size same thakbe left houk ba rigth
//		this.setBackground(Color.cyan);
		this.setPreferredSize(new Dimension((int)sysInfo.winWidth/5, sysInfo.winHeight-50));
		//in case jodi dui side er panel e dui type er jinish add kori, tokhon kar jonno emne condition die rakha
		if(type=="left") {
			initLeft();
		}
		else {
			initRight();
		}
		
	}
	public void initLeft() {
//		ekdom baam er location
//		this.setLocation(0, 0);
	}
	public void initRight() {
//		dhore nisi amra pura width ta k 5 bhaage bhaag korsi, 5 ta column
//		jar moddhe majher 3 ta column dilam page er content er jonno, r baki duita column dui side the
//		tai prothome total width k 5 die bhaag korlam
//		then 4 die gun korlam , jate 4rth column er last point ta pai
//		jekhan theke 5th column ta start hobe, mane rigth panel ta
//		this.setLocation(((int)sysInfo.winWidth/5)*4, 0);
	}
}
