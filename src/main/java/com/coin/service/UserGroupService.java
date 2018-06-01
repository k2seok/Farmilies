package com.coin.service;

import java.util.List;

import com.coin.vo.UserGroupVO;

public interface UserGroupService {
	public List<UserGroupVO> getListBy(String type, String val, boolean like);
}
