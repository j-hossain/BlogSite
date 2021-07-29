package blogSite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;

import components.*;

public class POSTPAGE extends mainFrame {
	public int pId;
	public POSTPAGE(int id) {
		this.pId = id;
		// TODO Auto-generated constructor stub
		setTitle("Post page");//setting the title
		setMenuBar();//this adds a menu bar to the page
		conBody = new JPanel();
		JPanel postContainer = new JPanel(); //this will be added to the content body
		postContainer.setPreferredSize(new Dimension(620,620));
		postContainer.setLayout(new GridLayout(1,1,10,10));
		postBox post = new postBox();
		getPostData(post);
		postContainer.add(post);
		conBody.add(postContainer);//pura container ta content body panel er bhitre die dilam
		setMainBody();
	}
	public void getPostData(postBox post) {
		ResultSet rSet;
		try {
			rSet = sysInfo.dt.getData("SELECT post_id,title,full_name,post_log.time,post,category FROM posts, post_log, user_table WHERE posts.id = post_log.post_id AND user_table.id=post_log.user_id AND post_id="+this.pId);
			while(rSet.next()) {
				this.pId = rSet.getInt("post_id");
				post.pId=this.pId;
				post.pTitle = rSet.getString("title");
				post.pDate = rSet.getString("time");
				post.pAuthor = rSet.getString("full_name");
				post.pText = rSet.getString("post");
				post.pCategory = rSet.getString("category");
				post.loadPostData();
			}	
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
