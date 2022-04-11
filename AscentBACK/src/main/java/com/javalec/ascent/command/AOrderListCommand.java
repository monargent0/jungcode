package com.javalec.ascent.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ascent.dao.ADaoOPCart;
import com.javalec.ascent.dto.ADtoOPCart;


public class AOrderListCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	
		String userID = request.getParameter("userID");
		ADaoOPCart dao = new ADaoOPCart();
		ArrayList<ADtoOPCart> dtos = dao.list(userID);
		request.setAttribute("orderList", dtos);
		
	}
}
