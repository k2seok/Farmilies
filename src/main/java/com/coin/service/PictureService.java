package com.coin.service;

import java.util.List;

import com.coin.vo.PictureVO;

public interface PictureService {
	public List<PictureVO> getListBy(String type, String val, boolean like);
}
