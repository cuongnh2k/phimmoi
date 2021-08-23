package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {

	public Connection getConnection() {
		final String url = "jdbc:mysql://localhost:3306/phimmoi";
		final String user = "root";
		final String password = "231020";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
//	public Connection getConnection() {
//		final String url = "jdbc:mysql://sql108.epizy.com/epiz_29494546_phimmoi";
//		final String user = "epiz_29494546";
//		final String password = "pKAEv4stTZa7Gv";
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			return DriverManager.getConnection(url, user, password);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

//	public static void main(String[] args) {
////		System.out.println(System.getProperty("java.runtime.version"));
//		DBContext db=new DBContext();
//		if(db.getConnection()!=null) {
//			System.out.println("ok");
//		}
//		else {
//			System.out.println("fail");
//		}
//	}

}
