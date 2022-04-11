package com.javalec.ascent.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ascent.dao.ADaoCounsel;

public class ACounselDeleteCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int counselCode = Integer.parseInt(request.getParameter("counselCode"));
			
		ADaoCounsel daoCounsel = new ADaoCounsel();
		daoCounsel.delete(counselCode);
			
	}

}


