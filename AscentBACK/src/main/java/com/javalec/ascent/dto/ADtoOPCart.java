package com.javalec.ascent.dto;

public class ADtoOPCart {

	int orderCode;
	int orderNumber;
	String orderDate;
	String productImages;
	String productName;
	String productSize;
	int productPrice;
	int	cartAmount;
	int	cartSum;
	int cart_cartCode;
	String product_productCode;
	String user_userID;
	
	public ADtoOPCart(int orderCode, int orderNumber, String orderDate, String productImages, String productName,
			String productSize, int productPrice, int cartAmount, int cartSum, int cart_cartCode,
			String product_productCode, String user_userID) {
		super();
		this.orderCode = orderCode;
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.productImages = productImages;
		this.productName = productName;
		this.productSize = productSize;
		this.productPrice = productPrice;
		this.cartAmount = cartAmount;
		this.cartSum = cartSum;
		this.cart_cartCode = cart_cartCode;
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

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getProductImages() {
		return productImages;
	}

	public void setProductImages(String productImages) {
		this.productImages = productImages;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getCartAmount() {
		return cartAmount;
	}

	public void setCartAmount(int cartAmount) {
		this.cartAmount = cartAmount;
	}

	public int getCartSum() {
		return cartSum;
	}

	public void setCartSum(int cartSum) {
		this.cartSum = cartSum;
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

	public int getCart_cartCode() {
		return cart_cartCode;
	}

	public void setCart_cartCode(int cart_cartCode) {
		this.cart_cartCode = cart_cartCode;
	}
	
}
