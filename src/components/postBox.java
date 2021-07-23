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
import javax.swing.JTextArea;

import blogSite.POSTPAGE;
import blogSite.sysInfo;

public class postBox extends previewBox {
	public postBox() {
		// TODO Auto-generated constructor stub
		this.midPanel.setPreferredSize(new Dimension(600,520));
		this.bottomPanel.removeAll();
		this.remove(top1Panel);
		this.add(top1Panel);
		this.bottomPanel.add(this.postAuthor,BorderLayout.WEST);
		this.bottomPanel.add(this.postCategory,BorderLayout.EAST);
	}
	
}





