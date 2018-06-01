package com.coin.service;

import java.util.List;

import com.coin.vo.UserVO;

public interface UserService {
	public List<UserVO> getListBy(String type, String val, boolean like);
}
