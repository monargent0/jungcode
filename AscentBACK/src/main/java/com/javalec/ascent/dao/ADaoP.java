package com.javalec.ascent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ascent.dto.ADtoP;

public class ADaoP {

	DataSource dataSource;
	
	public ADaoP() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/ascent");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 향수종류 - 퍼퓸
	public ArrayList<ADtoP> appList() {
		ArrayList<ADtoP> dtoPs = new ArrayList<ADtoP>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String query1 = "select productCode,productName,productPrice,productSize,productImages,category_categoryCode from product where productCode like 'P-%'";
			ps = conn.prepareStatement(query1);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String productCode = rs.getString("productCode");
				String productName = rs.getString("productName");
				int productPrice = rs.getInt("productPrice");
				String productSize = rs.getString("productSize");
				String productImages = rs.getString("productImages");
				String category_categoryCode = rs.getString("category_categoryCode");
				
				ADtoP dtoP = new ADtoP(productCode, productName, productPrice, productSize, productImages, category_categoryCode);
				dtoPs.add(dtoP);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close(); //데이터가 있으면 close
				if(ps!=null) ps.close();
				if(conn!= null) conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtoPs;
		
	} // 향수종류 - 퍼퓸
	
	// toilette category
		public ArrayList<ADtoP> pTList() {
			ArrayList<ADtoP> dtoPs = new ArrayList<ADtoP>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				conn = dataSource.getConnection();
				String query1 = "select productCode,productName,productPrice,productSize,productImages,category_categoryCode from product where productCode like 'T-%'";
				ps = conn.prepareStatement(query1);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String productCode = rs.getString("productCode");
					String productName = rs.getString("productName");
					int productPrice = rs.getInt("productPrice");
					String productSize = rs.getString("productSize");
					String productImages = rs.getString("productImages");
					String category_categoryCode = rs.getString("category_categoryCode");
					
					ADtoP dtoP = new ADtoP(productCode, productName, productPrice, productSize, productImages, category_categoryCode);
					dtoPs.add(dtoP);
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close(); //데이터가 있으면 close
					if(ps!=null) ps.close();
					if(conn!= null) conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return dtoPs;
			
			
		}
		
		//cologne 
		public ArrayList<ADtoP> pCList() {
			ArrayList<ADtoP> dtoPs = new ArrayList<ADtoP>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				conn = dataSource.getConnection();
				String query1 = "select productCode,productName,productPrice,productSize,productImages,category_categoryCode from product where productCode like 'C-%'";
				ps = conn.prepareStatement(query1);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String productCode = rs.getString("productCode");
					String productName = rs.getString("productName");
					int productPrice = rs.getInt("productPrice");
					String productSize = rs.getString("productSize");
					String productImages = rs.getString("productImages");
					String category_categoryCode = rs.getString("category_categoryCode");
					
					ADtoP dtoP = new ADtoP(productCode, productName, productPrice, productSize, productImages, category_categoryCode);
					dtoPs.add(dtoP);
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close(); //데이터가 있으면 close
					if(ps!=null) ps.close();
					if(conn!= null) conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return dtoPs;
			
			
		}
		
		//bodyspray
		public ArrayList<ADtoP> pBList() {
			ArrayList<ADtoP> dtoPs = new ArrayList<ADtoP>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				conn = dataSource.getConnection();
				String query1 = "select productCode,productName,productPrice,productSize,productImages,category_categoryCode from product where productCode like 'B-%'";
				ps = conn.prepareStatement(query1);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String productCode = rs.getString("productCode");
					String productName = rs.getString("productName");
					int productPrice = rs.getInt("productPrice");
					String productSize = rs.getString("productSize");
					String productImages = rs.getString("productImages");
					String category_categoryCode = rs.getString("category_categoryCode");
					
					ADtoP dtoP = new ADtoP(productCode, productName, productPrice, productSize, productImages, category_categoryCode);
					dtoPs.add(dtoP);
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close(); //데이터가 있으면 close
					if(ps!=null) ps.close();
					if(conn!= null) conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return dtoPs;
			
			
		}
		
		//floral
		public ArrayList<ADtoP> sFList() {
			ArrayList<ADtoP> dtoPs = new ArrayList<ADtoP>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				conn = dataSource.getConnection();
				String query1 = "select productCode,productName,productPrice,productSize,productImages,category_categoryCode from product where productCode like '%-f-%'";
				ps = conn.prepareStatement(query1);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String productCode = rs.getString("productCode");
					String productName = rs.getString("productName");
					int productPrice = rs.getInt("productPrice");
					String productSize = rs.getString("productSize");
					String productImages = rs.getString("productImages");
					String category_categoryCode = rs.getString("category_categoryCode");
					
					ADtoP dtoP = new ADtoP(productCode, productName, productPrice, productSize, productImages, category_categoryCode);
					dtoPs.add(dtoP);
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close(); //데이터가 있으면 close
					if(ps!=null) ps.close();
					if(conn!= null) conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return dtoPs;
			
			
		}
		
		//citrus 
		public ArrayList<ADtoP> sCList() {
			ArrayList<ADtoP> dtoPs = new ArrayList<ADtoP>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				conn = dataSource.getConnection();
				String query1 = "select productCode,productName,productPrice,productSize,productImages,category_categoryCode from product where productCode like '%-c-%'";
				ps = conn.prepareStatement(query1);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String productCode = rs.getString("productCode");
					String productName = rs.getString("productName");
					int productPrice = rs.getInt("productPrice");
					String productSize = rs.getString("productSize");
					String productImages = rs.getString("productImages");
					String category_categoryCode = rs.getString("category_categoryCode");
					
					ADtoP dtoP = new ADtoP(productCode, productName, productPrice, productSize, productImages, category_categoryCode);
					dtoPs.add(dtoP);
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close(); //데이터가 있으면 close
					if(ps!=null) ps.close();
					if(conn!= null) conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return dtoPs;
			
			
		}
		
		//fresh
		public ArrayList<ADtoP> sFRList() {
			ArrayList<ADtoP> dtoPs = new ArrayList<ADtoP>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				conn = dataSource.getConnection();
				String query1 = "select productCode,productName,productPrice,productSize,productImages,category_categoryCode from product where productCode like '%-fr-%'";
				ps = conn.prepareStatement(query1);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String productCode = rs.getString("productCode");
					String productName = rs.getString("productName");
					int productPrice = rs.getInt("productPrice");
					String productSize = rs.getString("productSize");
					String productImages = rs.getString("productImages");
					String category_categoryCode = rs.getString("category_categoryCode");
					
					ADtoP dtoP = new ADtoP(productCode, productName, productPrice, productSize, productImages, category_categoryCode);
					dtoPs.add(dtoP);
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close(); //데이터가 있으면 close
					if(ps!=null) ps.close();
					if(conn!= null) conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return dtoPs;
			
			
		}
		
		//fruity
		public ArrayList<ADtoP> sFTList() {
			ArrayList<ADtoP> dtoPs = new ArrayList<ADtoP>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				conn = dataSource.getConnection();
				String query1 = "select productCode,productName,productPrice,productSize,productImages,category_categoryCode from product where productCode like '%-fr-%'";
				ps = conn.prepareStatement(query1);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String productCode = rs.getString("productCode");
					String productName = rs.getString("productName");
					int productPrice = rs.getInt("productPrice");
					String productSize = rs.getString("productSize");
					String productImages = rs.getString("productImages");
					String category_categoryCode = rs.getString("category_categoryCode");
					
					ADtoP dtoP = new ADtoP(productCode, productName, productPrice, productSize, productImages, category_categoryCode);
					dtoPs.add(dtoP);
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close(); //데이터가 있으면 close
					if(ps!=null) ps.close();
					if(conn!= null) conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return dtoPs;
			
			
		}
		
		//woody
		public ArrayList<ADtoP> sWList() {
			ArrayList<ADtoP> dtoPs = new ArrayList<ADtoP>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				conn = dataSource.getConnection();
				String query1 = "select productCode,productName,productPrice,productSize,productImages,category_categoryCode from product where productCode like '%-w-%'";
				ps = conn.prepareStatement(query1);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String productCode = rs.getString("productCode");
					String productName = rs.getString("productName");
					int productPrice = rs.getInt("productPrice");
					String productSize = rs.getString("productSize");
					String productImages = rs.getString("productImages");
					String category_categoryCode = rs.getString("category_categoryCode");
					
					ADtoP dtoP = new ADtoP(productCode, productName, productPrice, productSize, productImages, category_categoryCode);
					dtoPs.add(dtoP);
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close(); //데이터가 있으면 close
					if(ps!=null) ps.close();
					if(conn!= null) conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return dtoPs;
			
			
		}
		
		//Oriental
		public ArrayList<ADtoP> sOList() {
			ArrayList<ADtoP> dtoPs = new ArrayList<ADtoP>();
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				conn = dataSource.getConnection();
				String query1 = "select productCode,productName,productPrice,productSize,productImages,category_categoryCode from product where productCode like '%-o-%'";
				ps = conn.prepareStatement(query1);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					String productCode = rs.getString("productCode");
					String productName = rs.getString("productName");
					int productPrice = rs.getInt("productPrice");
					String productSize = rs.getString("productSize");
					String productImages = rs.getString("productImages");
					String category_categoryCode = rs.getString("category_categoryCode");
					
					ADtoP dtoP = new ADtoP(productCode, productName, productPrice, productSize, productImages, category_categoryCode);
					dtoPs.add(dtoP);
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null) rs.close(); //데이터가 있으면 close
					if(ps!=null) ps.close();
					if(conn!= null) conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return dtoPs;
			
			
		}
	
}
