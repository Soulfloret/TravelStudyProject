package com.accp.mapper;

import com.accp.domain.discount;
import com.accp.domain.discountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface discountMapper {
	
	
	
    int countByExample(discountExample example);

    int deleteByExample(discountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(discount record);

    int insertSelective(discount record);

    List<discount> selectByExample(discountExample example);

    discount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") discount record, @Param("example") discountExample example);

    int updateByExample(@Param("record") discount record, @Param("example") discountExample example);

    int updateByPrimaryKeySelective(discount record);

    int updateByPrimaryKey(discount record);
}