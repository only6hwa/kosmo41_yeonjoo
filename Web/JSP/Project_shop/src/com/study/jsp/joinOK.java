package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class joinOK implements Service {

	public joinOK() {
		
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("joinOK");
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		MemberDto dto = new MemberDto();
		
		HttpSession session = request.getSession();
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String eMail = request.getParameter("eMail");
		String address = request.getParameter("address");
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(eMail);
		System.out.println(address);
	
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.seteMail(eMail);
		dto.setAddress(address);
		dto.setrDate(new Timestamp(System.currentTimeMillis()));
		
		MemberDao dao = MemberDao.getInstance();
		
		System.out.println(dto.getId());
		System.out.println(dao.confirmId(dto.getId()));
		
		if(dao.confirmId(dto.getId()) == MemberDao.MEMBER_EXISTENT) {

			writer.println("<script language=\"javascript\" >"
					+ "alert(\"아이디가 이미 존재합니다.\");"
					+ "history.back();</script>");
			writer.close();
			
		} else {
			int ri = dao.insertMember(dto);
			if(ri == MemberDao.MEMBER_JOIN_SUCCESS) {
				session.setAttribute("id", dto.getId());
		
			writer.println("<script language=\"javascript\" >"
					+ "alert(\"회원가입을 축하합니다.\");"
					+ "document.location.href=\"login.jsp\";</script>");
			
			writer.close();
		} else {	
			
			writer.println("<script language=\"javascript\" >"
					+ "alert(\"회원가입에 실패했습니다.\");"
					+ "document.location.href=\"join.jsp\";</script>");
			writer.close();
			
			}
		}
	}
}
