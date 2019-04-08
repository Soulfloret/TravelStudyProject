package com.accp.mapper;

import com.accp.domain.images;
import com.accp.domain.imagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface imagesMapper {
    int countByExample(imagesExample example);

    int deleteByExample(imagesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(images record);

    int insertSelective(images record);

    List<images> selectByExample(imagesExample example);

    images selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") images record, @Param("example") imagesExample example);

    int updateByExample(@Param("record") images record, @Param("example") imagesExample example);

    int updateByPrimaryKeySelective(images record);

    int updateByPrimaryKey(images record);
}