package com.lokey.second.web.controller;

import com.lokey.second.web.constant.ParamConstant;
import com.lokey.second.web.entity.User;
import com.lokey.second.web.enums.UserState;
import com.lokey.second.web.result.Result;
import com.lokey.second.web.result.ResultUtil;
import com.lokey.second.web.service.ManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by lokey on 2018/1/12.
 */
@RestController
@RequestMapping(value = "manageuser")
public class ManageUserController {
    @Autowired
    private ManageUserService manageUserService;

    @PostMapping(value = "/getUserApplicationList")
    public Result getUserApplicationList(@RequestBody Map map){
        if(null == map.get(ParamConstant.PAGE_START)||null == map.get(ParamConstant.PAGE_END)){
            return ResultUtil.error("参数不全");
        }
        map.put(ParamConstant.STATE, UserState.NOT_CHECKED.getValue()); //筛选条件
        return manageUserService.getUserList(map);
    }


    @PostMapping(value = "/changeUser")
    public Result changeUser(@RequestBody User user){
        if(null == user.getPkId() || user.getPkId().equals(0)){
            return manageUserService.addUser(user);
        }
        return manageUserService.changeUser(user);
    }

    @PostMapping(value = "/deleteUser")
    public Result deleteUser(@RequestParam(value = "pkId", required = false) Integer pkId){
        if(null == pkId){
            return ResultUtil.error("参数不全");
        }
        return manageUserService.deleteUser(pkId);
    }

    @PostMapping(value = "/getUserList")
    public Result getUserList(@RequestBody Map map){
        if(null == map.get(ParamConstant.PAGE_START)||null == map.get(ParamConstant.PAGE_END)){
            return ResultUtil.error("参数不全");
        }
        map.put(ParamConstant.STATE, UserState.COMMON.getValue()); //筛选条件
        return manageUserService.getUserList(map);
    }
}
