package com.hfxt.service;

import com.hfxt.model.Hallinformation;

import java.util.List;

public interface HallInfoService {
    int deleteByPrimaryKey(String region);

    int insert(Hallinformation record);

    int insertSelective(Hallinformation record);

    Hallinformation selectByPrimaryKey(String region);

    List<Hallinformation> selectAll();

    int updateByPrimaryKeySelective(Hallinformation record);

    int updateByPrimaryKey(Hallinformation record);
}
