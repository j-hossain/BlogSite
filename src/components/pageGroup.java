package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class pageGroup extends JPanel{
	
	public pageGroup() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(200,40));
		setBackground(Color.red);
	}
}
