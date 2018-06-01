package com.coin.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCutil {
	
	
	public static Connection getConnection() {
		String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
        String USER = "system";
        String PASS = "1234";
		Connection conn = null;
        
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return conn;
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
