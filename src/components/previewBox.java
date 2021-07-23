package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import blogSite.HOMEPAGE;
import blogSite.POSTPAGE;

public class previewBox extends JPanel implements ActionListener {
	public JLabel postTitle,postDate,postCategory,postAuthor;
	public JTextArea postPreview;
	public JButton postbtn,edtBtn,dltBtn;
	
	//data from database
	public int pId;
	public String pTitle,pDate,pAuthor,pText,pCategory;
	
	public JPanel topPanel,top1Panel,midPanel,bottomPanel;
	
	public previewBox() {
		
		//as the side panels are given 216 width each, then what left is 648 from 1080, so 620 is for the box and rest is the padding
		//There will be 3 preview boxes in a page, each of width 180, and 30 for padding, total 630
		this.setSize(new Dimension(620, 180));
		this.setBackground(new Color(230, 230, 230));
//		ei panel gular kichu similar propertie thakbe, tai ekta clas banay,
//		egulake oi class er object banay disi, jate eki line bar bar likhte na hoy
//		this is object oriented programming i guess :P
		topPanel = new posPanel(27);
		top1Panel = new posPanel(20);
		midPanel = new posPanel(50);
		bottomPanel = new posPanel(20);
		
		postbtn = new BTN("View full post");
		postbtn.setBackground(null);
		postbtn.setBorder(null);
		postbtn.setForeground(new Color(100,100,100));
		postbtn.addActionListener(this);
		//egula demo text , database connect korle tokhon database theke text nie boshabe
		postTitle = new JLabel();
		postPreview = new JTextArea();
		postAuthor = new JLabel();
		postCategory = new JLabel();//ekta post k ekta category tei deoa jabe
		postDate = new JLabel();
		
		//giving the post preview texts a bit of shape
		postPreview.setLineWrap(true);
		postPreview.setBackground(null);
		postPreview.setFont(new Font("",Font.PLAIN, 14));
		postPreview.setWrapStyleWord(true);
		postPreview.setForeground(new Color(100,100,100));
		
		//now giving the titles shape
		postTitle.setFont(new Font("",Font.BOLD,16));
		
		//getting rid of default bold style of lebels
		postDate.setFont(new Font("",Font.PLAIN,12));
		postAuthor.setFont(new Font("",Font.PLAIN,12));
		postAuthor.setForeground(new Color(100,100,100));
		postCategory.setFont(new Font("",Font.PLAIN,12));
		
		topPanel.add(postTitle,BorderLayout.WEST);
		topPanel.add(postDate,BorderLayout.EAST);
		//top panel er dui dike duita die dilam
		midPanel.add(postPreview);
		top1Panel.add(postAuthor,BorderLayout.EAST);
		bottomPanel.add(postCategory,BorderLayout.EAST);
		bottomPanel.add(postbtn,BorderLayout.WEST);
		//same as top panel
		this.add(topPanel);
		this.add(top1Panel);
		this.add(midPanel);
		this.add(bottomPanel);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==postbtn) {
			loadpostPage();
		}
		
	}
	private void loadpostPage() {
		// getting the current active window
		Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
		activeWindow.setVisible(false);
		new POSTPAGE(pId).setVisible(true);
	}
	
	public void loadPostData() {
		postTitle.setText(pTitle);
		postDate.setText(pDate);
		postAuthor.setText(pAuthor);
		postPreview.setText(pText);
		postCategory.setText(pCategory);
	}
	
	//this is for profile page only
	public void setModBtns() {
		this.top1Panel.removeAll();
		this.remove(top1Panel);
		this.add(top1Panel);
		this.top1Panel.setLayout(new FlowLayout());
		edtBtn = new BTN("Edit");
		dltBtn = new BTN("Delete");
		edtBtn.setMargin(new Insets(0,5,0,5));
		dltBtn.setMargin(new Insets(0,5,0,5));
		top1Panel.add(edtBtn);
		top1Panel.add(dltBtn);
		this.top1Panel.setPreferredSize(new Dimension(600,30));
		this.midPanel.setPreferredSize(new Dimension(600,40));
	}
}

class posPanel extends JPanel{
	public posPanel(int height) {
		setLayout(new BorderLayout());
		setBackground(null);
		setPreferredSize(new Dimension(600,height));
	}
}
