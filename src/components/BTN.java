package components;

import java.awt.Color;
import java.awt.Insets;import java.awt.event.ActionEvent;

import javax.swing.JButton;
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
		this.setBackground(Color.black);
		this.setText(text);
		this.setForeground(Color.white);
		this.setFocusPainted(false);//to remove the border outside the text
//		this.addActionListener(actionListener);
		
	}
}
