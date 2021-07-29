package blogSite;

import java.awt.Color;

import components.dataCon;

public  class sysInfo {
	//shob static kora hoise, jate object create na koreo ei data gula jekono class theke access kora jay
	//etake amra local memory hishebe use korte parbo, for passing data between pages
	public static int winWidth = 1080; 
	public static int winHeight = 720; 
	public static boolean logged = false;
	public static String userName = "";
	public static dataCon dt = null;
	public static Color darkCol = new Color(150,0,250);
//	new Color(150,0,250) violet
//	new Color(235, 204, 255) violet light
	public static Color lightCol = new Color(245, 214, 255);
	
	//jokhon sign in korbe tokhon eta true kore dite hobe
	//r j login korbe tar username ta rekhe dite hobe
	//jate jekono class thekei log in information gula paoa jay
	
	public static void setConnection() {
		dt = new dataCon();
	}
}
