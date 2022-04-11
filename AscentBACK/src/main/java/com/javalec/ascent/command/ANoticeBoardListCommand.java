package com.javalec.ascent.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ascent.dao.ADaoN;
import com.javalec.ascent.dto.ADtoN;

public class ANoticeBoardListCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		ADaoN daoN = new ADaoN();
		ArrayList<ADtoN> dtos = daoN.list();
		request.setAttribute("list", dtos);
	}
}
