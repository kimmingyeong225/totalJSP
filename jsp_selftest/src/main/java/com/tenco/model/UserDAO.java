package com.tenco.model;

import java.util.List;

public interface UserDAO {

	// 회원가입
	int addUser(UserDTO userDTO);
	
	// 사용자 정보 조회 - id
	UserDTO getUserById(int id);
	// 사용자 정보 조회 - username
	UserDTO getUserByUsername(String username);
	// 사용자 전체 조회
	List<UserDTO> getAllUsers();
	
	// 등록
	int updateUser(UserDTO user, int principalId);
	// 삭제
	int deleteUser(int id);
}

