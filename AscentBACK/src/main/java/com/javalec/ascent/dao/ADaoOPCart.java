package com.javalec.ascent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ascent.dto.ADtoOPCart;

public class ADaoOPCart {

	DataSource dataSource;
	public ADaoOPCart() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/ascent");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<ADtoOPCart> list(String userID) {
		ArrayList<ADtoOPCart> dtos = new ArrayList<ADtoOPCart>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String queryA = "select o.orderCode, o.orderNumber, o.orderDate, p.productImages, p.productName, p.productSize, p.productPrice, ";
			String queryB = "c.cartAmount, c.cartSum, o.cart_cartCode, o.product_productCode, o.user_userID from userinfo u, cart c, aorder o, product p ";
			String queryC = "where o.cart_cartCode = c.cartCode and o.product_productCode = p.productCode and o.user_userID = u.userID and u.userID = ?";
			preparedStatement = connection.prepareStatement(queryA+queryB+queryC);
			preparedStatement.setString(1, userID);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int orderCode = resultSet.getInt("orderCode");
				int orderNumber = resultSet.getInt("orderNumber");
				String orderDate = resultSet.getString("orderDate");
				String productImages = resultSet.getString("productImages");
				String productName = resultSet.getString("productName");
				String productSize = resultSet.getString("productSize");
				int productPrice = resultSet.getInt("productPrice");
				int	cartAmount = resultSet.getInt("cartAmount");
				int	cartSum = resultSet.getInt("cartSum");
				int cart_cartCode = resultSet.getInt("cart_cartCode");
				String product_productCode = resultSet.getString("product_productCode");
				String user_userID = resultSet.getString("user_userID");
				
				ADtoOPCart dto = new ADtoOPCart(orderCode, orderNumber, orderDate, productImages, productName, productSize, productPrice, cartAmount, cartSum, cart_cartCode, product_productCode, user_userID);
				dtos.add(dto);
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet != null)resultSet.close();
				if(preparedStatement != null)preparedStatement.close();
				if(connection != null)connection.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return dtos;
	}
	
	public ArrayList<ADtoOPCart> orderDetail(int orderNumber) {
		ADtoOPCart dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;	
		
		try {
			connection = dataSource.getConnection();
			String query = "select aorder, p.productImages, p.productName, p.productSize, p.productPrice, c.cartAmount, c.cartSum "
					+ "from aorder o, cart c, product p, userinfo u where o.user_userID = u.userID and o.product_productCode and orderNumber = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, orderNumber);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int orderCode = resultSet.getInt("orderCode");
				String orderDate = resultSet.getString("orderDate");
				String productImages = resultSet.getString("productImages");
				String productName = resultSet.getString("productName");
				String productSize = resultSet.getString("productSize");
				int productPrice = resultSet.getInt("productPrice");
				int cartAmount = resultSet.getInt("cartAmount");
				int cartSum = resultSet.getInt("cartSum");
				int cart_cartCode = resultSet.getInt("cart_cartCode");
				String product_productCode = resultSet.getString("product_productCode");
				String user_userID = resultSet.getString("user_userID");
				
				dto = new ADtoOPCart(orderCode, orderNumber, orderDate, productImages, productName, productSize, productPrice, cartAmount, cartSum, cart_cartCode, product_productCode, user_userID);
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} 
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} 
		}
		return dto;
	}
}
