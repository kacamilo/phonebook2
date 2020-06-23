package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.PersonVo;


@WebServlet("/pbc")
public class PhoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/pbc --> doGet()");
		
		String action = request.getParameter("action");
		
					//action.equals("list")
		if ("list".equals(action)) { //리스트일때
			System.out.println("list");
			
			PhoneDao dao = new PhoneDao();
			List<PersonVo> pList = dao.getPersonList();
			
			//request에 데이터 추가(Attribute)
			request.setAttribute("personList", pList);

			//forword 하는 방법
			WebUtil.forward(request, response, "/WEB-INF/list.jsp"); 
			
			
			
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
//			rd.forward(request, response);

		} else if ("wform".equals(action)) {
			System.out.println("주소록 등록폼");
			/*
			//forword 하는 방법
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/writeForm.jsp");
			rd.forward(request, response);
			*/
			
			WebUtil.forward(request, response, "/WEB-INF/writeForm.jsp"); 
		} else if ("insert".equals(action)) {
			System.out.println("번호 저장");
			
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			PersonVo vo = new PersonVo(name, hp, company);
			
			PhoneDao dao = new PhoneDao();
			dao.personInsert(vo);
			System.out.println("test");
			//리다이렉트
			WebUtil.redirect(request, response, "/pb2/pbc?action=list");
			/*
			response.sendRedirect("/pb2/pbc?action=list.jsp");
			*/
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
