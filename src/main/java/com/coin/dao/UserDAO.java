package com.coin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.coin.dbutil.JDBCutil;
import com.coin.vo.UserVO;

public class UserDAO {
	
	String table_name = "users";
	
	static String[] columnNames = {
			"id",
			"update_at",
			"create_at",
			"email",
			"password",
			"first_name",
			"last_name",
			"group_id",
			"picture_id"
	};
	
	
	public List<UserVO> getListBy(String type, String val , boolean like) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//int result = 0;
		List<UserVO> list  = new ArrayList<>();
		
		try {
			con = JDBCutil.getConnection();
			
			String likeOrEquals = null;
			if(like) {
				likeOrEquals = " like '%"+val+"%'";
			}else {
				likeOrEquals = "="+val;				
			}
			
			
			ps = con.prepareStatement("select * from "
										+table_name
										+" where " 
										+ type 
										+likeOrEquals);
			
			
										
			//result = ps.executeUpdate();
			rs = ps.executeQuery();
		
			
			while(rs.next()) {
				UserVO user = new UserVO();
				user.setId(rs.getString(columnNames[0]));
				user.setUpdate_at(rs.getString(columnNames[1]));
				user.setCreate_at(rs.getString(columnNames[2]));
				user.setEmail(rs.getString(columnNames[3]));
				user.setPassword(rs.getString(columnNames[4]));
				user.setFirst_name(rs.getString(columnNames[5]));
				user.setLast_name(rs.getString(columnNames[6]));
				user.setGroup_id(rs.getString(columnNames[7]));
				user.setPicture_id(rs.getString(columnNames[8]));
				list.add(user);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.close(con, ps, rs);
		}
		return list;
	}

}
