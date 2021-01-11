package com.hfxt.dao;

import com.hfxt.model.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    List<Menu> selectAll();

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    int updateByPrimaryKey1(@Param("record") Menu record);
}