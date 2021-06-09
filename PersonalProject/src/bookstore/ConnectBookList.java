package bookstore;

import java.sql.*;

public class ConnectBookList {
	
	private static Connection dbUrl;

	public static Connection getDbUrl() {
		return dbUrl;
	}

	public static void connect() {
		try {
			// db경로
			String sampleDBUrl = "jdbc:sqlite:C:\\sqlite\\db\\BookList.db";
			// db와 연결
			dbUrl = DriverManager.getConnection(sampleDBUrl);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
