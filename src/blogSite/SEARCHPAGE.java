package blogSite;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import components.*;
public class SEARCHPAGE extends mainFrame {

	public SEARCHPAGE() {
		setTitle("Search page");//setting the title
		setMenuBar();//this adds a menu bar to the page
		conBody = new JPanel();
		JPanel prevewBoxContainer = new JPanel(); //this will be added to the content body
		prevewBoxContainer.setPreferredSize(new Dimension(620,570)); 
		prevewBoxContainer.setLayout(new GridLayout(4,1,10,10));
		prevewBoxContainer.add(new previewBox());
		prevewBoxContainer.add(new previewBox());
		prevewBoxContainer.add(new previewBox());
		prevewBoxContainer.add(new previewBox());
		conBody.add(prevewBoxContainer);//pura container ta content body panel er bhitre die dilam
		setMainBody();
	}

}
