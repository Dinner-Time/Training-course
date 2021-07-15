package my.stream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class PersonDAO {
	static Scanner scanner = new Scanner(System.in);
	// 필드
	static PreparedStatement queryExecute;
	static ResultSet getSqlResult;
	static Connection connectUrl;
	
	// 전체출력
	// ArrayList타입으로 리턴
	public ArrayList<Person> getAllPerson() {
		ArrayList<Person> allPerson = new ArrayList<Person>();
		String sql = "select * from person"; // sql 쿼리문
		try {
			queryExecute = connectUrl.prepareStatement(sql);
			getSqlResult = queryExecute.executeQuery(); // 쿼리문 실행
			//
			while (getSqlResult.next()) {
				// Person 객체 생성 및 초기화
				Person person = new Person(
						getSqlResult.getInt("id"),
						getSqlResult.getString("name"),
						getSqlResult.getInt("age"),
						getSqlResult.getString("phone"));
				// 배열에 person 객체 추가
				allPerson.add(person);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		return allPerson;
	}
	
	// db와 java를 연결하는 메소드
	public static void connect() {
		try {
			// db경로
			String sampleDBUrl = "jdbc:sqlite:C:/sqlite/db/chinook.db";
			// db와 연결
			connectUrl = DriverManager.getConnection(sampleDBUrl);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// db와 java의 연결을 닫는 메소드
	public static void connectClose() {
		if (getSqlResult != null) {
			try {
				getSqlResult.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connectUrl != null) {
			try {
				getSqlResult.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (queryExecute != null) {
			try {
				getSqlResult.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static ArrayList<Employees> nameTel() {
		ArrayList<Employees> employees = new ArrayList<Employees>();
		String sql = "select * from employees";
		try {
			queryExecute = connectUrl.prepareStatement(sql);
			getSqlResult = queryExecute.executeQuery();
			while (getSqlResult.next()) {
				// Person 객체 생성 및 초기화
				Employees employee = new Employees(
						getSqlResult.getString("firstname"),
						getSqlResult.getString("lastname"),
						getSqlResult.getString("title"),
						Integer.parseInt(getSqlResult.getString("birthdate").substring(0, 4))
						);
				// 배열에 person 객체 추가
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
	
}
