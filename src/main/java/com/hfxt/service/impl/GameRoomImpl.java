package com.hfxt.service.impl;

import com.hfxt.dao.GameroomMapper;
import com.hfxt.model.Gameroom;
import com.hfxt.service.GameRoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class GameRoomImpl implements GameRoomService {
    @Resource
    private GameroomMapper gameRoomDao;


    @Override
    public int deleteByPrimaryKey(Integer roomid) {
        return gameRoomDao.deleteByPrimaryKey(roomid);
    }

    @Override
    public int insert(Gameroom record) {
        return gameRoomDao.insert(record);
    }

    @Override
    public int insertSelective(Gameroom record) {
        return gameRoomDao.insertSelective(record);
    }

    @Override
    public Gameroom selectByPrimaryKey(Integer roomid) {
        return gameRoomDao.selectByPrimaryKey(roomid);
    }

    @Override
    public List<Gameroom> selectAll(Gameroom record) {
        return gameRoomDao.selectAll(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Gameroom record) {
        return gameRoomDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Gameroom record) {
        return gameRoomDao.updateByPrimaryKey(record);
    }
}
