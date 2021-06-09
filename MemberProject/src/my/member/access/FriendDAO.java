package my.member.access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import my.member.model.Friends;
import my.member.util.DAO;

public class FriendDAO extends DAO implements FriendAccess{

	PreparedStatement sqlExecution;
	ResultSet sqlResult;
	String sql;
	
	public Map<String, String> getNameTel(){
		Map<String, String> nameTel = new HashMap<String, String>();
		sql = "select name, tel from freind";
		try {
			sqlExecution = getConnectUrl().prepareStatement(sql);
			sqlResult = sqlExecution.executeQuery();
			while (sqlResult.next()) {
				nameTel.put(sqlResult.getString("name"), 
						sqlResult.getString("tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nameTel;
	}
	
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void insert(Friends friend) {
		for (Friends f : selectAll()) {
			if(f.getName().equals(friend.getName())) {
				System.out.println("이미 추가되어있는 사람입니다.");
				 return;
			}
		}
		try {
			sql = "insert into freind values (?,?,?)";
			sqlExecution = getConnectUrl().prepareStatement(sql);
			sqlExecution.setString(1, friend.getSort());
			sqlExecution.setString(2, friend.getName());
			sqlExecution.setString(3, friend.getTel());
			int result = sqlExecution.executeUpdate();
			System.out.println(result + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Friends friend) {
		sql = "update freind set tel=? where name=?";
		try {
			sqlExecution = getConnectUrl().prepareStatement(sql);
			sqlExecution.setString(1, friend.getTel());
			sqlExecution.setString(2, friend.getName());
			int result = sqlExecution.executeUpdate();
			System.out.println(result +"건 수정");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String name) {
		sql = "delete from freind where name=?";
		try {
			sqlExecution = getConnectUrl().prepareStatement(sql);
			sqlExecution.setString(1, name);
			int result = sqlExecution.executeUpdate();
			System.out.println(result +"건 삭제");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Friends> selectAll() {
		ArrayList<Friends> fList = new ArrayList<>();
		sql = "select * from freind";
		try {
			sqlExecution = getConnectUrl().prepareStatement(sql);
			sqlResult = sqlExecution.executeQuery();
			while (sqlResult.next()) {
				Friends friend = 
						new Friends(sqlResult.getString("sort"),
									sqlResult.getString("name"),
									sqlResult.getString("tel"));
				fList.add(friend);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fList;
	}

	@Override
	public Friends selectOne(String name) {
		for (Friends f : selectAll()) {
			if(f.getName().equals(name)) {
				return f;
			}
		}
		return null;
	}

	@Override
	public Friends findTel(String tel) {
		for (Friends f : selectAll()) {
			if(f.getTel().equals(tel)) {
				return f;
			}
		}
		return null;
	}

}
