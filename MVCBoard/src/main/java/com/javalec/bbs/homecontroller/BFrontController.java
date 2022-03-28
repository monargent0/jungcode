package com.javalec.bbs.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.bbs.command.BCommand;
import com.javalec.bbs.command.BContentCommand;
import com.javalec.bbs.command.BDeleteCommand;
import com.javalec.bbs.command.BListCommand;
import com.javalec.bbs.command.BModifyCommand;
import com.javalec.bbs.command.BWriteCommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do") //do로 끝나는것은 무조건 컨트롤러에 온다.
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request,response); // request, response를 넣어준다. post,get 상관없이 actionDo로 들어온다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request,response); // request, response를 넣어준다. post,get 상관없이 actionDo로 들어온다.
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 따라쟁이를 만드는 거라 void, ()뒤를 동일하게 써준다.
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8"); // 제일 처음 받는 컨트롤러가 한글처리를 해줘야 한다. 여기서부터 어그러지면 꺠진한글이 돌아다닌다.
		
		String viewPage = null;
		BCommand command = null; // BCommand command = new Bcommand() 중 앞부분만 작성
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		// abcd.do 만 자르기 
		// String replace = uri.replace(conPath, ""); // 문자열대체 
		String com = uri.substring(conPath.length()); // 부분문자열 *** 중요 자료정제에 큰 역할을 함  
		
//		System.out.println(uri); // /MVCBoard/abcd.do
//		System.out.println(conPath); // /MVCBoard
//		System.out.println(replace); // /abcd.do
//		System.out.println(com); // /abcd.do
		
		switch(com) {
		case("/list.do"): // 전체내용 보여주기
			command = new BListCommand(); // command = new Bcommand() 부분 작성. 따로 작성하는 이유는 Bcommand 뿐만 아니라 다른 클래스도 연결하기 위함 
			command.execute(request, response); // 클래스에서 작동하고 넘길것
			viewPage = "list.jsp"; // JSP에게 일 시키기 
			break;
		case("/write_view.do"): // DB 사용할 일이 없으면 command는 사용할 필요 없다.
			viewPage = "write_view.jsp";
			break;
		case("/write.do"):
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "list.do"; // 첫 화면 보여주기 list.jsp 로 가면 빈 화면만 나온다
			break;
		case("/content_view.do"):
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
			break;
		case("/modify.do"):
			command = new BModifyCommand();
			command.execute(request, response);
			viewPage = "list.do"; // 첫 화면 보여주기 list.jsp 로 가면 빈 화면만 나온다
			break;
		case("/delete.do"):
			command = new BDeleteCommand();
		 	command.execute(request, response);
		 	viewPage = "list.do"; // 첫 화면 보여주기 list.jsp 로 가면 빈 화면만 나온다
		 	break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // viewPage는 JSP이름
		dispatcher.forward(request, response);
	
	}

}
