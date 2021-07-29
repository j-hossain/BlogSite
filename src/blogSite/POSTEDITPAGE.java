package blogSite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import components.BTN;
import components.mainFrame;
import components.postBox;

public class POSTEDITPAGE extends CREATEPOST implements ActionListener {
	int postId;
	public POSTEDITPAGE(int postId) {
		this.setTitle("Edit your Post");
		this.postId = postId;
		init();
		setTexts(postId);
	}

	public void setTexts(int postId) {
		ResultSet rSet = null;
		try {
			rSet = sysInfo.dt.getData("select post_id,title,username,post_log.time,post,category from posts, post_log, user_table WHERE posts.id = post_log.post_id and user_table.id=post_log.user_id AND post_id ="+postId);
			while(rSet.next()) {
				posttxt.setText(rSet.getString("post"));
				cattxt.setText(rSet.getString("category"));
				ttl.setText(rSet.getString("title"));
				pstTime = rSet.getString("time");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void createpost() {
		String title,post,category;
		title= sysInfo.dt.rmSpecialChar(ttl.getText());
		post = sysInfo.dt.rmSpecialChar(posttxt.getText());
		category = sysInfo.dt.rmSpecialChar(cattxt.getText());
		if(sysInfo.dt.sendData("Update posts set title='"+title+"',post='"+post+"',category='"+category+"' where id="+postId)) {
			this.setVisible(false);
			sysInfo.logged=true;
			new PROFILEPAGE(sysInfo.userName).setVisible(true);
		}
			
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==pst) {
			createpost();
		}
	}
}
