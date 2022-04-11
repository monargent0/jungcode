package com.javalec.ascent.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ascent.dao.ADaoU;

public class AFindPWCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userID = request.getParameter("userID");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		
		ADaoU dao = new ADaoU();
		String userPW = dao.findPW(userID, userName, userEmail);		
		request.setAttribute("userPW", userPW);

	}

}
