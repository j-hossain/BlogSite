package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class pageGroup extends JPanel{
	public JButton nxtBtn;
	public JButton prvBtn;
	public JLabel pgNum;
	
	public pageGroup() {
		setLayout(new BorderLayout(5,5));
		setPreferredSize(new Dimension(80,40));
		ImageIcon nxtIcn = createImageIcon("images/nxtIcon3.png");
		ImageIcon prvIcn = createImageIcon("images/prvIcon3.png");
//		setBackground(Color.red);
		nxtBtn = new JButton(nxtIcn);
		prvBtn = new JButton(prvIcn);
		
		nxtBtn.setBorder(null);
		nxtBtn.setBackground(null);
		prvBtn.setBorder(null);
		prvBtn.setBackground(null);
		//background null koreo temon kaaj hocche na :/
		
		add(nxtBtn, BorderLayout.EAST);
		add(prvBtn, BorderLayout.WEST);
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
}
