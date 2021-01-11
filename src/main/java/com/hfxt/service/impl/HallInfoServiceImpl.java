package com.hfxt.service.impl;

import com.hfxt.dao.HallinformationMapper;
import com.hfxt.model.Hallinformation;
import com.hfxt.service.HallInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class HallInfoServiceImpl implements HallInfoService {

    @Resource
    HallinformationMapper hallDao;

    @Override
    public int deleteByPrimaryKey(String region) {
        return hallDao.deleteByPrimaryKey(region);
    }

    @Override
    public int insert(Hallinformation record) {
        return hallDao.insert(record);
    }

    @Override
    public int insertSelective(Hallinformation record) {
        return hallDao.insertSelective(record);
    }

    @Override
    public Hallinformation selectByPrimaryKey(String region) {
        return hallDao.selectByPrimaryKey(region);
    }

    @Override
    public List<Hallinformation> selectAll() {
        return hallDao.selectAll();
    }

    @Override
    public int updateByPrimaryKeySelective(Hallinformation record) {
        return hallDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Hallinformation record) {
        return hallDao.updateByPrimaryKey(record);
    }
}
