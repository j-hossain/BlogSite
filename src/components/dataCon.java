package components;
import java.sql.*;

import blogSite.sysInfo;


//auto increment jei feild deoa okhane null pathailei auto increment hoye jabe

public class dataCon {
	public Connection dtbs;
	public dataCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String url = "jdbc:mysql://sql6.freesqldatabase.com:3306/sql6427252";
		String user = "sql6427252";
		String password = "F3HJndxqd7";
		try {
        	dtbs = DriverManager.getConnection(url, user, password);
        }
        catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
	}
	
	public ResultSet getData(String cmd) {
		ResultSet rSet = null;
		try {
			Statement stt = dtbs.createStatement();
			rSet = stt.executeQuery(cmd);			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rSet;
	}
	
	public int getCount(String table) {
		
		//this method is used to get the total row count of any table
		int size=0;
		try {
			ResultSet rs = sysInfo.dt.getData("SELECT COUNT(*) FROM "+table);
			rs.next();		
			size = rs.getInt(1);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return size;
	}
}



//how to get data
//String res = null;
//try {
//	ResultSet rs = dt.getData("select * from posts where id = 1");
//	rs.next();		
//	res = rs.getString("title");
//}
//catch (Exception e) {
//	// TODO: handle exception
//	e.printStackTrace();
//}
//System.out.println("Column from database: "+ res);