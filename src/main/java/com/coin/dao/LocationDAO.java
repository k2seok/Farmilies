package com.coin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.coin.dbutil.JDBCutil;
import com.coin.vo.LocationVO;

public class LocationDAO {
	
	String table_name = "locations";
	
	static String[] columnNames = {
			"id",
			"address_name",
			"address_type",
			"x",
			"y",
			"region_address",
			"road_address"
	};
	
	
	public List<LocationVO> getListBy(String type, String val , boolean like) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//int result = 0;
		List<LocationVO> list  = new ArrayList<>();
		
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
				LocationVO vo = new LocationVO();
				vo.setId(rs.getString(columnNames[0]));
				vo.setAddress_name(rs.getString(columnNames[1]));
				vo.setAddress_type(rs.getString(columnNames[2]));
				vo.setX(rs.getDouble(columnNames[3]));
				vo.setY(rs.getDouble(columnNames[4]));
				vo.setRegion_address(rs.getString(columnNames[5]));
				vo.setRoad_address(rs.getString(columnNames[6]));
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
