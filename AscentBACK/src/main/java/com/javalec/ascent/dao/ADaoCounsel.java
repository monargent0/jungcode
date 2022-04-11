package com.javalec.ascent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ascent.dto.ADtoC;

public class ADaoCounsel {
	
	DataSource dataSource;
	
	public ADaoCounsel() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/ascent");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	// 1대1 문의 게시판 불러오기
	
	public ArrayList<ADtoC> list(String userID){
		ArrayList<ADtoC> dtos = new ArrayList<ADtoC>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
			try {
				connection = dataSource.getConnection();
				String query ="select counselCode, counselType, counselTitle, counselContent, counselDate, c_ReplyCheck from counsel where user_userID = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, userID);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					int counselCode = resultSet.getInt("counselCode");
					String counselType = resultSet.getString("counselType");
					String counselTitle = resultSet.getString("counselTitle");
					String counselContent = resultSet.getString("counselContent");
					Timestamp counselDate = resultSet.getTimestamp("counselDate");
					String c_ReplyCheck = resultSet.getString("c_ReplyCheck");
					
					ADtoC dtoC = new ADtoC(counselCode, counselType, counselTitle, counselContent, counselDate, c_ReplyCheck);
					dtos.add(dtoC); 
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
			return dtos;
	}// List 불러오기
	
	// write
	public void write(String counselType, String counselTitle, String counselContent , String userID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into counsel (counselType, counselTitle, counselContent, counselDate, user_userID , c_ReplyCheck ) values (?,?,?,now(),? ,'미답변' )";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, counselType);
			preparedStatement.setString(2, counselTitle);
			preparedStatement.setString(3, counselContent);
			preparedStatement.setString(4, userID);
			
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

	}// Write
	
	public ADtoC detail(String AcounselCode) {
		
		ADtoC dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select * from counsel where counselCode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(AcounselCode));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int counselCode = resultSet.getInt("counselCode");
				String counselType = resultSet.getString("counselType");
				String counselTitle = resultSet.getString("counselTitle");
				String counselContent = resultSet.getString("counselContent");
				Timestamp counselDate = resultSet.getTimestamp("counselDate");
				String c_ReplyCheck = resultSet.getString("c_ReplyCheck");
				
				dto = new ADtoC(counselCode, counselType, counselTitle, counselContent, counselDate, c_ReplyCheck); 
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {	// finally :  이상이 있을 때나 없을 때나 무조건 finally 속으로 온다.
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;

	} // Detail 상세보기
	
	public void delete(int counselCode) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection(); // DB연결 끝
			String query = "delete from counsel where counselCode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, counselCode);
			
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
