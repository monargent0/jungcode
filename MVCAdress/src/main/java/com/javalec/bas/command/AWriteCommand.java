package com.javalec.bas.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bas.dao.ADao;

public class AWriteCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aName = request.getParameter("aName");
		String aTel = request.getParameter("aTel");
		String aAddress = request.getParameter("aAddress"); 
		String aEmail = request.getParameter("aEmail");
		String aRelation = request.getParameter("aRelation");
		
		ADao dao = new ADao();
		dao.write(aName, aTel, aAddress, aEmail, aRelation);
		
	}

}
