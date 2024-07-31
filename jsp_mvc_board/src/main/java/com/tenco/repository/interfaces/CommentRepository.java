package com.tenco.repository.interfaces;

import java.util.List;

import com.tenco.model.Comment;

public interface CommentRepository {

	void addComment(Comment comment);
	void deleteComment(int id);
	Comment getCommentById(int id);
	List<Comment> getCommentsByBoardId(int boardId);
	
	
}
