package com.coin.service;

import java.util.List;

import com.coin.vo.LocationVO;

public interface LocationService {
	public List<LocationVO> getListBy(String type, String val, boolean like);
}
