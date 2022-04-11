package com.javalec.ascent.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ascent.dao.ADaoUA;
import com.javalec.ascent.dto.ADtoA;

public class AAddressLCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userID");
		
		ADaoUA daoUA = new ADaoUA();
		ArrayList<ADtoA> dtoAs = daoUA.addresslist(userId);
		request.setAttribute("address", dtoAs);
	}

}
