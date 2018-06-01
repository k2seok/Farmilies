package com.coin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.coin.dbutil.JDBCutil;
import com.coin.vo.WorkVO;

public class WorkDAO {
	String table_name = "works";
	
	static String[] columnNames = {
			"id",
			"pic_id",
			"hirer_id",
			"title",
			"description",
			"location_id"
	};
	
	
	public List<WorkVO> getListBy(String type, String val , boolean like) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//int result = 0;
		List<WorkVO> list  = new ArrayList<>();
		
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
				WorkVO vo = new WorkVO();
				vo.setId(rs.getString(columnNames[0]));
				vo.setPic_id(rs.getString(columnNames[1]));
				vo.setHirer_id(rs.getString(columnNames[2]));
				vo.setTitle(rs.getString(columnNames[3]));
				vo.setDescription(rs.getString(columnNames[4]));
				vo.setLocation_id(rs.getString(columnNames[5]));
				list.add(vo);
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
