package co.board.access.bdao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.board.access.BoardAccess;
import co.board.model.Board;
import co.board.util.DAO;

public class BoardDAO extends DAO implements BoardAccess{
	
	PreparedStatement sqlExecution;
	ResultSet sqlResult;
	String sql;

	@Override
	public ArrayList<Board> getAllPosts() {
		ArrayList<Board> allPosts = new ArrayList<Board>();
		sql = "select b_id, b_title, b_writer from board where b_parent_id is null";
		try {
			sqlExecution = getConnectUrl().prepareStatement(sql);
			sqlResult = sqlExecution.executeQuery();
			while (sqlResult.next()) {
				Board board = new Board();
				board.setB_id(sqlResult.getInt("b_id"));
				board.setB_title(sqlResult.getString("b_title"));
				board.setB_writer(sqlResult.getString("b_writer"));
				allPosts.add(board);
			}
			sqlResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allPosts;
	}

	@Override
	public Board getPost(int id) {
		Board board = null;
		sql = "select * from board where b_id = ?";
		try {
			sqlExecution = getConnectUrl().prepareStatement(sql);
			sqlExecution.setInt(1, id);
			sqlResult = sqlExecution.executeQuery();
			board = new Board(
					sqlResult.getInt("b_id"),
					sqlResult.getString("b_title"),
					sqlResult.getString("b_writer"),
					sqlResult.getString("b_content")
					);
			sqlResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public void insertPost(Board board) {
		sql = "insert into board (b_title, b_writer, b_content) values (?,?,?)";
		try {
			sqlExecution = getConnectUrl().prepareStatement(sql);
			sqlExecution.setString(1, board.getB_title());
			sqlExecution.setString(2, board.getB_writer());
			sqlExecution.setString(3, board.getB_content());
			sqlExecution.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePost(int id, String content, String u_nick) {
		sql = "update board set b_content = ? where b_id = ? and b_writer = ?";
		try {
			sqlExecution = getConnectUrl().prepareStatement(sql);
			sqlExecution.setString(1, content);
			sqlExecution.setInt(2, id);
			sqlExecution.setString(3, u_nick);
			int result = sqlExecution.executeUpdate();
			if (result == 0) {
				System.out.println("글을 수정할 수 없습니다.");
			} else {
				System.out.println("수정완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletPost(int id, String u_nick) {
		sql = "delete from board where b_id = ? and b_writer = ?";
		try {
			sqlExecution = getConnectUrl().prepareStatement(sql);
			sqlExecution.setInt(1, id);
			sqlExecution.setString(2, u_nick);
			int result = sqlExecution.executeUpdate();
			if (result == 0) {
				System.out.println("글을 삭제할 수 없습니다.");
			} else {
				System.out.println("삭제완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
