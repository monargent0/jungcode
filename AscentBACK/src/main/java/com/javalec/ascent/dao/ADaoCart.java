package com.javalec.ascent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ADaoCart {

	DataSource dataSource;
	
	public ADaoCart() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/ascent");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void write(int cartAmount, String product_productCode, String user_userID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
			
		try {
			connection = dataSource.getConnection();
			String queryA = "insert into cart (cartAmount, cartDate, product_productCode, user_userID) ";
			String queryB = "values (?, now(), ?, ?)";
			preparedStatement = connection.prepareStatement(queryA+queryB);
			preparedStatement.setInt(1, cartAmount);
			preparedStatement.setString(2, product_productCode);
			preparedStatement.setString(3, user_userID);
			
			preparedStatement.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		// source가 분리되어 있기 때문에, 정리를 해줘야한다. 문제가 있든 없든 불러오기
		finally {
			try {
				// 각 data가 없을때..? 
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// delete
		public void delete(int cartCode) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

				try {
					connection = dataSource.getConnection(); // DB연결 끝
					String query = "delete from cart where cartCode = ?";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, cartCode);
					
					preparedStatement.executeUpdate();
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(preparedStatement != null) preparedStatement.close();
						if(connection != null) connection.close();
					}catch (Exception e) {
						e.printStackTrace();
					}
				}// finally 메모리 정리 ; 이상 있거나 없거나 무조건 거친다.
		} // delete
		
		public void modify(int cartAmount, int cartCode) {
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = dataSource.getConnection();
				String query = "update cart set cartAmount = ?, cartDate = now() where cartCode = ?;";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, cartAmount);
				preparedStatement.setInt(2, cartCode);
				
				preparedStatement.executeUpdate();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			// source가 분리되어 있기 때문에, 정리를 해줘야한다. 문제가 있든 없든 불러오기
			finally {
				try {
					// 각 data가 없을때..? 
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
}