
package com.javalec.ascent.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ascent.dao.ADaoO;


public class AOrderWriteCommand implements ACommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			String userID = request.getParameter("userID");
			int cartCode = Integer.parseInt(request.getParameter("cartCode"));
			String productCode = request.getParameter("productCode");
			int orderSum = Integer.parseInt(request.getParameter("orderSum"));
			int orderAmount = Integer.parseInt(request.getParameter("orderAmount"));
			String orderReceiver = request.getParameter("orderReceiver");
			String orderPostcode = request.getParameter("orderPostcode");
			String orderMainAddress = request.getParameter("orderMainAddress");
			String orderDetailAddress = request.getParameter("orderDetailAddress");
			String orderExtraAddress = request.getParameter("orderExtraAddress");
			
			ADaoO dao = new ADaoO();
			dao.write(userID, cartCode, productCode, orderSum, orderAmount, orderReceiver, orderPostcode, orderMainAddress, orderDetailAddress, orderExtraAddress);
	}
	
	

}
