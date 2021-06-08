package common;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SqliteConnect {
	static Scanner scanner = new Scanner(System.in);
	// 필드
	static PreparedStatement queryExecute;
	static ResultSet getSqlResult;
	static Connection connectUrl;
	// db와 java를 연결하는 메소드
	public static void connect() {
		try {
			// db경로
			String sampleDBUrl = "jdbc:sqlite:C:/sqlite/db/sample.db";
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
	// 전체출력
	// ArrayList타입으로 리턴
	public static ArrayList<Person> getAllPerson() {
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
	// id로 조회
	// Person타입으로 리턴
	public static Person getPersonById(int id) {
		Person p = null;
		String sql = "select * from person where id = " + id;
		try {
			queryExecute = connectUrl.prepareStatement(sql);
			getSqlResult = queryExecute.executeQuery(); // 쿼리문 실행
			//
			if (getSqlResult.next()) {
				p = new Person(
						getSqlResult.getInt("id"), 
						getSqlResult.getString("name"), 
						getSqlResult.getInt("age"),
						getSqlResult.getString("phone"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		return p;
	}
	// 입력
	public static void inputPerson(int id, String name, int age, String phone) {
	
		String sql = "insert into person values (?,?,?,?)";
		try {
			queryExecute = connectUrl.prepareStatement(sql);
			queryExecute.setInt(1, id);
			queryExecute.setString(2, name);
			queryExecute.setInt(3, age);
			queryExecute.setString(4, phone);
			int result = queryExecute.executeUpdate(); // update 된 건수
			System.out.println(result + "건 입력");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
	}
	// 수정
	public static void updatePersonById(Person p) {
		
		String sql = "update person set name=?, age=?, phone=? where id=?";
		try {
			queryExecute = connectUrl.prepareStatement(sql);
			queryExecute.setString(1, p.getName());
			queryExecute.setInt(2, p.getAge());
			queryExecute.setString(3, p.getPhone());
			queryExecute.setInt(4, p.getId());
			int result = queryExecute.executeUpdate(); // update 된 건수
			System.out.println(result + "건 update");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	// 삭제
	public static void deletePersonById(int id) {
		
		String sql = "delete from person where id = ?";
		try {
			queryExecute = connectUrl.prepareStatement(sql);
			queryExecute.setInt(1, id);
			int result = queryExecute.executeUpdate();
			if (result == 0) {
				System.out.println("해당 ID를 찾을 수 없습니다.");
			} else {
				System.out.println(result + "건 삭제");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void main(String[] args) {
		connect();
		int selectNo = 0;
		do {
			System.out.println("1.전체리스트 2.입력 3.수정 4.삭제 5.ID로조회 6.이름으로조회 0.종료");
			System.out.print("입력>");
			selectNo = scanner.nextInt();
			// 전체 조회
			if (selectNo == 1) {
				for (Person p : getAllPerson()) {
					System.out.println(p);
				}
			// 입력
			}else if (selectNo == 2) {
				System.out.print("ID입력>"); int id = scanner.nextInt(); scanner.nextLine();
				System.out.print("이름입력>"); String name = scanner.nextLine();
				System.out.print("나이입력>"); int age = scanner.nextInt(); scanner.nextLine();
				System.out.print("번호입력>"); String phone = scanner.nextLine();
				inputPerson(id, name, age, phone);
			// 수정
			}else if (selectNo == 3) {
				System.out.print("변경할 데이터의 id를 입력하세요.>");
				Person p = getPersonById(scanner.nextInt());
				
				if (p == null) {
					System.out.println("없지롱");
					continue;
				}
				
				System.out.println("변경할 데이터를 선택하세요.");
				System.out.println("1.이름 2.나이 3.번호");
				int selectColumn = scanner.nextInt();
				scanner.nextLine();
				System.out.println("변경할 데이터의 내용을 입력하세요.");
				String updateContent = scanner.nextLine();
				
				switch(selectColumn) {
				case 1: p.setName(updateContent); break;
				case 2: p.setAge(Integer.parseInt(updateContent)); break;
				case 3: p.setPhone(updateContent); break;
				}
				updatePersonById(p);
			// 삭제	
			}else if (selectNo == 4) {
				System.out.print("삭제할 데이터의 id를 입력하세요.>");
				int delId = scanner.nextInt();
				deletePersonById(delId);
			// ID로 조회
			}else if (selectNo == 5) {
				System.out.print("ID입력>");
				int id = scanner.nextInt();
				Person p = getPersonById(id);
				if (p == null) {
					System.out.println("찾을 수 없습니다.");
				} else {
					System.out.println(p);
				}
			// 이름조회
			}else if(selectNo == 6) {
				System.out.print("조회할 이름을 입력>");
				String name = scanner.next();
				int a = 0;
				for (Person p : getAllPerson()) {
					if (p.getName().equals(name)) {
						System.out.println(p);
						a++;
					}
				}
				if (a==0) {
					System.out.println("조회된 데이터가 없습니다.");
				}
			}else if (selectNo == 0) {
				System.out.println("프로그램 종료");
			}
		} while (selectNo != 0);
		connectClose();
	}
}
