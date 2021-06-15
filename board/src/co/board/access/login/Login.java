package co.board.access.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import co.board.model.Member;
import co.board.util.DAO;
import co.board.view.BoardApp;

public class Login extends DAO{
	
	Scanner scanner = new Scanner(System.in);
	
	PreparedStatement psmt;
	ResultSet rs;
	
	public Member login() {
		Member m = null;
		System.out.print("ID>");
		String u_id = scanner.next();
		System.out.print("PASSWORD>");
		String u_pass = scanner.next();
		
		String sql = "select * from member where u_id=? and u_pass=?";
		try {
			psmt = getConnectUrl().prepareStatement(sql);
			psmt.setString(1, u_id);
			psmt.setString(2, u_pass);
			rs = psmt.executeQuery();
			if(rs.isClosed()) {
				return null;
			}
			m = new Member();
			m.setU_id(rs.getString("u_id"));
			m.setU_pass(rs.getString("u_pass"));
			m.setU_nick(rs.getString("u_nick"));
			
			getConnectUrl().close();
			psmt.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return m;
	}

	public void loginSuccess() {
		Member user = login();
		if (user == null) {
			System.out.println("ID, PASSWORD를 확인하세요.");
		} else {
			BoardApp.start(user);
		}
	}
}
