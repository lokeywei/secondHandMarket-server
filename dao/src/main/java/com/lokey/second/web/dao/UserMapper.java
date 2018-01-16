package com.lokey.second.web.dao;

import com.lokey.second.web.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer pkId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer pkId);

    User selectByAccount(String account);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectByPage(Map map);

    int count(Map map);
}