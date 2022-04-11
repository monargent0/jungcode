package com.javalec.ascent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ascent.dto.ADtoN;

public class ADaoN {

DataSource dataSource;
	
	public ADaoN() {
		// TODO Auto-generated constructor stub
	} {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/ascent");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public ArrayList<ADtoN> list(){
		ArrayList<ADtoN> dtos = new ArrayList<ADtoN>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select noticeCode, noticeType, noticeTitle, noticeContent, noticeDate from noticeboard";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int noticeCode = resultSet.getInt("noticeCode");
				String noticeType = resultSet.getString("noticeType");
				String noticeTitle = resultSet.getString("noticeTitle");
				String noticeContent = resultSet.getString("noticeContent");
				Timestamp noticeDate = resultSet.getTimestamp("noticeDate");
				
				ADtoN dto = new ADtoN(noticeCode, noticeType, noticeTitle, noticeContent, noticeDate);
				dtos.add(dto); 
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
		return dtos;
		
		
	}	// 공지사항 list

}
