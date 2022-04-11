package com.javalec.ascent.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ascent.dao.ADaoUA;

public class AAddressWriteCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userID");
		String addressType = request.getParameter("addressType");
		String postcode = request.getParameter("postcode");
		String mainAddress = request.getParameter("mainAddress");
		String detailAddress = request.getParameter("detailAddress");
		String extraAddress = request.getParameter("extraAddress");
		
		ADaoUA daoUA = new ADaoUA();
		daoUA.addressWrite(addressType, postcode, mainAddress, detailAddress, extraAddress, userId);
		

	}

}
