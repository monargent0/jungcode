package com.javalec.ascent.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ascent.dao.ADaoU;
import com.javalec.ascent.dto.ADtoAD;

public class ALoginCommand implements ACommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		
		ADaoU daoU = new ADaoU();
		ArrayList<ADtoAD> dtoAD = daoU.login(userID, userPW);
		
			
		if(dtoAD.isEmpty()) {
			session.setAttribute("alertTxt", "일치하는 아이디가 없습니다." );
			request.setAttribute("viewPage", "logInV.jsp");	
		} else if ( dtoAD.get(0).getAdminCheck().toString().equals("admin")) {
			session.setAttribute("userID", dtoAD.get(0).getUserID().toString() );
			request.setAttribute("viewPage", "admin.jsp");			
		} else if ( dtoAD.get(0).getUserID() != null) {
			session.setAttribute("userID", dtoAD.get(0).getUserID().toString() );
			request.setAttribute("viewPage", "mainV.jsp");			
		} 

	}
}
