package blogSite;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import components.*;

public class PROFILEPAGE extends mainFrame {
	public int postCount;
	public JPanel prevewBoxContainer;
	public previewBox[] pBoxes;
	public PROFILEPAGE(String author) {
		setTitle(author);//setting the title
		setMenuBar();//this adds a menu bar to the page
		conBody = new JPanel();
		prevewBoxContainer = new JPanel(); //this will be added to the content body
		prevewBoxContainer.setPreferredSize(new Dimension(620,590)); 
		prevewBoxContainer.setLayout(new GridLayout(4,1,10,10));
		postCount = sysInfo.dt.getCount("posts, post_log, user_table WHERE posts.id = post_log.post_id and user_table.id=post_log.user_id AND user_table.username='"+author+"'");
		pBoxes = setPosts(postCount,"select post_id,title,full_name,post_log.time,post,category from posts, post_log, user_table WHERE posts.id = post_log.post_id and user_table.id=post_log.user_id AND user_table.username='"+author+"'");
		if(sysInfo.userName==author)
			setModifyBtns(pBoxes);
		PAGECONTROL pCon = new PAGECONTROL(postCount, prevewBoxContainer, pBoxes);
		pCon.loadPosts(1);
		conBody.add(prevewBoxContainer);//pura container ta content body panel er bhitre die dilam
		conBody.add(pCon);
		setMainBody();
	}
	
	public void setModifyBtns(previewBox[] pBoxs) {
		for(int i=0;i<pBoxs.length;i++) {
			pBoxs[i].setModBtns();
			
		}
	}
}
