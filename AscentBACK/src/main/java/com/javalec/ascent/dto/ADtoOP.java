package com.javalec.ascent.dto;

public class ADtoOP {

	int orderCode;
	int orderNumber;
	int	orderSum;
	int	orderAmount;
	
	String productCode;
	String productName;
	int productPrice;
	String productSize;
	String productDetail;
	
	public ADtoOP(int orderCode, int orderNumber, int orderSum, int orderAmount, String productCode, String productName,
			int productPrice, String productSize, String productDetail) {
		super();
		this.orderCode = orderCode;
		this.orderNumber = orderNumber;
		this.orderSum = orderSum;
		this.orderAmount = orderAmount;
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productSize = productSize;
		this.productDetail = productDetail;
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


	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

}
