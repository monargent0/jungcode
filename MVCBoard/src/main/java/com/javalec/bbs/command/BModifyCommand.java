package com.javalec.bbs.command;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.dao.BDao;


public class BModifyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bId = Integer.parseInt(request.getParameter("bId"));
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		BDao dao = new BDao(); // BDao new 로 불러오면서 데이터베이스 연결 되었음 
		dao.modify(bId, bName, bTitle, bContent);
	}

}
