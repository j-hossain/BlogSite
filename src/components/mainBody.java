package components;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import blogSite.*;

public class mainBody extends JPanel{
	public sidePanel leftPanel;
	public sidePanel rightPanel;
	//ei side panel gulay, latest category, latest post, etc rakhar plan ache, time pele implement korbo
	public JPanel contentBody;
	public mainBody(JPanel cBody) {
		//ekek page er khetre content body te content ekekrokom thakbe
		//tai oi page e aage content body take create kore rakhte hobe,
//		then jokhon mainbody create hobe, tokhon constructor e eta pathay dilei hobe
		this.contentBody = cBody;
		init();
	}
	private void init() {
		//panel er default layout thake flowLayout, amader border layout lagbe, side panel gulake easily ekdom side e deoar jonno
		this.setLayout(new BorderLayout());
		leftPanel = new sidePanel("left");//for details, look in sidepanel class
		this.add(leftPanel,BorderLayout.WEST);
		rightPanel = new sidePanel("right");
		this.add(rightPanel,BorderLayout.EAST);
//		contentBody.setLayout(null);
		//layout ta page to page vary korbe, jekhane jemon layout dorkar add kore nibe, tai r null korlam na
		contentBody.setPreferredSize(new Dimension(sysInfo.winWidth/5*3,sysInfo.winHeight-50));
		this.add(contentBody,BorderLayout.CENTER);
	}
}
