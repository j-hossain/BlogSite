package blogSite;
import components.*;
import javax.swing.*;

import components.dataCon;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class Starter {
	//shudhu ei class ei main function thakbe, jate run dile eta thekei run hoy
	public static void main(String[] args) {
		sysInfo.setConnection();//this is a static method, setting the connection for once and for all
//		jokhon jei page nie kaaj korbo, tokhon ota ekhane call kore dile test krte easy hobe
//		but kaaj shesh e abr homepage k call kore dile bhalo, nahole git merge korte gele contradict hobe
		JFrame home = new HOMEPAGE();
		home.setVisible(true);
	}
}
