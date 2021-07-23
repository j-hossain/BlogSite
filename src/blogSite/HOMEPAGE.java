package blogSite;
import components.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class HOMEPAGE extends mainFrame {
	public int postCount;
	public JPanel prevewBoxContainer;
	public previewBox[] pBoxes;
	public HOMEPAGE() {
		setTitle("Home page");//setting the title
		setMenuBar();//this adds a menu bar to the page
		conBody = new JPanel();//conBody is declare in the mainFrame class and added in main body class
		prevewBoxContainer = new JPanel(); //this will be added to the content body
		prevewBoxContainer.setPreferredSize(new Dimension(620,590)); //since it will only contain the preview boxes , not the page indicators
		//gridLayout(number of rows, num of columns, horizontal gap, vert gap)
		prevewBoxContainer.setLayout(new GridLayout(4,1,10,10)); //seting the grid layout so that all the preview boxes align them self up in a single column, with equal gaps between them automatically
		// egula test er jonno boshano, actulally, database theke shob gula post nibe,
		// then oi list onujai, popst gulake assign korte hobe
//		prevewBoxContainer.add(new previewBox());
//		prevewBoxContainer.add(new previewBox());
//		prevewBoxContainer.add(new previewBox());
//		prevewBoxContainer.add(new previewBox());
		
		postCount = sysInfo.dt.getCount("posts");
		pBoxes = setPosts(postCount,"select post_id,title,full_name,post_log.time,post,category from posts, post_log, user_table WHERE posts.id = post_log.post_id and user_table.id=post_log.user_id");//dtabase theke data nie set kore dibe
		PAGECONTROL pCon = new PAGECONTROL(postCount, prevewBoxContainer, pBoxes);
		pCon.loadPosts(1);
		conBody.add(prevewBoxContainer);//pura container ta content body panel er bhitre die dilam
		conBody.add(pCon);//ei part die page control hobe
//		conBody.setBackground(Color.green);
		setMainBody();//ebar main body ta set kore dibe, jekhane side panel ache, content body ache
	}
	
}


