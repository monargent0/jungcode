package com.javalec.bas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bas.dto.ADto;

public class ADao {
	DataSource dataSource;
	
	public ADao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvcaddress");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	} //Constructor
	
	// list
	public ArrayList<ADto> list() {
		ArrayList<ADto> dtos = new ArrayList<ADto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select * from addresstable";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int aId = resultSet.getInt("aId");
				String aName = resultSet.getString("aName");
				String aTel = resultSet.getString("aTel");
				String aAddress = resultSet.getString("aAddress"); 
				String aEmail = resultSet.getString("aEmail");
				String aRelation = resultSet.getString("aRelation");
				
				ADto dto = new ADto(aId, aName, aTel, aAddress, aEmail, aRelation);
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
		}
		return dtos;
	} // list
	
	// write
	public void write(String aName,String aTel,String aAddress,String aEmail,String aRelation) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection(); // DB연결 끝
			String query = "insert into addresstable (aName, aTel, aAddress, aEmail, aRelation) values (?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, aName);
			preparedStatement.setString(2, aTel);
			preparedStatement.setString(3, aAddress);
			preparedStatement.setString(4, aEmail);
			preparedStatement.setString(5, aRelation);
			
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
	} //write
	
	// modify
	public void modify(int aId, String aName,String aTel,String aAddress,String aEmail,String aRelation) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection(); // DB연결 끝
			String query = "update addresstable set aName = ?, aTel = ?, aAddress = ?, aEmail = ?, aRelation = ? where aId = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, aName);
			preparedStatement.setString(2, aTel);
			preparedStatement.setString(3, aAddress);
			preparedStatement.setString(4, aEmail);
			preparedStatement.setString(5, aRelation);
			preparedStatement.setInt(6, aId);
			
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
	} // modify
	
	// delete
	public void delete(int aId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection(); // DB연결 끝
			String query = "delete from addresstable where aId = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, aId);
			
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

	// detailview
		public ADto detailView(String detailaId) {
			ADto dto = null;
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = dataSource.getConnection(); // DB연결 끝
				String query = "select * from addresstable where aId = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, Integer.parseInt(detailaId));
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					int aId = resultSet.getInt("aId");
					String aName = resultSet.getString("aName");
					String aTel = resultSet.getString("aTel");
					String aAddress = resultSet.getString("aAddress"); 
					String aEmail = resultSet.getString("aEmail");
					String aRelation = resultSet.getString("aRelation");
					
					// 각 변수를 하나의 이름으로 보내기 위해 dto를 만들었다.
					dto = new ADto(aId, aName, aTel, aAddress, aEmail, aRelation); // 각 컬럼 데이터 하나씩을 한줄로 포장
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					
					if(resultSet != null) resultSet.close();
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}// finally 메모리 정리 ; 이상 있거나 없거나 무조건 거친다.
			return dto;
		} // contentView
	//
}
