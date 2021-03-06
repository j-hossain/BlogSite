package blogSite;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import components.*;

public class PROFILEPAGE extends mainFrame implements ActionListener{
	public int postCount;
	public JPanel prevewBoxContainer,bottomPanel;
	public previewBox[] pBoxes;
	public JButton newBtn;
	public PROFILEPAGE(String author) {
		setTitle(author);//setting the title
		setMenuBar();//this adds a menu bar to the page
		conBody = new JPanel();
		prevewBoxContainer = new JPanel(); //this will be added to the content body
		prevewBoxContainer.setPreferredSize(new Dimension(620,580)); 
		prevewBoxContainer.setLayout(new GridLayout(4,1,5,5));
		postCount = sysInfo.dt.getCount("posts, post_log, user_table WHERE posts.id = post_log.post_id and user_table.id=post_log.user_id AND user_table.username='"+author+"'");
		pBoxes = setPosts(postCount,"select post_id,title,full_name,post_log.time,post,category from posts, post_log, user_table WHERE posts.id = post_log.post_id and user_table.id=post_log.user_id AND user_table.username='"+author+"'");
		PAGECONTROL pCon = new PAGECONTROL(postCount, prevewBoxContainer, pBoxes);
		pCon.loadPosts(1);
		conBody.add(prevewBoxContainer);//pura container ta content body panel er bhitre die dilam
		//creating a bottom panel that will hold page controllers and a new post button
		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(620,30));
		bottomPanel.setLayout(new BorderLayout());
		newBtn = new BTN("New Post");
		newBtn.addActionListener(this);
		if(author.equalsIgnoreCase(sysInfo.userName))
			setModifyBtns(pBoxes);
		bottomPanel.add(pCon,BorderLayout.EAST);
		conBody.add(bottomPanel);
		setMainBody();
	}
	
	public void setModifyBtns(previewBox[] pBoxs) {
		bottomPanel.add(newBtn,BorderLayout.WEST);
		for(int i=0;i<pBoxs.length;i++) {
			pBoxs[i].setModBtns();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==newBtn) {
			loadPostcrtPage();
		}
	}
	
	public void loadPostcrtPage() {
		// getting the current active window
		Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
		activeWindow.setVisible(false);
		new CREATEPOST().setVisible(true);
	}
}
