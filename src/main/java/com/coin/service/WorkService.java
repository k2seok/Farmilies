package com.coin.service;

import java.util.List;

import com.coin.vo.WorkVO;

public interface WorkService {
	public List<WorkVO> getListBy(String type, String val, boolean like);
}
