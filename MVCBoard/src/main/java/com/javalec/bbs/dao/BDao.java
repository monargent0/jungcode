package com.javalec.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.bbs.dto.BDto;

public class BDao {
	// 다오는 데이터베이스에서 정보를 가져오는 역할 
	// 데이터베이스 불러오는거는 전부 톰캣에 있다
	DataSource dataSource; // 톰캣에 설정한 대로 javax.sql로 선택해야한다.
	
	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc"); // context.xml와 연결 
		}catch(Exception e) {
			e.printStackTrace(); // 에러코드 보여주기
		}
	} // 생성자 
	
	// 입력ok
	public void write(String bName, String bTitle, String bContent) {
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				
				try {
					connection = dataSource.getConnection(); // DB연결 끝
					String query = "insert into mvc_board (bName, bTitle , bContent , bDate) values (?,?,?,now())";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, bName);
					preparedStatement.setString(2, bTitle);
					preparedStatement.setString(3, bContent);
					
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
	
	// 수정ok
	public void modify(int bId, String bName, String bTitle, String bContent) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection(); // DB연결 끝
			String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, bId);
			
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
	
	// 삭제ok
	public void delete(int bId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection(); // DB연결 끝
			String query = "delete from mvc_board where bId = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, bId);
			
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
	
	// 전체검색 - DTO등장
	public ArrayList<BDto> list(){
		// <> 제너릭 : 데이터
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection(); // DB연결 끝
			String query = "select bId, bName, bTitle , bContent ,bDate from mvc_board";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int bId = resultSet.getInt("bId"); // 컬럼이름으로 하면 순서가 상관 없다
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				// while문 안에서 변수 선언 했기 때문에 밖에서는 bId 등등이 뭔지 모른다.
				
				// 각 변수를 하나의 이름으로 보내기 위해 dto를 만들었다.
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate); // 각 컬럼 데이터 하나씩을 한줄로 포장
				dtos.add(dto);  // 한줄로 포장된 데이터들을 차곡차곡 쌓음
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
		return dtos;
	} // list
	
	// contentView 내용보기
	public BDto contentView(String sbId) {
		BDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection(); // DB연결 끝
			String query = "select * from mvc_board where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(sbId));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int bId = resultSet.getInt("bId"); // 컬럼이름으로 하면 순서가 상관 없다
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				
				// 각 변수를 하나의 이름으로 보내기 위해 dto를 만들었다.
				dto = new BDto(bId, bName, bTitle, bContent, bDate); // 각 컬럼 데이터 하나씩을 한줄로 포장
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
	
} // 클래스
