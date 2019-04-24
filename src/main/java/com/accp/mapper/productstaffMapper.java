package com.accp.mapper;

import com.accp.domain.productstaff;
import com.accp.domain.productstaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface productstaffMapper {
    int countByExample(productstaffExample example);

    int deleteByExample(productstaffExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(productstaff record);

    int insertSelective(productstaff record);

    List<productstaff> selectByExample(productstaffExample example);

    productstaff selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") productstaff record, @Param("example") productstaffExample example);

    int updateByExample(@Param("record") productstaff record, @Param("example") productstaffExample example);

    int updateByPrimaryKeySelective(productstaff record);

    int updateByPrimaryKey(productstaff record);
    
    List<productstaff> projectOrder_queryStaff();
}