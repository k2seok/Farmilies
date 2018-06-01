package com.coin.service;

import java.util.List;

import com.coin.vo.ContractVO;

public interface ContractService {
	public List<ContractVO> getListBy(String type, String val, boolean like);
}
