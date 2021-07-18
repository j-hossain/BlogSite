package blogSite;
import components.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HOMEPAGE extends mainFrame {
	public HOMEPAGE() {
		setTitle("Home page");//setting the title
		setMenuBar();//this adds a menu bar to the page
		conBody = new JPanel();//conBody is declare in the mainFrame class and added in main body class
		JPanel prevewBoxContainer = new JPanel(); //this will be added to the content body
		prevewBoxContainer.setPreferredSize(new Dimension(620,570)); //since it will only contain the preview boxes , not the page indicators
		//gridLayout(number of rows, num of columns, horizontal gap, vert gap)
		prevewBoxContainer.setLayout(new GridLayout(4,1,10,10)); //seting the grid layout so that all the preview boxes align them self up in a single column, with equal gaps between them automatically
		// egula test er jonno boshano, actulally, database theke shob gula post nibe,
		// then oi list onujai, popst gulake assign korte hobe
		prevewBoxContainer.add(new previewBox());
		prevewBoxContainer.add(new previewBox());
		prevewBoxContainer.add(new previewBox());
		prevewBoxContainer.add(new previewBox());
		
		
		conBody.add(prevewBoxContainer);//pura container ta content body panel er bhitre die dilam
		conBody.add(new pageGroup());//ei part die page control hobe
//		conBody.setBackground(Color.green);
		setMainBody();//ebar main body ta set kore dibe, jekhane side panel ache, content body ache
	}
}
