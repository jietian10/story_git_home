package com.hfxt.service;

import com.hfxt.model.Account;

import java.util.List;

public interface AccountService {

    int deleteByPrimaryKey(Integer id);

    int deleteByPrimaryKeys(Integer[] ids);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByCon(Account record);

    List<Account> selectUsersByCon(Account record);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    Integer selectUserName(Account record);
}
