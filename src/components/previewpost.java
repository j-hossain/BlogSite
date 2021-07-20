package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import blogSite.POSTPAGE;

public class previewpost extends JPanel {

	public previewpost() {
		// TODO Auto-generated constructor stub
		JLabel title;
		JLabel Date;
		JTextArea Preview;
		JLabel Category;
		JLabel Author;
		this.setSize(new Dimension(620, 2000));
		this.setBackground(new Color(230, 230, 230));
//		ei panel gular kichu similar propertie thakbe, tai ekta clas banay,
//		egulake oi class er object banay disi, jate eki line bar bar likhte na hoy
//		this is object oriented programming i guess :P
		JPanel topPanel = new posPane(27);
		JPanel top1Panel = new posPane(13);
		JPanel midPanel = new posPane(520);
		JPanel bottomPanel = new posPane(20);
	    title = new JLabel();
	    title.setText("The Title");
		Preview = new JTextArea("Lorem Ipsum is simply dummy text of the printing and typesetting industry vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi  vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi  vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi  vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi  vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi  vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi  vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi  vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi  vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi  vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi  vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi  vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi  vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi  vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi  vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi  vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi vugicugi");
		Author = new JLabel("Author Name");
		Category = new JLabel("Category");//ekta post k ekta category tei deoa jabe
		Date = new JLabel("5:00 pm 14 July, 2020");
		
		//giving the post preview texts a bit of shape
		Preview.setLineWrap(true);
		Preview.setBackground(null);
		Preview.setFont(new Font("",Font.PLAIN, 14));
		Preview.setWrapStyleWord(true);
		Preview.setForeground(new Color(100,100,100));
		
		//now giving the titles shape
		title.setFont(new Font("",Font.BOLD,30));
		
		//getting rid of default bold style of lebels
		Date.setFont(new Font("",Font.PLAIN,12));
		Author.setFont(new Font("",Font.PLAIN,12));
		Author.setForeground(new Color(100,100,100));
		Category.setFont(new Font("",Font.PLAIN,12));
		
		topPanel.add(title,BorderLayout.WEST);
		topPanel.add(Date,BorderLayout.EAST);
		//top panel er dui dike duita die dilam
		midPanel.add(Preview);
		top1Panel.add(Author,BorderLayout.WEST);
		bottomPanel.add(Category,BorderLayout.EAST);
		//same as top panel
		this.add(topPanel);
		this.add(top1Panel);
		this.add(midPanel);
		this.add(bottomPanel);
		
	}
}

class posPane extends JPanel{
	public posPane(int height) {
		setLayout(new BorderLayout());
		setBackground(null);
		setPreferredSize(new Dimension(600,height));
	}
}





