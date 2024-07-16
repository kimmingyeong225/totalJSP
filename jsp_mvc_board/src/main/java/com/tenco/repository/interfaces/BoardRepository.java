package com.tenco.repository.interfaces;

import java.util.List;

import com.tenco.model.Board;

public interface BoardRepository {
	// CRUD
	void addBoard(Board baord);
	void updateBoard(Board board, int principalId);
	void deleteBoard(int id, int principalId);
	Board getBoardById(int id);
	List<Board> getAllBoards(int limit, int offset);
	int getTotalBoardCount(); 
	
}
