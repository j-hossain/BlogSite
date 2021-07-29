package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PAGECONTROL extends JPanel implements ActionListener{
	public JButton nxtBtn;
	public JButton prvBtn;
	public JLabel pgNum;
	public int pgCnt = 1;
	public int mxPg;
	public int postCount;
	public JPanel prevewBoxContainer,nxtPanel,prvPanel;
	public previewBox[] pBoxes;
	
	public PAGECONTROL(int sz, JPanel container, previewBox[] elem) {
		//taking the container and all that are to be controlled
		postCount = sz;
		prevewBoxContainer = container;
		pBoxes = elem;
		
		this.setBackground(new Color(150,0,250));
		this.setLayout(new FlowLayout(FlowLayout.CENTER,1,2));
		
		//maximum possible page number
		mxPg = postCount/4;
		if(mxPg*4!=postCount)mxPg++;
		
		//setting this panel
		setPreferredSize(new Dimension(150,30));
		
		//creating the button icons
		ImageIcon nxtIcn = createImageIcon("images/nxtIcon3.png");
		ImageIcon prvIcn = createImageIcon("images/prvIcon3.png");
		
		//creating the buttons
		nxtBtn = new JButton(">");
		prvBtn = new JButton("<");
		nxtBtn.setBackground(null);
		prvBtn.setBackground(null);
		nxtBtn.setBorder(null);
		prvBtn.setBorder(null);
		nxtBtn.setFont(new Font("",Font.BOLD, 24));
		prvBtn.setFont(new Font("",Font.BOLD, 24));
		nxtBtn.setForeground(Color.white);
		prvBtn.setForeground(Color.white);
		//creating the page label
		pgNum = new JLabel();
		pgNum.setHorizontalAlignment(SwingConstants.CENTER);
		pgNum.setFont(new Font("",Font.PLAIN,20));
		pgNum.setForeground(Color.white);
		
		//adding action listener
		nxtBtn.addActionListener(this);
		prvBtn.addActionListener(this);
		
		nxtPanel = new JPanel();
		prvPanel = new JPanel();
		nxtPanel.setPreferredSize(new Dimension(50,25));
		prvPanel.setPreferredSize(new Dimension(50,25));
		nxtPanel.setBackground(null);
		prvPanel.setBackground(null);
		nxtPanel.setLayout(new BorderLayout());
		prvPanel.setLayout(new BorderLayout());
		
		this.add(prvPanel);
		this.add(pgNum);
		this.add(nxtPanel);
		
		
		loadPageControl();
	}
	
	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==nxtBtn)
			gotoNext();
		else if(e.getSource()==prvBtn)
			gotoPrev();
	}
	
	public void gotoNext() {
		pgCnt++;
		loadPosts(pgCnt);
	}
	
	public void gotoPrev() {
		pgCnt--;
		loadPosts(pgCnt);
	}

	
	public void loadPosts(int page) {
		page--;
		int low = page*4;
		int  high = postCount>=(low+4)?low+4:postCount;
		prevewBoxContainer.removeAll();
		for(int it=low;it<high;it++) {
			prevewBoxContainer.add(pBoxes[it]);
		}
		
		//refreshing all
		prevewBoxContainer.setVisible(false);
		prevewBoxContainer.setVisible(true);
		loadPageControl();
	}
	
	public void loadPageControl() {
		this.setVisible(false);
		nxtPanel.removeAll();
		prvPanel.removeAll();
		pgNum.setText(Integer.toString(pgCnt));
		if(pgCnt>1)
				prvPanel.add(prvBtn,BorderLayout.WEST);
		if(pgCnt<mxPg)
			nxtPanel.add(nxtBtn,BorderLayout.EAST);
		this.setVisible(true);
	}
}
