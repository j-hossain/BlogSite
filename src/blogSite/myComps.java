package blogSite;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;








class mainPanel extends JPanel{
	public mainPanel() {
		// TODO Auto-generated constructor stub
		Init();
	}
	
	private  void Init() {
		this.setLayout(null);
		
	}
}

//class mainPanel extends JPanel{
//	JFrame curFrame;
//	public leftSideBar lb;
//	public rightSideBar rb;
//	public contentBody cb;
//	
//	public mainPanel(JFrame cFrame) {
//		curFrame = cFrame;
//		this.setVisible(true);
//		this.setLayout(new GridBagLayout());
//		lb = new leftSideBar();
//		rb = new rightSideBar();
//		cb = new contentBody();
//		
//		GridBagConstraints  gbc = new GridBagConstraints();
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.weightx = 1;
//		gbc.weighty = 1;
//		gbc.gridx=0;
//		gbc.gridy=0;
//		this.add(lb,gbc);
//		gbc.gridx = 4;
//		this.add(rb,gbc);
//		gbc.fill = GridBagConstraints.VERTICAL;
//		gbc.weightx = 1;
//		gbc.gridx = 1;
//		gbc.gridy = 0;
//		this.add(cb,gbc);
//	}
//}
//
//class sideBar extends JPanel{
//	public sideBar() {
//		this.setVisible(true);
////		this.setBackground(Color.black);
//	}
//}
//
//class leftSideBar extends sideBar{
//	public leftSideBar() {
//	}
//}
//
//class rightSideBar extends sideBar{
//	public rightSideBar() {
//	}
//}
//
//class contentBody extends JPanel{
//	public contentBody() {
//		this.setVisible(true);
//		this.setBackground(null);
//		this.setLayout(new GridLayout(0,1,10,10));
//		this.add(new previewBox());
//		this.add(new previewBox());
//		this.add(new previewBox());
//		this.add(new previewBox());
//		this.add(new previewBox());
//		this.add(new previewBox());
//	}
//}
//
////now creating the preview boxes for posts
//class previewBox extends JPanel {
//	
//	}
//}
//
//class scrollablePanel extends JScrollPane{
//	public JPanel innerPanel; 
//	public scrollablePanel() {
//		innerPanel = new JPanel();
//	}
//	
//	public void addEle() {
//		
//	}
//}


