package com.javalec.bps.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bps.dao.PDao;

public class PDeleteCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int pId = Integer.parseInt(request.getParameter("pId"));
		PDao dao = new PDao();
		dao.delete(pId);

	}

}
