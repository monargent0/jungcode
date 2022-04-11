package com.javalec.ascent.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ascent.dao.ADaoCounsel;
import com.javalec.ascent.dto.ADtoC;

public class ACounselDetailCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String counselCode = request.getParameter("counselCode");
		
		ADaoCounsel daoCounsel = new ADaoCounsel();
		ADtoC dtoC = new ADtoC();
		
		dtoC = daoCounsel.detail(counselCode);
		
		request.setAttribute("counselDetailV", dtoC);
	}
}
