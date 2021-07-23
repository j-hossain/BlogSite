package components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;

import blogSite.*;
//this class defines the properties of all mainframes that are created on any instances of the application
public class mainFrame extends JFrame{
	public mainBody mBody;//panel that contains the side panels and also the content panel in the middle
	public JPanel conBody;//panel that contains the main contents of the current page
	public mainFrame() {
		//specifying the width and height
		this.setSize(new Dimension(sysInfo.winWidth,sysInfo.winHeight));
		//taking it to the middle
		this.setLocationRelativeTo(null);
		//the look of the application will break down if resized, thats why its disabled
		this.setResizable(false);
		//setting the close operation
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}
	
	public void setMenuBar() {
		//adding the menuPanel here
		JPanel menu = new menubar();
		this.add(menu,BorderLayout.NORTH);
	}
	
	public void setMainBody() {
		//adding a mainBody
		mBody = new mainBody(conBody);
		this.add(mBody);
	}


	public  previewBox[] setPosts(int pCnt, String cmd) {
		previewBox[] pbBoxs = new previewBox[pCnt];
		ResultSet rSet;
		int cnt=0;
		try {
			rSet = sysInfo.dt.getData(cmd);
			while(rSet.next()) {
				pbBoxs[cnt] = new previewBox();
				pbBoxs[cnt].pId = rSet.getInt("post_id");
				pbBoxs[cnt].pTitle = rSet.getString("title");
				pbBoxs[cnt].pDate = rSet.getString("time");
				pbBoxs[cnt].pAuthor = rSet.getString("full_name");
				pbBoxs[cnt].pText = getPreview(rSet.getString("post"));
				pbBoxs[cnt].pCategory = rSet.getString("category");
				pbBoxs[cnt].loadPostData();
				cnt++;
			}	
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		previewBox[] ret = new previewBox[cnt];
		for(int i=0;i<cnt;i++) {
			ret[i] = pbBoxs[i];
		}
		return ret;
	}

	public String getPreview(String Text) {
		int mx = 150>Text.length()?Text.length():150;
		Text = Text.substring(0,mx);
		Text = Text.concat("  ......");
		return Text;
	}
}