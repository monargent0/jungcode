package com.javalec.ascent.dto;

public class ADtoPCart {

	int cartCode;
	String productCode;
	
	String productImages;
	String productName;
	String productSize;
	int cartAmount;
	int productPrice;
	int cartSum;


	public ADtoPCart(int cartCode, String productCode, String productImages, String productName, String productSize,
			int cartAmount, int productPrice, int cartSum) {
		super();
		this.cartCode = cartCode;
		this.productCode = productCode;
		this.productImages = productImages;
		this.productName = productName;
		this.productSize = productSize;
		this.cartAmount = cartAmount;
		this.productPrice = productPrice;
		this.cartSum = cartSum;
	}

	public int getCartCode() {
		return cartCode;
	}

	public void setCartCode(int cartCode) {
		this.cartCode = cartCode;
	}

	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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

	public int getCartAmount() {
		return cartAmount;
	}

	public void setCartAmount(int cartAmount) {
		this.cartAmount = cartAmount;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getCartSum() {
		return cartSum;
	}

	public void setCartSum(int cartSum) {
		this.cartSum = cartSum;
	}
	
}
