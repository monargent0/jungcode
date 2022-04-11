package com.javalec.ascent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ascent.dto.ADtoA;


public class ADaoUA {
	DataSource dataSource;
	
	public ADaoUA() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/ascent");
		}catch(Exception e) {
			e.printStackTrace();
		}
	} // constructor
	//addressCode addressType postcode mainAddress detailAddress extraAddress user_userID
	
	// 주소록 리스트
	public ArrayList<ADtoA> addresslist(String userID){
		ArrayList<ADtoA> dtoAs = new ArrayList<ADtoA>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
			try {
				connection = dataSource.getConnection();
				String query ="select addressCode, addressType, postcode, mainAddress, detailAddress, extraAddress, user_userID from address where user_userID = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, userID);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					int addressCode = resultSet.getInt("addressCode");
					String addressType = resultSet.getString("addressType");
					String postcode = resultSet.getString("postcode");
					String mainAddress = resultSet.getString("mainAddress");
					String detailAddress = resultSet.getString("detailAddress");
					String extraAddress = resultSet.getString("extraAddress");
					String user_userID = resultSet.getString("user_userID");
					
					ADtoA dtoA = new ADtoA(addressCode, addressType, postcode, mainAddress, detailAddress, extraAddress, user_userID);
					dtoAs.add(dtoA); 
			}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(resultSet != null) resultSet.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
			return dtoAs;
	}// 주소록 list
	
	// 주소록 추가
	// write
	public void addressWrite(String addressType, String postcode, String mainAddress , String detailAddress, String extraAddress, String user_userID ) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
			
		try {
			connection = dataSource.getConnection();
			String query = "insert into address (addressType, postcode, mainAddress, detailAddress, extraAddress, user_userID ) values (?,?,?,?,?,? )";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, addressType);
			preparedStatement.setString(2, postcode);
			preparedStatement.setString(3, mainAddress);
			preparedStatement.setString(4, detailAddress);
			preparedStatement.setString(5, extraAddress);
			preparedStatement.setString(6, user_userID);
				
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
	}// addressWrite
	
	// delete address 
	public void addressDelete(int addressCode) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection(); // DB연결 끝
			String query = "delete from address where addressCode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, addressCode);
			
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

	} // delete 삭제
	
}
