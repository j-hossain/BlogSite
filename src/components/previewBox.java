package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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
	public JLabel postTitle;
	public JLabel postDate;
	public JTextArea postPreview;
	public JLabel postCategory;
	public JLabel postAuthor;
	JButton postbtn;
	public String id;
	public previewBox() {
		
		//as the side panels are given 216 width each, then what left is 648 from 1080, so 620 is for the box and rest is the padding
		//There will be 3 preview boxes in a page, each of width 180, and 30 for padding, total 630
		this.setSize(new Dimension(620, 180));
		this.setBackground(new Color(230, 230, 230));
//		ei panel gular kichu similar propertie thakbe, tai ekta clas banay,
//		egulake oi class er object banay disi, jate eki line bar bar likhte na hoy
//		this is object oriented programming i guess :P
		JPanel topPanel = new posPanel(27);
		JPanel top1Panel = new posPanel(13);
		JPanel midPanel = new posPanel(50);
		JPanel bottomPanel = new posPanel(20);
		postbtn = new BTN("View full post");
		postbtn.setBackground(null);
		postbtn.setBorder(null);
		postbtn.setForeground(new Color(100,100,100));
		postbtn.addActionListener(this);
		//egula demo text , database connect korle tokhon database theke text nie boshabe
		postTitle = new JLabel();
		postTitle.setText("The Title");
		postPreview = new JTextArea("What is Lorem Ipsum Lorem Ipsum is simply dummy text of the printing and typesetting industry Lorem Ipsum has been the industry's standard dummy text ever since the");
		postAuthor = new JLabel("Author Name");
		postCategory = new JLabel("Category");//ekta post k ekta category tei deoa jabe
		postDate = new JLabel("5:00 pm 14 July, 2020");
		
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
		top1Panel.add(postAuthor,BorderLayout.WEST);
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
		new POSTPAGE().setVisible(true);
	}
}

class posPanel extends JPanel{
	public posPanel(int height) {
		setLayout(new BorderLayout());
		setBackground(null);
		setPreferredSize(new Dimension(600,height));
	}
}
