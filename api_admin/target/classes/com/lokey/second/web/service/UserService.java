package com.lokey.second.web.service;

import com.lokey.second.web.entity.Goods;
import com.lokey.second.web.entity.GoodsBidding;
import com.lokey.second.web.entity.User;
import com.lokey.second.web.result.Result;

import java.util.Map;

/**
 * Created by lokey on 2018/1/9.
 */
public interface UserService {
    //用户注册
    public Result register(User user);
    //登录 返回用户信息
    public Result login(User user);
    //获取分类列表
    public Result getGoodCateList();
    //获取商品列表
    public Result getGoodsList(Map map);
    //获取商品
    public Result getGoods(Integer id);
    //确认竞价
    public Result buyGoods(Integer id,Integer userId);
    //我的商品 1未审核 2 销售中 3已售出
    public Result getUserGoods(Map map);
    //发布商品
    public Result publishGoods(Goods goods);
}
