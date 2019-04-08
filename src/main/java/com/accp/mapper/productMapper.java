package com.accp.mapper;

import com.accp.domain.product;
import com.accp.domain.productExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface productMapper {
    int countByExample(productExample example);

    int deleteByExample(productExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(product record);

    int insertSelective(product record);

    List<product> selectByExample(productExample example);

    product selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") product record, @Param("example") productExample example);

    int updateByExample(@Param("record") product record, @Param("example") productExample example);

    int updateByPrimaryKeySelective(product record);

    int updateByPrimaryKey(product record);
}