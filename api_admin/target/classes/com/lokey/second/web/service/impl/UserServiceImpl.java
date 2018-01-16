package com.lokey.second.web.service.impl;

import com.lokey.second.web.constant.ParamConstant;
import com.lokey.second.web.dao.GoodsBiddingMapper;
import com.lokey.second.web.dao.GoodsCateMapper;
import com.lokey.second.web.dao.GoodsMapper;
import com.lokey.second.web.dao.UserMapper;
import com.lokey.second.web.entity.*;
import com.lokey.second.web.enums.UserState;
import com.lokey.second.web.result.Result;
import com.lokey.second.web.result.ResultUtil;
import com.lokey.second.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lokey on 2018/1/9.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GoodsCateMapper goodsCateMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsBiddingMapper goodsBiddingMapper;


    @Override
    public Result register(User user) {
        User checkUser = userMapper.selectByAccount(user.getAccount());
        if(null != checkUser){
            return ResultUtil.error("手机号已被注册！");
        }
        user.setState(UserState.NOT_CHECKED.getValue());
        user.setCreateTime(new Date());
        userMapper.insertSelective(user);
        return ResultUtil.success(null);
    }

    @Override
    public Result login(User user) {
        User checkUser = userMapper.selectByAccount(user.getAccount());
        if(null == checkUser){
            return ResultUtil.error("账号不存在");
        }
        if(!checkUser.getState().equals(UserState.COMMON.getValue())){
            return ResultUtil.error("账号不存在");
        }
        if(!checkUser.getPassword().equals(user.getPassword())){
            return ResultUtil.error("账号或密码错误");
        }
        Map dataMap = new HashMap();
        dataMap.put("buy",checkUser.getBuy());
        dataMap.put("publish",checkUser.getPublish());
        dataMap.put("name",checkUser.getName());
        dataMap.put("userId",checkUser.getPkId());
        return ResultUtil.success(dataMap);
    }

    @Override
    public Result getGoodCateList() {
        Map requeryMap = new HashMap();
        requeryMap.put(ParamConstant.STATE,UserState.COMMON.getValue());
        List<GoodsCate> goodsCateList = goodsCateMapper.selectByPage(requeryMap);
        Map dataMap = new HashMap();
        dataMap.put("goodsCateList",goodsCateList);
        return ResultUtil.success(dataMap);
    }

    @Override
    public Result getGoodsList(Map map) {
        List<Goods> goodsList = goodsMapper.selectByPage(map);
        Map dataMap = new HashMap();
        dataMap.put("goodsList",goodsList);
        return ResultUtil.success(dataMap);
    }

    @Override
    public Result getGoods(Integer id) {
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        return ResultUtil.success(goods);
    }

    @Override
    public Result buyGoods(Integer id,Integer userId) {
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        if(null == goods){
            return ResultUtil.error("商品不存在");
        }
        if(goods.getIsSell().equals(1)){
            return ResultUtil.error("商品已卖出");
        }
        goods.setIsSell(1);
        goodsMapper.updateByPrimaryKeySelective(goods);
        GoodsBidding goodsBidding = new GoodsBidding();
        goodsBidding.setGoodsId(id);
        goodsBidding.setUserId(userId);
        goodsBidding.setPrice(goods.getPrice());
        goodsBiddingMapper.insertSelective(goodsBidding);
        return ResultUtil.success(null);
    }


    @Override
    public Result getUserGoods(Map map) {

        return null;
    }

    @Override
    public Result publishGoods(Goods goods) {
        goods.setIsChecked(UserState.NOT_CHECKED.getValue());
        goods.setIsSell(UserState.NOT_CHECKED.getValue());
        goods.setCreateTime(new Date());
        goodsMapper.insertSelective(goods);
        return ResultUtil.success(null);
    }


}
