package com.javalec.ascent.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ascent.dao.ADaoU;
import com.javalec.ascent.dto.ADtoAD;

public class ASignoutCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userID");
		String userPW = request.getParameter("userPW");
		
		System.out.println(userId);
		System.out.println(userPW);
		
		ADaoU daou = new ADaoU();
		ArrayList<ADtoAD> dtoI = daou.login(userId, userPW);
		System.out.println(dtoI.get(0));
		
//		if(dtoAD.isEmpty()) {
//			session.setAttribute("alertTxt", "비밀번호를 확인해주세요." );
//			request.setAttribute("viewPage", "signOutV.jsp");	
//		} else {
//			daoU.signout(loginId, userPW);			
//			request.setAttribute("viewPage", "signOutH.jsp");	
//		}
	}

}
