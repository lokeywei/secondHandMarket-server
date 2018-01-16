package com.lokey.second.web.controller;

import com.lokey.second.web.constant.ParamConstant;
import com.lokey.second.web.entity.Goods;
import com.lokey.second.web.entity.User;
import com.lokey.second.web.enums.UserState;
import com.lokey.second.web.result.Result;
import com.lokey.second.web.result.ResultEnums;
import com.lokey.second.web.result.ResultUtil;
import com.lokey.second.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lokey on 2017/12/4.
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "/getGoodCateList")
    public Result getGoodCateList(){
        return userService.getGoodCateList();
    }

    @PostMapping(value = "/register")
    public Result register(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return userService.register(user);
    }

    @PostMapping(value = "/login")
    public Result register(@Autowired User user){
        return userService.login(user);
    }


    @PostMapping(value = "/getGoodsList")
    public Result getGoodsList(@RequestParam(value = "cateId", required = false) Integer cateId){
        Map map = new HashMap();
        map.put(ParamConstant.CATE_ID,cateId);
        map.put(ParamConstant.IS_SELL, UserState.NOT_CHECKED.getValue()); //筛选条件
        map.put(ParamConstant.IS_CHECKED, UserState.COMMON.getValue()); //筛选条件
        return userService.getGoodsList(map);
    }


    @PostMapping(value = "/getGoods")
    public Result getGoods(@RequestParam(value = "id", required = false) Integer id){
        return userService.getGoods(id);
    }

    @PostMapping(value = "/buyGoods")
    public Result buyGoods(@RequestParam(value = "id", required = false) Integer id,
                           @RequestParam(value = "userId", required = false) Integer userId){
        return userService.buyGoods(id,userId);
    }

    @PostMapping(value = "/publishGoods")
    public Result publishGoods(@RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "price", required = false) Double price,
                                @RequestParam(value = "des", required = false) String des,
                                @RequestParam(value = "cateId", required = false) Integer cateId,
                                @RequestParam(value = "userId", required = false) Integer userId,
                                @RequestParam(value = "file", required = false) MultipartFile file){
        Goods goods = new Goods();
        goods.setName(name);
        goods.setPrice(price);
        goods.setDes(des);
        goods.setCateId(cateId);
        goods.setUserId(userId);
        if(null!=file) {
            String path = "E://南邮实训/html/html/upload";
            //创建文件
            String prefix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            String fileName = "/" + dateFormat.format(new Date()) + "/" + new Date().getTime() + prefix;
            if (!new File(path + "/" + dateFormat.format(new Date())).exists()) {
                new File(path + "/" + dateFormat.format(new Date())).mkdirs();
            }
            //Copy文件
            File targetFile = new File(path, fileName);
            try {
                file.transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            goods.setImage("upload"+fileName);
        }
        return userService.publishGoods(goods);
    }

}
