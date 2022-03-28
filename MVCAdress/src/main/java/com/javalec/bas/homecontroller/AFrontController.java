package com.javalec.bas.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bas.command.ACommand;
import com.javalec.bas.command.ADeleteCommand;
import com.javalec.bas.command.ADetailCommand;
import com.javalec.bas.command.AListCommand;
import com.javalec.bas.command.AModifyCommand;
import com.javalec.bas.command.AWriteCommand;

/**
 * Servlet implementation class AFrontController
 */
@WebServlet("*.do")
public class AFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String viewPage = null;
		ACommand command = null;
		String uri = request.getRequestURI();
		String comPath = request.getContextPath();
		String domain = uri.substring(comPath.length());
		
		switch (domain) {
		case ("/list.do"): 
			command = new AListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
			break;
		case ("/write_view.do"):
			viewPage = "write_view.jsp";
			break;
		case ("/write.do") :
			command = new AWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
			break;
		case("/detail_view.do"):
			command = new ADetailCommand();
			command.execute(request, response);
			viewPage = "detail_view.jsp";
			break;
		case("/modify.do"):
			command = new AModifyCommand() ;
			command.execute(request, response);
			viewPage = "list.do";
			break;
		case("/delete.do"):
			command= new ADeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
			break;
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
		
	
}
