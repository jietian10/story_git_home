package com.hfxt.service.impl;

import com.hfxt.dao.RoominformationMapper;
import com.hfxt.model.Roominformation;
import com.hfxt.service.RoomInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RoomInfoServiceImpl implements RoomInfoService {

    @Resource
    private RoominformationMapper roomInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer roomid) {
        return roomInfoMapper.deleteByPrimaryKey(roomid);
    }

    @Override
    public int insert(Roominformation record) {
        return roomInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(Roominformation record) {
        return roomInfoMapper.insertSelective(record);
    }

    @Override
    public Roominformation selectByPrimaryKey(Integer roomid) {
        return roomInfoMapper.selectByPrimaryKey(roomid);
    }

    @Override
    public List<Roominformation> selectAll(Roominformation record) {
        return roomInfoMapper.selectAll(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Roominformation record) {
        return roomInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Roominformation record) {
        return roomInfoMapper.updateByPrimaryKey(record);
    }
}
