package com.hfxt.service.impl;

import com.hfxt.dao.AccountMapper;
import com.hfxt.model.Account;
import com.hfxt.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return accountDao.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] ids) {
        return accountDao.deleteByPrimaryKeys(ids);
    }

    @Override
    public int insert(Account record) {
        return accountDao.insert(record);
    }

    @Override
    public int insertSelective(Account record) {
        return accountDao.insertSelective(record);
    }

    @Override
    public Account selectByCon(Account record) {
        return accountDao.selectByCon(record);
    }

    @Override
    public List<Account> selectUsersByCon(Account record) {
        return accountDao.selectUsersByCon(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Account record) {
        return accountDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Account record) {
        return accountDao.updateByPrimaryKey(record);
    }

    @Override
    public Integer selectUserName(Account record) {
        return accountDao.selectUserName(record);
    }
}
