package com.javalec.ascent.dto;

public class ADtoO {

	int orderCode;
	int orderNumber;
	int	orderSum;
	int	orderAmount;
	String orderDate;
	String orderReceiver;
	String orderPostcode;
	String orderMainAddress;
	String orderDetailAddress;
	String orderExtraAddress;
	String product_productCode;
	String user_userID;
	
	public ADtoO(int orderCode, int orderNumber, int orderSum, int orderAmount, String orderDate, String orderReceiver,
			String orderPostcode, String orderMainAddress, String orderDetailAddress, String orderExtraAddress,
			String product_productCode, String user_userID) {
		super();
		this.orderCode = orderCode;
		this.orderNumber = orderNumber;
		this.orderSum = orderSum;
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
		this.orderReceiver = orderReceiver;
		this.orderPostcode = orderPostcode;
		this.orderMainAddress = orderMainAddress;
		this.orderDetailAddress = orderDetailAddress;
		this.orderExtraAddress = orderExtraAddress;
		this.product_productCode = product_productCode;
		this.user_userID = user_userID;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getOrderSum() {
		return orderSum;
	}

	public void setOrderSum(int orderSum) {
		this.orderSum = orderSum;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderReceiver() {
		return orderReceiver;
	}

	public void setOrderReceiver(String orderReceiver) {
		this.orderReceiver = orderReceiver;
	}

	public String getOrderPostcode() {
		return orderPostcode;
	}

	public void setOrderPostcode(String orderPostcode) {
		this.orderPostcode = orderPostcode;
	}

	public String getOrderMainAddress() {
		return orderMainAddress;
	}

	public void setOrderMainAddress(String orderMainAddress) {
		this.orderMainAddress = orderMainAddress;
	}

	public String getOrderDetailAddress() {
		return orderDetailAddress;
	}

	public void setOrderDetailAddress(String orderDetailAddress) {
		this.orderDetailAddress = orderDetailAddress;
	}

	public String getOrderExtraAddress() {
		return orderExtraAddress;
	}

	public void setOrderExtraAddress(String orderExtraAddress) {
		this.orderExtraAddress = orderExtraAddress;
	}

	public String getProduct_productCode() {
		return product_productCode;
	}

	public void setProduct_productCode(String product_productCode) {
		this.product_productCode = product_productCode;
	}

	public String getUser_userID() {
		return user_userID;
	}

	public void setUser_userID(String user_userID) {
		this.user_userID = user_userID;
	}
	
	
}
