package com.javalec.bps.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bps.command.PCommand;
import com.javalec.bps.command.PDeleteCommand;
import com.javalec.bps.command.PListCommand;
import com.javalec.bps.command.PWriteCommand;

/**
 * Servlet implementation class PFontController
 */
@WebServlet("*.do")
public class PFontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PFontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);

	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String viewPage = null;
		PCommand command = null;
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String domain = uri.substring(conPath.length());
		
		switch(domain) {
		case("/list.do"): 
			command = new PListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
			break;
		case("/write_view.do"):
			viewPage = "write_view.jsp";
			break;
		case("/write.do"):
			command = new PWriteCommand();
			command.execute(request, response);
			viewPage = "list.do"; 
			break;
		case("/delete.do"):
			command = new PDeleteCommand();
		 	command.execute(request, response);
		 	viewPage = "list.do"; 
		 	break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
