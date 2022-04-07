package com.javalec.ascent.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ascent.dao.ADaoU;
import com.javalec.ascent.dto.ADtoU;

public class AUserDetailCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userID");
		
		ADaoU daoU = new ADaoU();
		ADtoU dtoU = daoU.userinfo(userId);
		request.setAttribute("uinfo", dtoU);
	}

}
