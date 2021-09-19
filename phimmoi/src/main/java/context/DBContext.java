package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {

	public Connection getConnection() {
		final String url = "jdbc:mysql://localhost:3306/phimmoi";
		final String user = "root";
		final String password = "tagiang2302*";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
