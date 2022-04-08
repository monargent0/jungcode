package com.javalec.bps.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bps.dao.PDao;
import com.javalec.bps.dto.PDto;

public class PListCommand implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PDao dao = new PDao();
		ArrayList<PDto> dtos = dao.list();
		request.setAttribute("list", dtos);

	}

}
