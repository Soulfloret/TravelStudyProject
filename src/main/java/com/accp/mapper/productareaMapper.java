package com.accp.mapper;

import com.accp.domain.productarea;
import com.accp.domain.productareaExample;
import com.accp.domain.project;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface productareaMapper {
    int countByExample(productareaExample example);

    int deleteByExample(productareaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(productarea record);

    int insertSelective(productarea record);

    List<productarea> selectByExample(productareaExample example);

    productarea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") productarea record, @Param("example") productareaExample example);

    int updateByExample(@Param("record") productarea record, @Param("example") productareaExample example);

    int updateByPrimaryKeySelective(productarea record);

    int updateByPrimaryKey(productarea record);
    
    /*项目新增基地*/
    int project_areas(project pro);
    
    /*��Ŀ��ѯ����*/
    List<productarea> queryByPid(Integer pid);
}