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
		prevewBoxContainer.setPreferredSize(new Dimension(620,570)); //since it will only contain the preview boxes , not the page indicators
		//gridLayout(number of rows, num of columns, horizontal gap, vert gap)
		prevewBoxContainer.setLayout(new GridLayout(4,1,10,10)); //seting the grid layout so that all the preview boxes align them self up in a single column, with equal gaps between them automatically
		// egula test er jonno boshano, actulally, database theke shob gula post nibe,
		// then oi list onujai, popst gulake assign korte hobe
//		prevewBoxContainer.add(new previewBox());
//		prevewBoxContainer.add(new previewBox());
//		prevewBoxContainer.add(new previewBox());
//		prevewBoxContainer.add(new previewBox());
		
//		creating an array of 4 preview boxes
		postCount = sysInfo.dt.getCount("posts");
		pBoxes = new previewBox[postCount];
		pBoxes = setPosts(pBoxes);//dtabase theke data nie set kore dibe
		
		loadPosts(0);
		
		conBody.add(prevewBoxContainer);//pura container ta content body panel er bhitre die dilam
		conBody.add(new pageGroup());//ei part die page control hobe
//		conBody.setBackground(Color.green);
		setMainBody();//ebar main body ta set kore dibe, jekhane side panel ache, content body ache
	}
	
	public  previewBox[] setPosts(previewBox[] pbBoxs) {
		ResultSet rSet;
		int cnt=0;
		try {
			rSet = sysInfo.dt.getData("select post_id,title,full_name,post_log.time,post,category from posts, post_log, user_table WHERE posts.id = post_log.post_id and user_table.id=post_log.user_id");
			while(rSet.next()) {
				pbBoxs[cnt] = new previewBox();
				pbBoxs[cnt].pId = rSet.getInt("post_id");
				pbBoxs[cnt].pTitle = rSet.getString("title");
				pbBoxs[cnt].pDate = rSet.getString("time");
				pbBoxs[cnt].pAuthor = rSet.getString("full_name");
				pbBoxs[cnt].pText = rSet.getString("post");
				pbBoxs[cnt].pCategory = rSet.getString("category");
				pbBoxs[cnt].loadPostData();
				cnt++;
			}	
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return pbBoxs;
	}
	
	public void loadPosts(int page) {
		int low = page*4;
		int  high = postCount>=(low+4)?low+4:postCount;
		prevewBoxContainer.removeAll();
		for(int it=low;it<high;it++) {
			prevewBoxContainer.add(pBoxes[it]);
		}
	}
}


