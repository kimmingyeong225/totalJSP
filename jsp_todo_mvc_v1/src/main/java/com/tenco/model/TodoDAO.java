package com.tenco.model;

import java.util.List;

public interface TodoDAO {
	
	// 저장 기능
	void addTodo(TodoDTO dto, int principalId);
	TodoDTO getTodoById(int id);
	// 사용자 아이디 기준으로 todoList
	List<TodoDTO> getTodosByUserId(int userId);
	// 모두 출력
	List<TodoDTO> getAllTodos();
	// 등록
	void updateTodo(TodoDTO dto, int princiaplId);
	// 삭제
	void deleteTodo(int id, int principalId);
	
}
