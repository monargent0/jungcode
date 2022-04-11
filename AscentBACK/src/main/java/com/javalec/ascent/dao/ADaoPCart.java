package com.javalec.ascent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ascent.dto.ADtoPCart;

public class ADaoPCart {

	DataSource dataSource;

	public ADaoPCart() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/ascent");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ADtoPCart> list(String userID) {
		ArrayList<ADtoPCart> dtos = new ArrayList<ADtoPCart>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String queryA = "select c.cartCode, p.productCode, p.productImages, p.productName, p.productSize, c.cartAmount, p.productPrice ";
			String queryB = "from cart c, userinfo u, product p where c.user_userID = u.userID and c.product_productCode = p.productCode and u.userID = ?";
			preparedStatement = connection.prepareStatement(queryA+queryB);
			preparedStatement.setString(1, userID);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int cartCode = resultSet.getInt("cartCode");
				String productCode = resultSet.getString("productCode");
				String productImages = resultSet.getString("productImages");
				String productName = resultSet.getString("productName");
				String productSize = resultSet.getString("productSize");
				int cartAmount = resultSet.getInt("cartAmount");
				int productPrice = resultSet.getInt("productPrice");
				int cartSum = cartAmount*productPrice;
				
				ADtoPCart dto = new ADtoPCart(cartCode, productCode, productImages, productName, productSize, cartAmount, productPrice, cartSum);
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
}
