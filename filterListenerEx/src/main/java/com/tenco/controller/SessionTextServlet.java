package com.tenco.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session-test")
public class SessionTextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SessionTextServlet() {
        super();
    }
    
	// 주소 설계 - http://localhost:8080/fl/session-test
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 새로운 세션을 생성해 보자
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print("당신에 세션 아이디는 : " + session.getId());
		
		// 세션 무효화 버튼
		response.getWriter().println("<form action='session-test' method='POST'>");
		response.getWriter().println("<button type='submit'>세션 종료(로그아웃)</button>");
		response.getWriter().println("</form>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 실행 확인()");
		HttpSession session = request.getSession(false); // 기존 세션을 반환, 없으면 null 반환
		if(session != null) {
			session.invalidate(); // 세션 무효화
		}
		response.sendRedirect("session-test"); // 페이지 새로 고침 
		// 새로운 request, response 객체가 새로 생성 됨
		// sendRedirect --> 클라이언트로 돌아감 (브라우저로 돌아감)
		//				-> get 방식으로 http://localhost:8080/fl/session-test 다시 요청
	}

}
