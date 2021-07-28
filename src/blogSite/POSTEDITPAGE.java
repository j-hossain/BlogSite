package blogSite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import components.BTN;
import components.mainFrame;
import components.postBox;

public class POSTEDITPAGE extends mainFrame implements ActionListener {
	JPanel catPanel,pstPanel,ttlpanel; 
	JButton edit,dlt;
	JLabel catgry,post,ttle;  
	JTextField cattxt,ttl;
	JTextArea posttxt;
	public String pTitle,pid;
	public POSTEDITPAGE() {
		// TODO Auto-generated constructor stub
		setTitle("Edit Your Post");
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
		post=new JLabel("Modify Your Post");  
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
		createpost.add(catPanel);
		createpost.add(ttlpanel);
		createpost.add(pstPanel);
		edit=new BTN("EDIT"); 
	    edit.setMaximumSize(new Dimension(100,50));
	    dlt=new BTN("DELETE"); 
	    dlt.setMaximumSize(new Dimension(100,50));
		createpost.add(edit);
		createpost.add(dlt);
		conBody.add(createpost);
		
		setMainBody();
	}
	public void loadData(postBox post) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
