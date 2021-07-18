package blogSite;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Starter {
	//shudhu ei class ei main function thakbe, jate run dile eta thekei run hoy
	public static void main(String[] args) {
//		jokhon jei page nie kaaj korbo, tokhon ota ekhane call kore dile test krte easy hobe
//		but kaaj shesh e abr homepage k call kore dile bhalo, nahole git merge korte gele contradict hobe
		JFrame home = new HOMEPAGE();
		home.setVisible(true);
	}
}
