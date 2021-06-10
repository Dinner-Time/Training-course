package co.board.util;

import java.sql.*;

public class DAO {
	
	Connection connectUrl;
	
	public Connection getConnectUrl() {
		return connectUrl;
	}

	public DAO(){
		try {
			// db경로
			String sampleDBUrl = "jdbc:sqlite:C:/sqlite/db/sample.db";
			// db와 연결
			connectUrl = DriverManager.getConnection(sampleDBUrl);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
