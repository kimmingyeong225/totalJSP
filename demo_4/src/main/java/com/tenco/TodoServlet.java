package com.tenco;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
    public TodoServlet() {
        // TODO Auto-generated constructor stub
    }

    // get 요청 시 동작
	// 주소 설계 -http://localhost:8080/d4/todo-servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 요청 확인");
		
		Todo todo1 = new Todo();
		todo1.setId(100);
		todo1.setTitle("오늘은 JSON 리턴하기 연습");
		todo1.setCompleted(false);
		
		// Gson 
		
		response.setContentType("text/plain");
//		String strJson=" {\r\n"
//                + "    \"userId\": 1,\r\n"
//                + "    \"id\": 1,\r\n"
//                + "    \"title\": \"delectus aut autem\",\r\n"
//                + "    \"completed\": false\r\n"
//                + "  }";
        PrintWriter pw=response.getWriter();
        pw.print(todo1.toString());
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
