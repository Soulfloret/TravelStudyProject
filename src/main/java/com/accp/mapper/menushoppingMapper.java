package com.accp.mapper;

import com.accp.domain.menushopping;
import com.accp.domain.menushoppingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface menushoppingMapper {
    int countByExample(menushoppingExample example);

    int deleteByExample(menushoppingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(menushopping record);

    int insertSelective(menushopping record);

    List<menushopping> selectByExample(menushoppingExample example);

    menushopping selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") menushopping record, @Param("example") menushoppingExample example);

    int updateByExample(@Param("record") menushopping record, @Param("example") menushoppingExample example);

    int updateByPrimaryKeySelective(menushopping record);

    int updateByPrimaryKey(menushopping record);
}