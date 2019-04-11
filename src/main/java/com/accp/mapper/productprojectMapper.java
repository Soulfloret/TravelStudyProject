package com.accp.mapper;

import com.accp.domain.product;
import com.accp.domain.productproject;
import com.accp.domain.productprojectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface productprojectMapper {
    int countByExample(productprojectExample example);

    int deleteByExample(productprojectExample example);

    int deleteByPrimaryKey(Integer id);
 
    int insert(productproject record);

    int insertSelective(productproject record);

    List<productproject> selectByExample(productprojectExample example);

    productproject selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") productproject record, @Param("example") productprojectExample example);

    int updateByExample(@Param("record") productproject record, @Param("example") productprojectExample example);

    int updateByPrimaryKeySelective(productproject record);

    int updateByPrimaryKey(productproject record);
    
    int insert_product(product prod);
}