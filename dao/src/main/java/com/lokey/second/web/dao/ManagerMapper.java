package com.lokey.second.web.dao;

import com.lokey.second.web.entity.Manager;

public interface ManagerMapper {
    int insert(Manager record);

    int insertSelective(Manager record);
}