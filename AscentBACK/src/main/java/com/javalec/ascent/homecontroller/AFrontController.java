package com.javalec.ascent.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ascent.command.AAddressDeleteCommand;
import com.javalec.ascent.command.AAddressLCommand;
import com.javalec.ascent.command.AAddressWriteCommand;
import com.javalec.ascent.command.ACartDeleteCommand;
import com.javalec.ascent.command.ACartListCommand;
import com.javalec.ascent.command.ACartModifyCommand;
import com.javalec.ascent.command.ACartWriteCommand;
import com.javalec.ascent.command.ACommand;
import com.javalec.ascent.command.ACounselDeleteCommand;
import com.javalec.ascent.command.ACounselDetailCommand;
import com.javalec.ascent.command.ACounselListCommand;
import com.javalec.ascent.command.ACounselWriteCommand;
import com.javalec.ascent.command.AFindIDCommand;
import com.javalec.ascent.command.AFindPWCommand;
import com.javalec.ascent.command.AIDCheckCommand;
import com.javalec.ascent.command.ALoginCommand;
import com.javalec.ascent.command.ANoticeBoardListCommand;
import com.javalec.ascent.command.AOrderDetailCommand;
import com.javalec.ascent.command.AOrderListCommand;
import com.javalec.ascent.command.AOrderWriteCommand;
import com.javalec.ascent.command.APayCommand;
import com.javalec.ascent.command.APpCommand;
import com.javalec.ascent.command.AProductAskWriteCommand;
import com.javalec.ascent.command.AProductDetailCommand;
import com.javalec.ascent.command.AProductListCommand;
import com.javalec.ascent.command.AProductSearchCommand;
import com.javalec.ascent.command.ARefundCommand;
import com.javalec.ascent.command.AReviewDeleteCommand;
import com.javalec.ascent.command.AReviewDetailCommand;
import com.javalec.ascent.command.AReviewListCommand;
import com.javalec.ascent.command.AReviewModifyCommand;
import com.javalec.ascent.command.AReviewWriteCommand;
import com.javalec.ascent.command.ASigninCommand;
import com.javalec.ascent.command.ASignoutCommand;
import com.javalec.ascent.command.AUserDetailCommand;
import com.javalec.ascent.command.AUserModifyCommand;
import com.javalec.ascent.command.AWishDeleteCommand;
import com.javalec.ascent.command.AWishListCommand;
import com.javalec.ascent.command.AWishWriteCommand;

/**
 * Servlet implementation class AFrontController
 */
@WebServlet("*.do")
public class AFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AFrontController() {

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

	public void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String viewPage = null;
		ACommand command = null;
		String uri = request.getRequestURI();
		String comPath = request.getContextPath();
		String domain = uri.substring(comPath.length());
		
		switch (domain) {
			//완성
			// main
			case("/main.do") :
				viewPage = "mainV.jsp";
				break;
			// signUp, 회원가입
			case("/signIn.do") :
				command = new ASigninCommand();
				command.execute(request, response);
				viewPage = "logInV.jsp";
				break;
			// logIn
			case ("/logIn.do"):
				command = new ALoginCommand();
				command.execute(request, response);
				viewPage = (String) request.getAttribute("viewPage");
				break;		
				// 로그인하면 메인, 실패하면 다시로그인, 관리자계정은 관리자사이트로
			// 아이디 찾기
			case("/findID.do") :
				command = new AFindIDCommand();
				command.execute(request, response);
				viewPage = "findIDRV.jsp";
				break;
			// 비밀번호 찾기
			case("/findPW.do") :
				command = new AFindPWCommand();
				command.execute(request, response);
				viewPage = "findPWRV.jsp";
				break;
			// userDetail, 개인정보 보기
			case("/userDetail.do"):
				command = new AUserDetailCommand();
				command.execute(request, response);
				viewPage = "userDetailV.jsp";
				break;
			// userModify, 개인정보 수정
			case("/userModify.do"):
				command = new AUserModifyCommand();
				command.execute(request, response);
				viewPage = "userDetail.do";
				break;
			// signOut, 회원탈퇴
			case("/signOut.do"):
				command = new ASignoutCommand();
				command.execute(request, response);
				viewPage = (String) request.getAttribute("viewPage");
				break;
			// userModify, 개인정보 수정
			case("/idDB.do"):
				command = new AIDCheckCommand();
				command.execute(request, response);
				viewPage = "doubleR.jsp";
				break;
			// address list
			case("/addressList.do"):
				command = new AAddressLCommand();
				command.execute(request, response);
				viewPage = "addressListV.jsp";
				break;
			// address write
			case("/addressWrite.do"):
				command = new AAddressWriteCommand();
				command.execute(request, response);
				viewPage = "addressList.do";
				break;
			// address delete
			case("/addressDelete.do"):
				command = new AAddressDeleteCommand();
				command.execute(request, response);
				viewPage = "addressList.do";
				break;
				
				
				
				
			// productList, 상품목록
//				
//			//floral
//			case("/sFList.do"):	
//				command = new ASflCommand() ;
//				command.execute(request, response);
//				viewPage = "sFLlist.jsp";
//				break;		
//			//citrus
//			case("/sCList.do"):	
//				command = new AScCommand() ;
//				command.execute(request, response);
//				viewPage = "sFLlist.jsp";
//				break;		
//			//Fresh
//			case("/sFRList.do"):	
//				command = new ASfrCommand() ;
//				command.execute(request, response);
//				viewPage = "sFLlist.jsp";
//				break;		
//			//Fruity
//			case("/sFTList.do"):	
//				command = new ASftCommand() ;
//				command.execute(request, response);
//				viewPage = "sFLlist.jsp";
//				break;		
//			//Woody
//			case("/sWList.do"):	
//				command = new ASwCommand() ;
//				command.execute(request, response);
//				viewPage = "sFLlist.jsp";
//				break;		
//			
//			//Oriental
//			case("/sOList.do"):	
//				command = new ASoCommand() ;
//				command.execute(request, response);
//				viewPage = "sFLlist.jsp";
//				break;	
				// 플로럴카테고리
						
			//Perfume
			case("/pPList.do"):	
				command = new APpCommand() ;
				command.execute(request, response);
				viewPage = "pPList.jsp";
				break;	
//			//toilette
//			case("/pTList.do"):	
//				command = new APtCommand() ;
//				command.execute(request, response);
//				viewPage = "pTList.jsp";
//				break;		
//			//cologne
//			case("/pCList.do"):	
//				command = new APcCommand() ;
//				command.execute(request, response);
//				viewPage = "pCList.jsp";
//				break;			
//			//bodyspray
//			case("/pBList.do"):	
//				command = new APbCommand() ;
//				command.execute(request, response);
//				viewPage = "pBList.jsp";
//				break;
//				
				// counselList, 1대1문의 조회
			case("/counselList.do") :
				command = new ACounselListCommand();
				command.execute(request, response);
				viewPage = "counselListV.jsp";
				break;
			// counselWrite, 1대1문의 작성
			case("/counselWrite.do"):
				command = new ACounselWriteCommand();
				command.execute(request, response);
				viewPage = "counselList.do";
				break;
			// counselDetail, 1대1문의 상세
			case("/counselDetail.do"):
				command = new ACounselDetailCommand();
				command.execute(request, response);
				viewPage = "counselDetailV.jsp";
				break;
			// counselDelete, 1대1문의 삭제
			case("/counselDelete.do"):
				command = new ACounselDeleteCommand();
				command.execute(request, response);
				viewPage = "counselList.do";
				break;
			// 미완성	
			// orderList, 주문내역
			case("/orderList.do"):
				command = new AOrderListCommand();
				command.execute(request, response);
				viewPage = "orderListV.jsp";
				break;	
			// orderDetail, 주문상세 보기
			case("/orderDetail.do"):
				command = new AOrderDetailCommand();
				command.execute(request, response);
				viewPage = "orderDetailV.jsp";
				break;
//			// refund, 환불
//			case("/refund.do"):
//				command = new ARefundCommand();
//				command.execute(request, response);
//				viewPage = "orderList.do";
//				break;
//			// reviewList, 리뷰 보기
//			case("/reviewList.do"):
//				command = new AReviewListCommand();
//				command.execute(request, response);
//				viewPage = "reviewListV.jsp";
//				break;
//			// reviewWrite, 리뷰 쓰기
//			case("/reviewWrite.do"):
//				command = new AReviewWriteCommand();
//				command.execute(request, response);
//				viewPage = "reviewList.do";
//				break;
//			// reviewDetail, 리뷰 상세
//			case("/reviewDetail.do"):
//				command = new AReviewDetailCommand();
//				command.execute(request, response);
//				viewPage = "reviewDetailV.jsp";
//				break;
//			// reviewModify, 리뷰 수정
//			case("/reviewModify.do"):
//				command = new AReviewModifyCommand();
//				command.execute(request, response);
//				viewPage = "reviewList.do";
//				break;
//			// reviewDelete, 리뷰 삭제
//			case("/reviewDelete.do"):
//				command = new AReviewDeleteCommand();
//				command.execute(request, response);
//				viewPage = "reviewList.do";
//				break;
//			// wishList, 찜 보기
//			case("/wishList.do"):
//				command = new AWishListCommand();
//				command.execute(request, response);
//				viewPage = "productList.do";
//				break;
//			// wishWrite, 찜 하기
//			case("/wishWrite.do"):
//				command = new AWishWriteCommand();
//				command.execute(request, response);
//				break;
//			// wishDelete, 찜 삭제
//			case("/wishDelete.do"):
//				command = new AWishDeleteCommand();
//				command.execute(request, response);
//				break;
//				
//				
//			// categoryList, 카테고리
//			case("/categoryList.do"):
//				command = new ACategoryListCommand();
//				command.execute(request, response);
//				viewPage = "productList.do";
//				break;
//				
//			// productList, 상품목록
//			case("/productList.do"):
//				command = new AProductListCommand();
//				command.execute(request, response);
//				viewPage = "productListV.jsp";
//				break;
//			// productSearch, 상품검색
//			case("/productSearch.do"):
//				command = new AProductSearchCommand();
//				command.execute(request, response);
//				viewPage = "productList.do";
//				break;
//				
			// productDetail, 상품상세
			case("/productDetail.do"):
				command = new AProductDetailCommand();
				command.execute(request, response);
				viewPage = "productDetailV.jsp";
				break;
//			// productAskWrite, 상품문의 작성
//			case("/productAskWrite.do"):
//				command = new AProductAskWriteCommand();
//				command.execute(request, response);
//				viewPage = "productDetail.do";
//				break;
//			
			// cartWrite, 장바구니 담기
			case("/cartWrite.do"):
				command = new ACartWriteCommand();
				command.execute(request, response);
				break;
			// cartList, 장바구니 보기
			case("/cartList.do"):
				command = new ACartListCommand();
				command.execute(request, response);
				viewPage = "cartListV.jsp";
				break;
			// cartDelete, 장바구니 선택삭제
			case("/cartDelete.do"):
				command = new ACartDeleteCommand();
				command.execute(request, response);
				viewPage = "cartList.do";
				break;
			//cartModify, 장바구니 수량수정	
			case("/cartModify.do"):
				command = new ACartModifyCommand();
				command.execute(request, response);
				viewPage = "cartList.do";
				break;
				
			// orderWrite, 주문하기
			case("/orderWrite.do"):
				command = new AOrderWriteCommand();
				command.execute(request, response);
				viewPage = "order";
				break;
//				
			// noticeBoardList, 공지사항 목록
			case("/noticeBoardList.do"):
				command = new ANoticeBoardListCommand();
				command.execute(request, response);
				viewPage = "noticeBoardListV.jsp";
				break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
