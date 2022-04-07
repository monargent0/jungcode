package com.javalec.ascent.homcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ascent.command.ACommand;
import com.javalec.ascent.command.AFindIDCommand;
import com.javalec.ascent.command.AFindPWCommand;
import com.javalec.ascent.command.ALoginCommand;
import com.javalec.ascent.command.ASignoutCommand;
import com.javalec.ascent.command.ASinginCommand;
import com.javalec.ascent.command.AUserDetailCommand;

/**
 * Servlet implementation class AFrontController
 */
@WebServlet("*.do")
public class AFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AFrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}
	
	public void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String viewPage = null;
		ACommand command = null;
		String uri = request.getRequestURI();
		String comPath = request.getContextPath();
		String domain = uri.substring(comPath.length());
		
		switch (domain) {
			// sign in
			case("/signin.do") :
				command = new ASinginCommand();
				command.execute(request, response);
				viewPage = "loginV.jsp";
				break;
			// log in
			case("/login.do"):
				command = new ALoginCommand();
				command.execute(request, response);
				viewPage = (String) request.getAttribute("viewPage");
				break;
			// sign out
			case("/signOut.do") :
				command = new ASignoutCommand();
				command.execute(request, response);
				viewPage = (String) request.getAttribute("viewPage");
				break;
			// id 찾기
			case("/findID.do") :
				command = new AFindIDCommand();
				command.execute(request, response);
				viewPage = "findIDRV.jsp";
				break;
			// pw 찾기
			case("/findPW.do") :
				command = new AFindPWCommand();
				command.execute(request, response);
				viewPage = "findPWRV.jsp";
				break;
			// 개인정보 view
			case("userDetail.do"):
				command = new AUserDetailCommand();
				command.execute(request, response);
				viewPage = "userDetailV.jsp";
				break;
			
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
