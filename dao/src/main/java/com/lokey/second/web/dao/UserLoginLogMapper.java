package com.lokey.second.web.dao;

import com.lokey.second.web.entity.UserLoginLog;

public interface UserLoginLogMapper {
    int deleteByPrimaryKey(Integer pkId);

    int insert(UserLoginLog record);

    int insertSelective(UserLoginLog record);

    UserLoginLog selectByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(UserLoginLog record);

    int updateByPrimaryKey(UserLoginLog record);
}