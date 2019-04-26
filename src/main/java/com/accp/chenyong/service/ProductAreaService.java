package com.accp.chenyong.service;


import java.util.Date;

import com.accp.domain.productarea;
import com.accp.domain.project;

public interface ProductAreaService {

	public project queryByArearId(productarea p,Date startTime,Date EndTime);
}
