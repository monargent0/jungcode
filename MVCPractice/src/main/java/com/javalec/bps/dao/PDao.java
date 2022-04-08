package com.javalec.bps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bps.dto.PDto;

public class PDao {
	DataSource dataSource;
	
	public PDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oneline");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	} // 생성자
	
	// 전체검색 
	public ArrayList<PDto> list() {
		ArrayList<PDto> dtos = new ArrayList<PDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select pId, pName, pTitle, pDate from mvc_oneline";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int pId = resultSet.getInt("pId");
				String pName = resultSet.getString("pName");
				String pTitle = resultSet.getString("pTitle");
				Timestamp pDate = resultSet.getTimestamp("pDate");
				
				PDto dto = new PDto(pId, pName, pTitle, pDate);
				dtos.add(dto);
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
		return dtos;
	} // 전체검색list
	
	// write
	public void write(String pName, String pTitle) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection(); // DB연결 끝
			String query = "insert into mvc_oneline (pName, pTitle , pDate) values (?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pName);
			preparedStatement.setString(2, pTitle);
			
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
	} // write
	
	//delete
	public void delete(int pId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection(); // DB연결 끝
			String query = "delete from mvc_oneline where pId = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, pId);
			
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
	}//delete
	
	
}  // PDao class
