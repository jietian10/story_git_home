package com.hfxt.service;

import com.hfxt.model.Gameroom;

import java.util.List;

public interface GameRoomService {
    int deleteByPrimaryKey(Integer roomid);

    int insert(Gameroom record);

    int insertSelective(Gameroom record);

    Gameroom selectByPrimaryKey(Integer roomid);

    List<Gameroom> selectAll(Gameroom record);

    int updateByPrimaryKeySelective(Gameroom record);

    int updateByPrimaryKey(Gameroom record);
}
