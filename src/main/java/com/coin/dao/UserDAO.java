package com.coin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.coin.dbutil.JDBCutil;
import com.coin.vo.UserVO;

public class UserDAO {
	
	static final String table_name = "users";
	
	static final String[] columnNames = {
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
	
	static final String insert_values; 
	
	static {
		StringBuilder sb = new StringBuilder();
		
		sb.append("(");
		for(int i = 0 ; i < columnNames.length ; i++) {
			sb.append(columnNames[i]);
			if(i != columnNames.length -1) {
				sb.append(",");
			}
		}
		sb.append(") values (");
		for(int i = 0 ; i < columnNames.length ; i++) {
			sb.append("?");
			if(i != columnNames.length -1) {
				sb.append(",");
			}
		}
		sb.append(")");
		
		insert_values = sb.toString();
	}
	
	
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
			
			System.out.println("select * from "
										+table_name
										+" where " 
										+ type 
										+likeOrEquals);
			
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
				user.setUpdate_at(rs.getDate(columnNames[1]));
				user.setCreate_at(rs.getDate(columnNames[2]));
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
	
	
	public int insert(UserVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		//List<UserVO> list  = new ArrayList<>();
		
		try {
			con = JDBCutil.getConnection();
			
			
			ps = con.prepareStatement("insert into "
										+table_name
										+ insert_values);
			
			int count = 0;
			ps.setString(count++,vo.getId());
			ps.setDate(count++,vo.getUpdate_at());
			ps.setDate(count++,vo.getCreate_at());
			ps.setString(count++,vo.getEmail());
			ps.setString(count++,vo.getPassword());
			ps.setString(count++,vo.getFirst_name());
			ps.setString(count++,vo.getLast_name());
			ps.setString(count++,vo.getGroup_id());
			ps.setString(count++,vo.getPicture_id());
			
										
			result = ps.executeUpdate();
			//rs = ps.executeQuery();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCutil.close(con, ps, rs);
		}
		return result;
	}

}
