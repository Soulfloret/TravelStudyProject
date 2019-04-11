package com.accp.wujiajun.service.impl;

import java.util.List;

import com.accp.domain.positions;
import com.accp.domain.positionsExample;

public interface positionsServiceImpl {

	List<positions> selectByExample(positionsExample example);
}
