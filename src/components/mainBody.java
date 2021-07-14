package components;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import blogSite.*;

public class mainBody extends JPanel{
	public sidePanel leftPanel;
	public sidePanel rightPanel;
	public JPanel contentBody;
	public mainBody(JPanel cBody) {
		this.contentBody = cBody;
		init();
	}
	private void init() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.cyan);
		leftPanel = new sidePanel("left");
		this.add(leftPanel,BorderLayout.WEST);
		rightPanel = new sidePanel("right");
		this.add(rightPanel,BorderLayout.EAST);
//		contentBody.setLayout(null);
		contentBody.setPreferredSize(new Dimension(sysInfo.winWidth/5*3,sysInfo.winHeight-50));
		this.add(contentBody,BorderLayout.CENTER);
	}
}
