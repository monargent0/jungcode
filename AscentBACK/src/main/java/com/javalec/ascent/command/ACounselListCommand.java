package com.javalec.ascent.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ascent.dao.ADaoCounsel;
import com.javalec.ascent.dto.ADtoC;

public class ACounselListCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userID");
		
		ADaoCounsel daoCounsel = new ADaoCounsel();
		ArrayList<ADtoC> dtos = daoCounsel.list(userId);
		request.setAttribute("list", dtos);
	}
}
