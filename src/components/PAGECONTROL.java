package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
	public int pgCnt = 0;
	public int postCount;
	public JPanel prevewBoxContainer;
	public previewBox[] pBoxes;
	
	public PAGECONTROL(int sz, JPanel container, previewBox[] elem) {
		//taking the container and all that are to be controlled
		postCount = sz;
		prevewBoxContainer = container;
		pBoxes = elem;
		
		//setting this panel
		setLayout(new BorderLayout(5,5));
		setPreferredSize(new Dimension(150,26));
		
		//creating the button icons
		ImageIcon nxtIcn = createImageIcon("images/nxtIcon3.png");
		ImageIcon prvIcn = createImageIcon("images/prvIcon3.png");
		
		//creating the buttons
		nxtBtn = new JButton(nxtIcn);
		prvBtn = new JButton(prvIcn);
		//creating the page label
		pgNum = new JLabel(Integer.toString(pgCnt));
		pgNum.setHorizontalAlignment(SwingConstants.CENTER);
		pgNum.setFont(new Font("",Font.PLAIN,20));
		
		
		add(nxtBtn, BorderLayout.EAST);
		add(prvBtn, BorderLayout.WEST);
		add(pgNum,BorderLayout.CENTER);
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
		int mx = postCount/4;
		if(mx*4!=postCount)mx++;
		if(pgCnt==mx)
			return;
		pgCnt++;
		loadPosts(pgCnt);
	}
	
	public void gotoPrev() {
		if(pgCnt==0)
			return;
		pgCnt--;
		loadPosts(pgCnt);
	}

	
	public void loadPosts(int page) {
		int low = page*4;
		int  high = postCount>=(low+4)?low+4:postCount;
		prevewBoxContainer.removeAll();
		for(int it=low;it<high;it++) {
			prevewBoxContainer.add(pBoxes[it]);
		}
		prevewBoxContainer.setVisible(false);
		prevewBoxContainer.setVisible(true);
	}
}
