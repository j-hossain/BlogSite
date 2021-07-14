package blogSite;
import components.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HOMEPAGE extends mainFrame {
	public HOMEPAGE() {
//		super();
		setTitle("Home page");//setting the title
		setMenuBar();//this adds a menu bar to the page
		conBody = new JPanel();//conBody is decalre in the mainframe class
		JPanel prevewBoxContainer = new JPanel(); //this will be added to the content body
		prevewBoxContainer.setPreferredSize(new Dimension(620,570)); //since it will only contain the preview boxes , not the page indicators
		//gridLayout(number of rows, num of columns, horizontal gap, vert gap)
		prevewBoxContainer.setLayout(new GridLayout(4,1,10,10)); //seting the grid layout so that all the preview boxes align them self up in a single column, with equal gaps between them automatically
		prevewBoxContainer.add(new previewBox());
		prevewBoxContainer.add(new previewBox());
		prevewBoxContainer.add(new previewBox());
		prevewBoxContainer.add(new previewBox());
		
		
		conBody.add(prevewBoxContainer);
		conBody.add(new pageGroup());
//		conBody.setBackground(Color.green);
		setMainBody();
	}
}
