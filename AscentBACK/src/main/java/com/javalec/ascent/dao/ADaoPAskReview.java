package com.javalec.ascent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ascent.dto.ADtoPAR;

public class ADaoPAskReview {
	DataSource dataSource;
	
	public ADaoPAskReview() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/ascent");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ADtoPAR productDetail(String sproductCode){	//데이터베이스에 저장해야해서 dto
		ADtoPAR dto = null;
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String query = "select * from product where productCode =?";
			ps = conn.prepareStatement(query);
			ps.setString(1,sproductCode);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String productCode = rs.getString("productCode");
				String productName = rs.getString("productName");
				int productPrice = rs.getInt("productPrice");
				String productSize = rs.getString("productSize");
				String productImages = rs.getString("productImages");
				String category_categoryCode = rs.getString("category_categoryCode");
			
				dto = new ADtoPAR(productCode, productName, productPrice, productSize, productImages, category_categoryCode);
						
			}
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		finally {				//try catch 하고 나서 이상이 있든 없든 마지막에 오는 final
			try {
				if(rs != null) rs.close(); //데이터가 있으면 close
				if(ps !=null) ps.close();
				if(conn != null) conn.close();
 			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
}