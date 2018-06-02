package com.coin.dbutil;

import java.util.List;

import com.coin.dao.ContractDAO;
import com.coin.dao.LocationDAO;
import com.coin.dao.PictureDAO;
import com.coin.dao.UserDAO;
import com.coin.dao.UserGroupDAO;
import com.coin.dao.WorkDAO;
import com.coin.vo.UserVO;

public class MainClass {
	
	
	
	public static void main(String[] args) {
		ContractDAO contractDao = new ContractDAO();
		LocationDAO locationDao = new LocationDAO();
		PictureDAO pictureDao = new PictureDAO();
		UserDAO userDao = new UserDAO();
		UserGroupDAO userGroupDao = new UserGroupDAO();
		WorkDAO workDao = new WorkDAO();
		
		
		List<UserVO> users = userDao.getListBy("id", "fkalar", true);
		
		for(UserVO vo : users) {
			System.out.println(vo);
		}
		
		
		
		System.out.println("sgwe");
	}
}
