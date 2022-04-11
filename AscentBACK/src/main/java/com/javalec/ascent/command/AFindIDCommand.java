package com.javalec.ascent.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ascent.dao.ADaoU;

public class AFindIDCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		
		ADaoU dao = new ADaoU();
		String userID = dao.findID(userName, userEmail);
		
		request.setAttribute("userID", userID);

	}

}
