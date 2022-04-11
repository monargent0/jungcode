package com.javalec.ascent.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ascent.dao.ADaoU;

public class ASigninCommand implements ACommand {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String userID = request.getParameter("userID");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
		String userPW = request.getParameter("userPW");
		String userBirth = request.getParameter("userBirth");
		String userGender = request.getParameter("userGender");
		
		ADaoU daoU = new ADaoU();
		daoU.signin(userName, userID, userEmail, userPhone, userPW, userBirth, userGender);
	}
}
