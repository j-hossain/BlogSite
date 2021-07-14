package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class previewBox extends JPanel {
	public JLabel postTitle;
	public JLabel postDate;
	public JTextArea postPreview;
	public JLabel postCategory;
	public JLabel postAuthor;

	public previewBox() {
		
		//as the side panels are given 216 width each, then what left is 648 from 1080, so 620 is for the box and rest is the padding
		//There will be 3 preview boxes in a page, each of width 180, and 30 for padding, total 630
		this.setSize(new Dimension(620, 180));
		this.setBackground(new Color(230, 230, 230));
		
		JPanel topPanel = new posPanel(40);
		JPanel midPanel = new posPanel(50);
		JPanel bottomPanel = new posPanel(20);
		
		postTitle = new JLabel("This is the Title");
		postPreview = new JTextArea("What is Lorem Ipsum Lorem Ipsum is simply dummy text of the printing and typesetting industry Lorem Ipsum has been the industry's standard dummy text ever since the");
		postAuthor = new JLabel("Author Name");
		postCategory = new JLabel("Category");
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
		postCategory.setFont(new Font("",Font.PLAIN,12));
		
		topPanel.add(postTitle,BorderLayout.WEST);
		topPanel.add(postDate,BorderLayout.EAST);
		midPanel.add(postPreview);
		bottomPanel.add(postAuthor,BorderLayout.WEST);
		bottomPanel.add(postCategory,BorderLayout.EAST);
		this.add(topPanel);
		this.add(midPanel);
		this.add(bottomPanel);
	}
}

class posPanel extends JPanel{
	public posPanel(int height) {
		setLayout(new BorderLayout());
		setBackground(null);
		setPreferredSize(new Dimension(600,height));
	}
}
