package com.javalec.ascent.dto;

public class ADtoCart {

	int cartCode;
	int cartAmount;
	String cartDate;
	String product_productCode;
	String user_userID;
	
	public ADtoCart(int cartCode, int cartAmount, String cartDate, String product_productCode, String user_userID) {
		super();
		this.cartCode = cartCode;
		this.cartAmount = cartAmount;
		this.cartDate = cartDate;
		this.product_productCode = product_productCode;
		this.user_userID = user_userID;
	}

	public int getCartCode() {
		return cartCode;
	}

	public void setCartCode(int cartCode) {
		this.cartCode = cartCode;
	}

	public int getCartAmount() {
		return cartAmount;
	}

	public void setCartAmount(int cartAmount) {
		this.cartAmount = cartAmount;
	}

	public String getCartDate() {
		return cartDate;
	}

	public void setCartDate(String cartDate) {
		this.cartDate = cartDate;
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
