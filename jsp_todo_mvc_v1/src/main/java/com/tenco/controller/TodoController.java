package com.tenco.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.tenco.model.TodoDAO;
import com.tenco.model.TodoDAOImpl;
import com.tenco.model.TodoDTO;
import com.tenco.model.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// .../mvc/todo/xxx
// 연결

@WebServlet("/todo/*")
public class TodoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TodoDAO todoDAO;

	public TodoController() {
		todoDAO = new TodoDAOImpl();
	}

	// http://localhost:8080/mvc/todo/todoform (권장 x)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("action : " + action);

		// 로그인한 사용자만 접근을 허용하도록 설계
		HttpSession session = request.getSession();
		UserDTO principal = (UserDTO) session.getAttribute("principal");

		// 인증검사
		if (principal == null) {
			// 로그인을 안한 상태
			response.sendRedirect("/mvc/user/signIn?message=invalid");
			return;
		}

		switch (action) {
		case "/todoform":
			todoFormPage(request, response);
			break;
		case "/list":
			todoListPage(request, response);
			break;

		case "/detail":
			todoDetailPage(request, response, principal.getId());
			break;

		

//		case "/update":
//			request.setAttribute("id", request.getParameter("id"));
//			request.getRequestDispatcher("/WEB-INF/views/todoUpdate.jsp").forward(request, response);
//			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}

	// http://localhost:8080/mvc/todo/detail?id=2
	// 상세보기 화면
	private void todoDetailPage(HttpServletRequest request, HttpServletResponse response, int principalId)
			throws IOException {

		try {
			int todoId = Integer.parseInt(request.getParameter("id"));
			//
			TodoDTO dto = todoDAO.getTodoById(todoId);
			if (dto.getUserId() == principalId) {
				// 상세보기 화면으로 이동 처리
				request.setAttribute("todo", dto);
				request.getRequestDispatcher("/WEB-INF/views/todoDetail.jsp").forward(request, response);
			} else {
				// 권한이 없습니다 or 잘못된 접근입니다
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script> alert('권한이 없습니다'); history.back(); </script>");
			}

		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/todo/list?error=invalid");
		}

	}

	private void deleteTodo(HttpServletRequest request, HttpServletResponse response, int principalId)
			throws IOException {

		try {
			int todoId = Integer.parseInt(request.getParameter("id"));
			todoDAO.deleteTodo(todoId, principalId);
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/todo/list?error=invalid");
		}

		response.sendRedirect(request.getContextPath() + "/todo/list");
	}

	/*
	 * 화면
	 */
	private void todoDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDTO principal = (UserDTO) session.getAttribute("principal");

		int id = Integer.valueOf(request.getParameter("id"));
		request.setAttribute("detail", todoDAO.getTodoById(id));
		request.getRequestDispatcher("/WEB-INF/views/todoDetail.jsp").forward(request, response);

	}

	// http://localhost:8080/mvc/todo/list
	private void todoListPage(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// 인증 검사
		HttpSession session = request.getSession();
		UserDTO principal = (UserDTO) session.getAttribute("principal");
		// request.getContextPath();

		if (principal == null) {
			response.sendRedirect(request.getContextPath() + "/user/signIn?message=invalid");
			return;
		}

		// request.getPathInfo() --> URL 요청에 있어 데이터 추출
		// request.getParmeter() --> URL 요청에 있어 데이터 추출
		// request.getAttribute() --> 뷰를 내릴 속성에 값을 내려서 뷰로 내릴 때 사용

		// 데이터를 담아서 던질 예정 (DB 조회)
		List<TodoDTO> list = todoDAO.getTodosByUserId(principal.getId());
		request.setAttribute("list", list);

		// todoList.jsp 페이지로 내부에서 이동 처리
		request.getRequestDispatcher("/WEB-INF/views/todoList.jsp").forward(request, response);

	}

	private void todoFormPage(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.getRequestDispatcher("/WEB-INF/views/todoform.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO - 인증검사 추후 추가 처리
		HttpSession session = request.getSession();
		UserDTO principal = (UserDTO) session.getAttribute("principal");
		int principalId = principal.getId();
		
		if (principal == null) {
			response.sendRedirect(request.getContextPath() + "/user/signIn?error=invalid");
		}

		String action = request.getPathInfo();
		System.out.println("action : " + action);
		switch (action) {

		case "/add":
			// TODO - 수정예정
			addTodo(response, request, principal.getId());
			break;

	
		case "/update":
			updateTodo(response, request, principal.getId());
			break;
			
		case "/delete":
			deleteTodo(request, response, principal.getId());
			break;

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}

	}

	/*
	 * todo 수정 기능
	 * 
	 */
	private void updateTodo(HttpServletResponse response, HttpServletRequest request, int principalId)
			throws IOException {

		try {
			int todoId = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			String dueDate = request.getParameter("dueDate");
			boolean completed = "on".equalsIgnoreCase(request.getParameter("completed"));
			System.out.println("completed : " + completed);
			TodoDTO dto = TodoDTO.builder()
					.id(todoId)
					.userId(principalId)
					.title(title)
					.descrption(description)
					.dueDate(dueDate)
					.completed(String.valueOf(completed))
					.build();

			 todoDAO.updateTodo(dto, todoId);

			System.out.println("todoId : " + todoId);
		} catch (Exception e) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('잘못된 요청입니다'); history.back(); </script>");

		}
		// list 화면 재요청 처리
		response.sendRedirect(request.getContextPath() + "/todo/list");
	}

	/*
	 * 세션별 사용자 todo 등록
	 * 
	 * @param principalId : 세션에 담겨 있는 UserId 값
	 */
	private void addTodo(HttpServletResponse response, HttpServletRequest request, int principalId) throws IOException {
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String dueDate = request.getParameter("dueDate");

		// checkBox는 여러개의 선택 가능한 태그 : String[] 배열로 선언했음.
		// 이번 checkBox는 딱 하나만 사용 중.
		// checkBox가 선택되지 않았으면 null을 반환하고, 체크되어 있다면 on으로 떨어진다.

		boolean completed = "on".equalsIgnoreCase(request.getParameter("completed"));
		// completed -> true/false가 제대로 뜰까?

		// 테스트 코드 : System.out.println(completed);
		TodoDTO dto = TodoDTO.builder().userId(principalId).title(title).descrption(description).dueDate(dueDate)
				.completed(String.valueOf(completed)).build();

		System.out.println("------> " + dto.toString());
		todoDAO.addTodo(dto, principalId);
		response.sendRedirect(request.getContextPath() + "/todo/list");
	}

}
