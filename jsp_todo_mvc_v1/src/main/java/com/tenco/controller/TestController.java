package com.tenco.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.tenco.model.TodoDAO;
import com.tenco.model.TodoDAOImpl;
import com.tenco.model.TodoDTO;
import com.tenco.model.UserDAO;
import com.tenco.model.UserDAOImpl;
import com.tenco.model.UserDTO;

@WebServlet("/test/*")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private TodoDAO todoDAO;

    public TestController() {
        super();
  
    }

    @Override
    public void init() throws ServletException {
    	userDAO = new UserDAOImpl();
    	todoDAO = new TodoDAOImpl();
    }
    
// http://localhost:8080/mvc/test/t1
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		
//		TodoDTO todoDTO = todoDAO.getTodoById(2);
//		System.out.println(todoDTO);
		//System.out.println(todoDTO.toString());
		
//		List<TodoDTO> list = todoDAO.getTodosByUserId(2);
//		System.out.println(list.toString());
		
//		List<TodoDTO> list = todoDAO.getAllTodos();
//		System.out.println(list.toString());
		
//		TodoDTO todoDTO = TodoDTO.builder().title("").descrption("").build();
//		todoDAO.updateTodo(todoDTO, 2);
		
		TodoDTO todoDTO = TodoDTO.builder().id(2).userId(1).build();
		todoDAO.deleteTodo(2, 1);
		System.out.println(todoDTO.toString());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
