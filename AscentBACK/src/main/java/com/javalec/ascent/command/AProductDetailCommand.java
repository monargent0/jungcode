package com.javalec.ascent.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ascent.dao.ADaoPAskReview;

public class AProductDetailCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("productCode");
		ADaoPAskReview dao = new ADaoPAskReview();
		request.setAttribute("detail", dao.productDetail(code));

	}

}
