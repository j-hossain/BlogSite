package blogSite;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.ResultSet;

import javax.swing.JPanel;

import components.*;
public class SEARCHPAGE extends mainFrame {
	String keyWord;
	public int postCount;
	public JPanel prevewBoxContainer;
	public previewBox[] pBoxes;
	public SEARCHPAGE(String keyWord) {
		this.keyWord = keyWord;
		setTitle("Search page");//setting the title
		setMenuBar(keyWord);//this adds a menu bar to the page
		conBody = new JPanel();
		prevewBoxContainer = new JPanel(); //this will be added to the content body
		prevewBoxContainer.setPreferredSize(new Dimension(620,580)); 
		prevewBoxContainer.setLayout(new GridLayout(4,1,5,5));
		postCount = sysInfo.dt.getCount("posts, post_log, user_table WHERE posts.id = post_log.post_id and user_table.id=post_log.user_id AND (title LIKE '%"+keyWord+"%' OR post LIKE '%"+keyWord+"%' OR category LIKE '%"+keyWord+"%')");
		pBoxes = setPosts(postCount,"select post_id,title,full_name,post_log.time,post,category from posts, post_log, user_table WHERE posts.id = post_log.post_id and user_table.id=post_log.user_id AND (title LIKE '%"+keyWord+"%' OR post LIKE '%"+keyWord+"%' OR category LIKE '%"+keyWord+"%')");
		PAGECONTROL pCon = new PAGECONTROL(postCount, prevewBoxContainer, pBoxes);
		pCon.loadPosts(1);
		conBody.add(prevewBoxContainer);//pura container ta content body panel er bhitre die dilam
		conBody.add(pCon);
		setMainBody();
	}
}
