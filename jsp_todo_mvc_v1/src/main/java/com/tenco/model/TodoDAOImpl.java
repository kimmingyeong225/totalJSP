package com.tenco.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TodoDAOImpl implements TodoDAO {

	private DataSource dataSource;

	public TodoDAOImpl() {

		InitialContext ctx;
		try {
			ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/MyDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void addTodo(TodoDTO dto, int principalId) {
		String sql = " insert into todos(user_id, title, description, due_date, completed) "
				+ " values (? , ? , ? , ? , ?) ";
		try (Connection conn = dataSource.getConnection()) {

			conn.setAutoCommit(false);

			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

				pstmt.setInt(1, principalId);
				pstmt.setString(2, dto.getTitle());
				pstmt.setString(3, dto.getDescrption());
				pstmt.setString(4, dto.getDueDate());
				pstmt.setInt(5, dto.getCompleted() == "true" ? 1 : 0);
				pstmt.executeUpdate();

				conn.commit();

			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// id 조회
	@Override
	public TodoDTO getTodoById(int id) {
		String sql = " select * from todos where id = ?";
		TodoDTO dto = null;

		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
			//pstmt.executeQuery();

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					dto = new TodoDTO();
					dto.setId(rs.getInt("id"));
					dto.setUserId(rs.getInt("user_id"));
					dto.setTitle(rs.getString("title"));
					dto.setDescrption(rs.getString("description"));
					dto.setDueDate(rs.getString("due_date"));
					dto.setCompleted(rs.getString("completed"));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	@Override
	// 아이디 출력
	public List<TodoDTO> getTodosByUserId(int userId) {
		String sql = " select * from todos where user_id = ? ";
		List<TodoDTO> list =new ArrayList<TodoDTO>();

		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(sql);


			pstmt.setInt(1, userId);
			
			//pstmt.executeQuery();
			
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					TodoDTO dto = new TodoDTO(); // 객체가 올라가야 됨
					dto = new TodoDTO();
					dto.setId(rs.getInt("id"));
					dto.setUserId(rs.getInt("user_id"));
					dto.setTitle(rs.getString("title"));
					dto.setDescrption(rs.getString("description"));
					dto.setDueDate(rs.getString("due_date"));
					dto.setCompleted(rs.getString("completed"));
					list.add(dto);
				}
				

			} catch (Exception e) {
			}

		} catch (Exception e) {
		}

		
		return list;
	}
	


	@Override
	// 모두 조회
	public List<TodoDTO> getAllTodos() {
		String sql = " select * from todos ";
		List<TodoDTO> list =new ArrayList<TodoDTO>();
		
		try (Connection conn = dataSource.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			

			try (ResultSet rs = pstmt.executeQuery()) {
				

				while (rs.next()) {

					TodoDTO dto = new TodoDTO();
					dto = new TodoDTO();
					dto.setId(rs.getInt("id"));
					dto.setUserId(rs.getInt("user_id"));
					dto.setTitle(rs.getString("title"));
					dto.setDescrption(rs.getString("description"));
					dto.setDueDate(rs.getString("due_date"));
					dto.setCompleted(rs.getString("completed"));
					list.add(dto);

				}

			} catch (Exception e) {
			}

		} catch (Exception e) {
		}
		return list;
	}

	@Override
	// 수정
	public void updateTodo(TodoDTO dto, int princiaplId) {
		 String sql = " update todos set title = ?, description = ? , due_date = ? , "
		 		+ " completed = ?  where id = ? and user_id = ? " ;
		try (Connection conn = dataSource.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, dto.getTitle());
				pstmt.setString(2, dto.getDescrption());
				pstmt.setString(3, dto.getDueDate());
				pstmt.setInt(4, dto.getCompleted() == "true" ? 1 : 0);
				pstmt.setInt(5, dto.getId());
				pstmt.setInt(6, dto.getUserId());
				
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteTodo(int id, int principalId) {
		String sql = " delete from todos where id = ? and user_id = ? ";
		

		try (Connection conn = dataSource.getConnection()) {
			conn.setAutoCommit(false);

			try (PreparedStatement pstmt = conn.prepareStatement(sql);) {

				pstmt.setInt(1, id);
				pstmt.setInt(2, principalId);
				pstmt.executeUpdate();

				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
