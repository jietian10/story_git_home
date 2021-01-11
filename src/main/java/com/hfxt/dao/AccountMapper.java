package com.hfxt.dao;

import com.hfxt.model.Account;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByPrimaryKeys(Integer[] ids);

    int insert(Account record);

    int insertSelective(Account record);

    Integer selectUserName(Account record);

    List<Account> selectUsersByCon(Account record);

    Account selectByCon(Account record);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

}