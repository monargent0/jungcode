package com.javalec.ascent.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ascent.dao.ADaoUA;

public class AAddressDeleteCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int addressCode = Integer.parseInt(request.getParameter("addressCode"));
		ADaoUA daoUA = new ADaoUA();
		daoUA.addressDelete(addressCode);

	}

}
