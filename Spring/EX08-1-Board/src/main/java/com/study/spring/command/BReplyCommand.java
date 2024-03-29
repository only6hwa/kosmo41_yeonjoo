package com.study.spring.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.study.spring.dao.BDao;

public class BReplyCommand implements BCommand {

	public BReplyCommand() {
		
	}
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String bId = request.getParameter("bId");
		String bName=request.getParameter("bName");
		String bTitle=request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bGroup = request.getParameter("bGroup");
		String bStep = request.getParameter("bStep");
		String bIndent = request.getParameter("bIndent");
		
		
		System.out.println("bID"+bTitle);
		
		BDao dao = BDao.getInstance();
		dao.reply(bId,bName,bTitle,bContent,bGroup,bStep,bIndent);
	}

}
