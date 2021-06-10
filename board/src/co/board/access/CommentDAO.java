package co.board.access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import co.board.model.Board;
import co.board.util.DAO;

public class CommentDAO implements BoardAccess{
	DAO dao = new DAO();
	Scanner scanner = new Scanner(System.in);
	 
	PreparedStatement sqlExecution;
	ResultSet sqlResult;
	String sql;
	
	@Override
	public ArrayList<Board> getAllPosts() {
		ArrayList<Board> allPosts = new ArrayList<Board>();
		sql = "select b_id, b_title, b_writer from board";
		try {
			sqlExecution = dao.getConnectUrl().prepareStatement(sql);
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
		return board;
	}
	
	public ArrayList<Board> getComments(int id){
		ArrayList<Board> comments = new ArrayList<Board>();
		sql = "select b_id, b_writer, b_content from board where b_parent_id = ?";
		try {
			sqlExecution = dao.getConnectUrl().prepareStatement(sql);
			sqlExecution.setInt(1, id);
			sqlResult = sqlExecution.executeQuery();
			while (sqlResult.next()) {
				Board board = new Board();
				board.setB_id(sqlResult.getInt("b_id"));
				board.setB_writer(sqlResult.getString("b_writer"));
				board.setB_content(sqlResult.getString("b_content"));
				comments.add(board);
			}
			sqlResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comments;
	}

	@Override
	public void insertPost(Board board) {
		sql = "insert into board (b_title, b_writer, b_content, b_parent_id) values (?,?,?,?)";
		try {
			sqlExecution = dao.getConnectUrl().prepareStatement(sql);
			sqlExecution.setString(1, "none");
			sqlExecution.setString(2, board.getB_writer());
			sqlExecution.setString(3, board.getB_content());
			sqlExecution.setInt(4, board.getB_parent_id());
			sqlExecution.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePost(int id, String content) {
		sql = "update board set b_content = ? where b_id = ?";
		try {
			sqlExecution = dao.getConnectUrl().prepareStatement(sql);
			sqlExecution.setString(1, content);
			sqlExecution.setInt(2, id);
			int result = sqlExecution.executeUpdate();
			if (result == 0) {
				System.out.println("조회된 댓글이 없습니다.");
			} else {
				System.out.println("수정완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletPost(int id) {
		sql = "delete from board where b_id = ?";
		try {
			sqlExecution = dao.getConnectUrl().prepareStatement(sql);
			sqlExecution.setInt(1, id);
			int result = sqlExecution.executeUpdate();
			if (result == 0) {
				System.out.println("조회된 댓글이 없습니다.");
			} else {
				System.out.println("삭제완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
