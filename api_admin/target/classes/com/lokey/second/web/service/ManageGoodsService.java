package com.lokey.second.web.service;


import com.lokey.second.web.entity.Goods;
import com.lokey.second.web.entity.GoodsCate;
import com.lokey.second.web.result.Result;

import java.util.Map;

/**
 * Created by lokey on 2017/12/4.
 */
public interface ManageGoodsService {
    //获取分类列表
    public Result getGoodsCateList(Map map);
    //新增分类
    public Result addGoodsCate(GoodsCate goodsCate);
    //修改分类
    public Result changeGoodsCate(GoodsCate goodsCate);
    //获取商品列表
    public Result getGoodsList(Map map);
    //修改商品状态
    public Result changeGoods(Goods goods);
    //删除商品
    public Result deleteGoods(Integer pkId);
}
