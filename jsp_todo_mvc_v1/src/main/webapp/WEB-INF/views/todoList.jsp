<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tenco.model.TodoDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할 일 목록</title>
<link rel="stylesheet" type="text/css" href="../css/styles.css">
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 20px;
    }

    .container {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        max-width: 800px;
        margin: 20px auto;
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 10px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }

    .action-buttons {
        display: flex;
        justify-content: space-between;
        margin-bottom: 10px;
    }

    .action-buttons a, .action-buttons button {
        padding: 8px 12px;
        text-decoration: none;
        background-color: #007bff;
        color: #ffffff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        text-align: center;
        font-size: 14px;
    }

    .action-buttons a:hover, .action-buttons button:hover {
        background-color: #0056b3;
    }

    .no-todos {
        text-align: center;
        margin-top: 20px;
    }

    .complete-checkbox {
        margin-left: 10px;
    }

    .complete-label {
        display: flex;
        align-items: center;
    }

    .complete-label span {
        margin-left: 5px;
    }

    .delete-button {
        background-color: #DC143C; /* Crimson Red */
        border-radius: 20px;
    }

    .delete-button:hover {
        background-color: #ff5252; /* Lighter shade of red on hover */
    }

    .due-date {
        min-width: 120px; /* Ensure date column width is adequate */
    }
</style>
</head>
<body>
    <div class="container">
        <% List<TodoDTO> todoList = (List<TodoDTO>) request.getAttribute("list"); %>

        <h2>할 일 목록</h2>
        <div class="action-buttons">
            <a href="todoform">새 할 일 추가</a>
        </div>

        <% if (todoList != null && !todoList.isEmpty()) { %>
        <table>
            <thead>
                <tr>
                    <th>제목</th>
                    <th>설명</th>
                    <th>마감일</th>
                    <th>완료 여부</th>
                    <th>(액션-버튼)</th>
                </tr>
            </thead>
            <tbody>
                <% for (TodoDTO todo : todoList) { %>
                <tr>
                    <td><%= todo.getTitle() %></td>
                    <td><%=todo.getDescrption() %></td>
                    <td><%= todo.getDueDate() %></td>
                    <td>
                        <div class="complete-label">
                            <input type="checkbox" class="complete-checkbox" disabled <%= todo.completedToString().equals("true") ? "checked" : "" %>>
                            <span><%= todo.completedToString().equals("true") ? "완료" : "미완료" %></span>
                        </div>
                    </td>
                    <td class="action-buttons">
                        <a href="detail?id=<%= todo.getId() %>">상세보기</a>
                        <form action="delete" method="post">
                            <input type="hidden" name="id" value="<%= todo.getId() %>">
                            <button type="submit" class="delete-button" style="background-color: #DC143C"  >삭제</button>
                        </form>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <% } else { %>
        <hr>
        <p class="no-todos">등록된 할 일이 없습니다</p>
        <% } %>
    </div>
</body>
</html>
