package blogSite;

import components.dataCon;

public  class sysInfo {
	//shob static kora hoise, jate object create na koreo ei data gula jekono class theke access kora jay
	//etake amra local memory hishebe use korte parbo, for passing data between pages
	public static int winWidth = 1080; 
	public static int winHeight = 720; 
	public static boolean logged = false;
	public static String userName = "";
	public static dataCon dt = null;
	//jokhon sign in korbe tokhon eta true kore dite hobe
	//r j login korbe tar username ta rekhe dite hobe
	//jate jekono class thekei log in information gula paoa jay
	
	public static void setConnection() {
		dt = new dataCon();
	}
}
