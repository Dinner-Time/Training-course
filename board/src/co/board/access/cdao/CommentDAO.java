package co.board.access.cdao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import co.board.access.BoardAccess;
import co.board.model.Board;
import co.board.util.DAO;

public class CommentDAO extends DAO implements BoardAccess{
	Scanner scanner = new Scanner(System.in);
	 
	PreparedStatement sqlExecution;
	ResultSet sqlResult;
	String sql;
	
	@Override
	public ArrayList<Board> getAllPosts() {
		ArrayList<Board> allPosts = new ArrayList<Board>();
		sql = "select b_id, b_title, b_writer from board";
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
		return board;
	}
	
	public ArrayList<Board> getComments(int id){
		ArrayList<Board> comments = new ArrayList<Board>();
		sql = "select b_id, b_writer, b_content from board where b_parent_id = ?";
		try {
			sqlExecution = getConnectUrl().prepareStatement(sql);
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

	public void insertPost(Board board) {
		sql = "insert into board (b_title, b_writer, b_content, b_parent_id) values (?,?,?,?)";
		try {
			sqlExecution = getConnectUrl().prepareStatement(sql);
			sqlExecution.setString(1, "none");
			sqlExecution.setString(2, board.getB_writer());
			sqlExecution.setString(3, board.getB_content());
			sqlExecution.setInt(4, board.getB_parent_id());
			if(sqlExecution.executeUpdate()==0) {
				System.out.println("조회된 댓글이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePost(int id, String content, String u_nick) {
		sql = "update board set b_content = ? where b_id = ? and b_parent_id is not null";
		try {
			sqlExecution = getConnectUrl().prepareStatement(sql);
			sqlExecution.setString(1, content);
			sqlExecution.setInt(2, id);
			sqlExecution.setString(3, u_nick);
			int result = sqlExecution.executeUpdate();
			if (result == 0) {
				System.out.println("댓글을 수정할 수 없습니다.");
			} else {
				System.out.println("수정완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletPost(int id, String u_nick ) {
		sql = "delete from board where b_id = ? and b_writer = ?";
		try {
			sqlExecution = getConnectUrl().prepareStatement(sql);
			sqlExecution.setInt(1, id);
			sqlExecution.setString(2, u_nick);
			int result = sqlExecution.executeUpdate();
			if (result == 0) {
				System.out.println("댓글을 삭제할 수 없습니다.");
			} else {
				System.out.println("삭제완료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
