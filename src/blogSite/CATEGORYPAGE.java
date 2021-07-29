package blogSite;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import components.BTN;
import components.PAGECONTROL;
import components.mainFrame;
import components.previewBox;

public class CATEGORYPAGE extends mainFrame {
	public int postCount;
	public JPanel prevewBoxContainer,bottomPanel;
	public previewBox[] pBoxes;
	public JButton newBtn;
	public CATEGORYPAGE(String category) {
		setTitle(category);//setting the title
		setMenuBar();//this adds a menu bar to the page
		conBody = new JPanel();
		prevewBoxContainer = new JPanel(); //this will be added to the content body
		prevewBoxContainer.setPreferredSize(new Dimension(620,580)); 
		prevewBoxContainer.setLayout(new GridLayout(4,1,5,5));
		postCount = sysInfo.dt.getCount("posts, post_log, user_table WHERE posts.id = post_log.post_id and user_table.id=post_log.user_id AND category='"+category+"'");
		pBoxes = setPosts(postCount,"select post_id,title,full_name,post_log.time,post,category from posts, post_log, user_table WHERE posts.id = post_log.post_id and user_table.id=post_log.user_id AND category='"+category+"'");

		PAGECONTROL pCon = new PAGECONTROL(postCount, prevewBoxContainer, pBoxes);
		pCon.loadPosts(1);
		conBody.add(prevewBoxContainer);//pura container ta content body panel er bhitre die dilam
		//creating a bottom panel that will hold page controllers and a new post button
		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(620,30));
		bottomPanel.add(pCon);
		conBody.add(bottomPanel);
		setMainBody();
	}
}
