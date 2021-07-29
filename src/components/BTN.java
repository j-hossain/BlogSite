package components;

import java.awt.Color;
import java.awt.Insets;import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import blogSite.sysInfo;

public class BTN extends JButton{
	public BTN(){
		createButton("Demo");
	}
	public BTN(String text){
		createButton(text);
	}
	
	private void createButton(String text) {
//		this.setSize(100,50); //if i do not set the size, its going to be dynamic, according to the length of the text
		this.setBackground(sysInfo.darkCol);
//		this.setBackground(null);
		this.setText(text);
		this.setForeground(Color.white);
		this.setBorder(null);
		this.setBorder(new EmptyBorder(5, 10, 5, 10));
		this.setFocusPainted(false);//to remove the border outside the text
//		this.addActionListener(actionListener);
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				hoverOut();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				hoverIn();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	public void hoverOut() {
		this.setBackground(sysInfo.darkCol);
		this.setForeground(Color.white);
	}
	public void hoverIn() {
		this.setBackground(sysInfo.lightCol);
		this.setForeground(sysInfo.darkCol);
	}
}
