package com.javalec.bps.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bps.dao.PDao;

public class PWriteCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pName = request.getParameter("pName");
		String pTitle = request.getParameter("pTitle");
		
		PDao dao = new PDao();
		dao.write(pName, pTitle);

	}

}
