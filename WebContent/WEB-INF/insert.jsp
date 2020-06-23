<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "com.javaex.dao.PhoneDao" %>
<%@ page import = "com.javaex.vo.PersonVo" %>

<%
	request.setCharacterEncoding("UTF-8");


	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String company = request.getParameter("company");
	PersonVo personVo = new PersonVo(name, hp, company);

	PhoneDao phoneDao = new PhoneDao();	
	phoneDao.personInsert(personVo);

	response.sendRedirect("./list.jsp");
	//Redirect --> 웹서버가 브라우저에게 지정한 페이지로 이동하도록 지시합니다.
 	// 강제로 이동하도록 명령.

	
%>    
    