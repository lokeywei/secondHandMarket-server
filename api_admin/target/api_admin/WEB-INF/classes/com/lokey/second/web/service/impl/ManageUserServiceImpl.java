package com.lokey.second.web.service.impl;

import com.lokey.second.web.dao.UserMapper;
import com.lokey.second.web.entity.User;
import com.lokey.second.web.enums.UserState;
import com.lokey.second.web.result.Result;
import com.lokey.second.web.result.ResultUtil;
import com.lokey.second.web.service.ManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lokey on 2018/1/12.
 */
@Service(value = "manageUserService")
public class ManageUserServiceImpl implements ManageUserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public Result getUserList(Map map) {
        List<User> userList = userMapper.selectByPage(map);
        int count = userMapper.count(map);
        Map dataMap = new HashMap();
        dataMap.put("userList",userList);
        dataMap.put("count",count);
        return ResultUtil.success(dataMap);
    }

    @Override
    public Result addUser(User user) {
        User checkUser = userMapper.selectByAccount(user.getAccount());
        if(null != checkUser){
            return ResultUtil.error("账号重复");
        }
        user.setState(UserState.COMMON.getValue());
        user.setCreateTime(new Date());
        userMapper.insertSelective(user);
        return ResultUtil.success(null);
    }

    @Override
    public Result changeUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return ResultUtil.success(null);
    }

    @Override
    public Result deleteUser(Integer pkId) {
        userMapper.deleteByPrimaryKey(pkId);
        return ResultUtil.success(null);
    }

}
