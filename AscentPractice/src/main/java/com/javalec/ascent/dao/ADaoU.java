package com.javalec.ascent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ascent.dto.ADtoAD;

public class ADaoU {
	DataSource dataSource;
	
	public ADaoU() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/ascent");
		}catch(Exception e) {
			e.printStackTrace();
		}
	} // constructor
	
	// userName userID userEmail userPhone userPW userBirth userGender u_SignDate
	
	// sign in
	public void signin(String userName,String userID,String userEmail,String userPhone,String userPW, String userBirth,String userGender) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection(); // DB연결 끝
			String query = "insert into userinfo (userName, userID, userEmail, userPhone, userPW, userBirth, userGender, u_SignDate, adminCheck) ";
			query += "values (?,?,?,?,?,?,?,now(),'0')";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, userID);
			preparedStatement.setString(3, userEmail);
			preparedStatement.setString(4, userPhone);
			preparedStatement.setString(5, userPW);
			preparedStatement.setString(6, userBirth);
			preparedStatement.setString(7, userGender);
			
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
		} // finally 메모리 정리 ;
		
	} // sign in

	// log in
	public ArrayList<ADtoAD> login(String userID, String userPW) {
		ArrayList<ADtoAD> dtoADs = new ArrayList<ADtoAD>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String id = null;
		String admin = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select userID, adminCheck from userinfo where userID = ? and userPW = ? and u_ResignDate is null";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userID);
			preparedStatement.setString(2, userPW);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				id = resultSet.getString("userID");
				admin = resultSet.getString("adminCheck");
				
				ADtoAD dtoAD = new ADtoAD(userID, admin);
				dtoADs.add(dtoAD);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
				try {
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
		} //finally
		return dtoADs;
	} // login 
	
	
	
}
