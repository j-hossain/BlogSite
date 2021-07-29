package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import blogSite.POSTPAGE;
import blogSite.sysInfo;

public class postBox extends previewBox {
	public postBox() {
		// TODO Auto-generated constructor stub
		this.setBackground(null);
		postTitle.setFont(new Font("",Font.BOLD,20));
		this.midPanel.setPreferredSize(new Dimension(600,520));
		midPanel.removeAll();
		JScrollPane scrollPane = new JScrollPane(postPreview);
		scrollPane.setBorder(null);
		postPreview.setBorder(new EmptyBorder(20,0,20,20));
		midPanel.add(scrollPane);
		this.bottomPanel.removeAll();
		this.remove(top1Panel);
		this.add(top1Panel);
		this.bottomPanel.add(this.postAuthor,BorderLayout.WEST);
		this.bottomPanel.add(this.postCategory,BorderLayout.EAST);
	}
	
}





