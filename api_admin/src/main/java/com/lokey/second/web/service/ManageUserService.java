package com.lokey.second.web.service;

import com.lokey.second.web.entity.User;
import com.lokey.second.web.result.Result;
import java.util.List;
import java.util.Map;

/**
 * Created by lokey on 2017/12/4.
 */
public interface ManageUserService {

    public Result getUserList(Map map);

    public Result addUser(User user);

    public Result changeUser(User user);

    public Result deleteUser(Integer pkId);

}
