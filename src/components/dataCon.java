package components;
import java.sql.*;


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
		String url = "jdbc:mysql://localhost:3306/blog_database";
		String user = "root";
		String password = "";
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