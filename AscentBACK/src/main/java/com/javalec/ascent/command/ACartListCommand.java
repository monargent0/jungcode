package com.javalec.ascent.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ascent.dao.ADaoPCart;
import com.javalec.ascent.dto.ADtoPCart;


public class ACartListCommand implements ACommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userID = request.getParameter("userID");
		
		ADaoPCart dao = new ADaoPCart();
		ArrayList<ADtoPCart> dtos = dao.list(userID);
		request.setAttribute("cartList", dtos);
	}
}
