package blogSite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import components.*;

public class POSTPAGE extends mainFrame {

	public POSTPAGE() {
		// TODO Auto-generated constructor stub
			setTitle("Post page");//setting the title
			setMenuBar();//this adds a menu bar to the page
			conBody = new JPanel();
			JPanel prevewBoxContainer = new JPanel(); //this will be added to the content body
			prevewBoxContainer.setPreferredSize(new Dimension(620,2500));
			prevewBoxContainer.setLayout(new GridLayout(4,1,10,10));
			prevewBoxContainer.add(new previewpost());
			conBody.add(prevewBoxContainer);//pura container ta content body panel er bhitre die dilam
			conBody.add(new pageGroup());
			setMainBody();
	}

}
