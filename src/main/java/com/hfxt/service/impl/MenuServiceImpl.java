package com.hfxt.service.impl;

import com.hfxt.dao.MenuMapper;
import com.hfxt.model.Menu;
import com.hfxt.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return menuDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Menu record) {
        return menuDao.insert(record);
    }

    @Override
    public int insertSelective(Menu record) {
        return menuDao.insertSelective(record);
    }

    @Override
    public Menu selectByPrimaryKey(Integer id) {
        return menuDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Menu> selectAll() {
        return menuDao.selectAll();
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {
        return menuDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Menu record) {
        return menuDao.updateByPrimaryKey(record);
    }
}
