package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginOK implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
	
		System.out.println("loginOK");
		request.setCharacterEncoding("UTF-8"); 
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		MDao mdao = MDao.getInstance();
		int checkNum = mdao.userCheck(id, pw);
		
		if(checkNum == -1) {
		
			writer.println("<script language=\"javascript\" >"
					+ "alert(\"아이디가 존재하지 않습니다.\");"
					+ "history.go(-1); </script>");
			writer.close();		
		
		} else if(checkNum == 0) {
			
			writer.println("<script language=\"javascript\" >"
					+ "alert(\"패스워드가 틀립니다.\");"
					+ "history.go(-1); </script>");
			writer.close();
			
		} else if(checkNum == 1) {		
			MDto mdto = mdao.getMember(id);
					  
			if(mdto == null) {
				
				writer.println("<script language=\"javascript\" >"
						+ "alert(\"존재하지 않는 회원입니다.\");"
						+ "history.go(-1); </script>");
				writer.close();
				
			} else {
				String name = mdto.getName();
				
				HttpSession session = request.getSession();
				
				session.setAttribute("id", id);
				session.setAttribute("name", name);
				session.setAttribute("ValidMem", "yes");
				response.sendRedirect("main.jsp");
			}
				
		}

	}

}
