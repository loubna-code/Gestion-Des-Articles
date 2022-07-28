package Persistance;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {
	final static String driverClassName = "com.mysql.jdbc.Driver";
	final static String URL = "jdbc:mysql://localhost:3306/tp2swing";
	final static String Login = "root";
	final static String Password = "200303";

	private static ConnexionDB connexionDB = null;

	private ConnexionDB() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(URL, Login, Password);
		return conn;
	}

	public static ConnexionDB getInstance() {
		if (connexionDB == null) {
			connexionDB = new ConnexionDB();
		}
		return connexionDB;
	}
}
