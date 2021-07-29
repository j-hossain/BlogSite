package components;

import java.awt.Color;
import java.awt.Insets;import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class BTN extends JButton{
	public BTN(){
		createButton("Demo");
	}
	public BTN(String text){
		createButton(text);
	}
	
	private void createButton(String text) {
//		this.setSize(100,50); //if i do not set the size, its going to be dynamic, according to the length of the text
		this.setBackground(new Color(150,0,250));
//		this.setBackground(null);
		this.setText(text);
		this.setForeground(Color.white);
		this.setBorder(null);
		this.setBorder(new EmptyBorder(5, 10, 5, 10));
		this.setFocusPainted(false);//to remove the border outside the text
//		this.addActionListener(actionListener);
		
	}
}
