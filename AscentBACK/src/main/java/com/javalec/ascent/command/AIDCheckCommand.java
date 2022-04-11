package com.javalec.ascent.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ascent.dao.ADaoU;


public class AIDCheckCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String userID = request.getParameter("userID");
		
		ADaoU daoU = new ADaoU();
		
		if (daoU.doubleID(userID) == null) {
			session.setAttribute("idtxt", "Nodouble");
		}else if(daoU.doubleID(userID) != null) {
			session.setAttribute("idtxt", "Double");
		}
	}

}
