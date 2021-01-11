package com.hfxt.service;

import com.hfxt.model.Roominformation;

import java.util.List;

public interface RoomInfoService {
    int deleteByPrimaryKey(Integer roomid);

    int insert(Roominformation record);

    int insertSelective(Roominformation record);

    Roominformation selectByPrimaryKey(Integer roomid);

    List<Roominformation> selectAll(Roominformation record);

    int updateByPrimaryKeySelective(Roominformation record);

    int updateByPrimaryKey(Roominformation record);
}
