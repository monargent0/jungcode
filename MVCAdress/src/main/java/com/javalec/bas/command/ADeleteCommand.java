package com.javalec.bas.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bas.dao.ADao;

public class ADeleteCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int aId = Integer.parseInt(request.getParameter("aId"));
		ADao dao = new ADao();
		dao.delete(aId);
	}

}
