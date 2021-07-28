package blogSite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import components.*;

public class CREATEPOST extends mainFrame implements ActionListener   {
	JPanel catPanel,pstPanel,ttlpanel; 
	JButton pst;
	JLabel catgry,post,ttle;  
	JTextField cattxt,ttl;
	JTextArea posttxt;
	public CREATEPOST() {
		this.setTitle("CREATEPOST page");
		setMenuBar();
		conBody = new JPanel();
		JPanel createpost = new JPanel(); 
		createpost.setPreferredSize(new Dimension(620,590));
		
		catPanel = new postnPanel(27);
		ttlpanel = new postnPanel(27);
		pstPanel = new postnPanel(50);
		pstPanel.setPreferredSize(new Dimension(600,450));
		
		catgry=new JLabel("Category");  
		catgry.setBackground(null);
		catgry.setFont(new Font("",Font.PLAIN, 14));
		cattxt=new JTextField(40);
		ttle=new JLabel("Title");  
		ttle.setBackground(null);
		ttle.setFont(new Font("",Font.PLAIN, 14));
		ttl=new JTextField(40);
		post=new JLabel("What's on your mind?");  
		post.setBackground(null);
		post.setFont(new Font("",Font.PLAIN, 14));
		posttxt=new JTextArea(); 
		posttxt.setLineWrap(true);
		posttxt.setFont(new Font("",Font.PLAIN, 14));
		posttxt.setWrapStyleWord(true);
		posttxt.setForeground(new Color(100,100,100));
		catPanel.add(catgry,BorderLayout.WEST);
		catPanel.add(cattxt,BorderLayout.EAST);
		ttlpanel.add(ttle,BorderLayout.WEST);
		ttlpanel.add(ttl,BorderLayout.EAST);
		pstPanel.add(post,BorderLayout.NORTH);
		pstPanel.add(posttxt,BorderLayout.CENTER);
		pst=new BTN("POST"); 
	    pst.setMaximumSize(new Dimension(100,50));
	    pst.addActionListener(this);
		createpost.add(catPanel);
		createpost.add(ttlpanel);
		createpost.add(pstPanel);
		createpost.add(pst);
		conBody.add(createpost);
		setMainBody();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==pst) {
			String title,post,category;
			title= ttl.getText();
			post = posttxt.getText();
			category = cattxt.getText();
			//if(sysInfo.dt.getCount("SELECT * FROM post_log,posts,user_table WHERE posts.id = post_log.post_id AND user_table.id=post_log.user_id")) {
					if(createpost(title,post,category)) {
						this.setVisible(false);
						sysInfo.logged=true;
						new HOMEPAGE().setVisible(true);
					}
					
			//}
				
			}
			
		
	}
	
	public boolean createpost(String title, String post, String category) {
		return sysInfo.dt.sendData("INSERT INTO posts VALUES(null,'"+title+"','"+post+"','"+category+"')");
	}

}
class postnPanel extends JPanel{
	public postnPanel(int height) {
		setLayout(new BorderLayout());
		setBackground(null);
		setPreferredSize(new Dimension(600,height));
	}
	
}
