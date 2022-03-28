package com.javalec.bas.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bas.dao.ADao;
import com.javalec.bas.dto.ADto;

public class ADetailCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aId = request.getParameter("aId");
		ADao dao = new ADao();
		ADto dto = dao.detailView(aId);
		
		request.setAttribute("detail_view", dto);
		
	}

}
