package com.javalec.ascent.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ascent.dao.ADaoCart;

public class ACartModifyCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int cartAmount = Integer.parseInt(request.getParameter("cartAmount"));
		int cartCode = Integer.parseInt(request.getParameter("cartCode"));
		
		ADaoCart dao = new ADaoCart();
		dao.modify(cartAmount, cartCode);;
	}
}
