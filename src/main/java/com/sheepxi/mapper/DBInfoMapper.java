package com.sheepxi.mapper;

import com.sheepxi.pojo.dto.DBInfo;

public interface DBInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DBInfo record);

    int insertSelective(DBInfo record);

    DBInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DBInfo record);

    int updateByPrimaryKey(DBInfo record);
}