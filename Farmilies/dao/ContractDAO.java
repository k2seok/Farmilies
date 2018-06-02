package com.coin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.coin.dbutil.JDBCutil;
import com.coin.vo.ContractVO;
import com.coin.vo.UserVO;

public class ContractDAO {

	
	String table_name = "contracts";
	
	static String[] columnNames = {
			"id",
			"rating",
			"comments",
			"worker_id",
			"work_id"
	};
	
	
	public List<ContractVO> getListBy(String type, String val , boolean like) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//int result = 0;
		List<ContractVO> list  = new ArrayList<>();
		
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
				ContractVO vo = new ContractVO();
				vo.setId(rs.getString(columnNames[0]));
				vo.setRating(rs.getString(columnNames[1]));
				vo.setComments(rs.getString(columnNames[2]));
				vo.setWorker_id(rs.getString(columnNames[3]));
				vo.setWork_id(rs.getString(columnNames[4]));
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
