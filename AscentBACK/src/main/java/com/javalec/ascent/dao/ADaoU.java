package com.javalec.ascent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ascent.dto.ADtoAD;
import com.javalec.ascent.dto.ADtoU;

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
	
	// sign out
	public void signout(String userID, String userPW) {
				
		Connection connection = null;
		PreparedStatement preparedStatement = null;
				
		try {
			//DB연결메서드 불러오기
			connection = dataSource.getConnection(); 
			//pstmt 생성
			String query = "update userinfo set u_ResignDate = now() where userID = ? and userPW = ?" ;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userID);
			preparedStatement.setString(2, userPW);
			//실행 
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
				try {
					if(preparedStatement !=null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
		}
	}//sign out
	
	// find ID
		public String findID(String userName, String userEmail) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			String id = null;
			
			try {
				connection = dataSource.getConnection();
				String query = "select userID from userinfo where userName = ? and userEmail = ? and u_ResignDate is null";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, userName);
				preparedStatement.setString(2, userEmail);
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					id = resultSet.getString("userID");
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
			return id;
		} // findID
	
		// find PW
		public String findPW(String userID ,String userName, String userEmail) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			String pw = null;
			
			try {
				connection = dataSource.getConnection();
				String query = "select userPW from userinfo where userID =? and userName = ? and userEmail = ? and u_ResignDate is null";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, userID);
				preparedStatement.setString(2, userName);
				preparedStatement.setString(3, userEmail);
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					pw = resultSet.getString("userPW");
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
			return pw;
		} // find PW
		
		// user info
		public ADtoU userinfo(String userID) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			ADtoU dto = null;
			
			try {
				connection = dataSource.getConnection();
				String query = "select userName, userGender, userBirth, userPhone, userEmail from userinfo where userID =? and u_ResignDate is null";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, userID);
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					String userName = resultSet.getString("userName");
					String userGender  = resultSet.getString("userGender");
					String userBirth  = resultSet.getString("userBirth");
					String userPhone  = resultSet.getString("userPhone");
					String userEmail  = resultSet.getString("userEmail");
					
					dto = new ADtoU(userName, userGender, userBirth, userPhone, userEmail);
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
			return dto;
		} // user info
		
		// user info modify
		public void modifyUser(String userName, String userEmail, String userPhone, String userID) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				//DB연결메서드 불러오기
				connection = dataSource.getConnection(); 
				//pstmt 생성
				String query = "update userinfo set userName = ?, userEmail = ?, userPhone = ? where userID = ?" ;
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, userName);
				preparedStatement.setString(2, userEmail);
				preparedStatement.setString(3, userPhone);
				preparedStatement.setString(4, userID);
				//실행 
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally { 
					try {
						if(preparedStatement !=null) preparedStatement.close();
						if(connection != null) connection.close();
					}catch (Exception e) {
						e.printStackTrace();
					}
			}
		} // info modify

		// 중복체크
		public String doubleID(String userID) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			String id = null;
			
			try {
				connection = dataSource.getConnection();
				String query = "select userID from userinfo where userID = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, userID);
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					id = resultSet.getString("userID");
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
			return id;
		} // doubleID
}
