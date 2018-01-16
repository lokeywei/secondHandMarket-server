package com.lokey.second.web.service.impl;

import com.lokey.second.web.dao.GoodsCateMapper;
import com.lokey.second.web.dao.GoodsMapper;
import com.lokey.second.web.entity.Goods;
import com.lokey.second.web.entity.GoodsCate;
import com.lokey.second.web.enums.UserState;
import com.lokey.second.web.result.Result;
import com.lokey.second.web.result.ResultUtil;
import com.lokey.second.web.service.ManageGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lokey on 2018/1/13.
 */
@Service(value = "manageGoodsService")
public class ManageGoodsServiceImpl implements ManageGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsCateMapper goodsCateMapper;
    @Override
    public Result getGoodsCateList(Map map) {
        List<GoodsCate> goodsCateList = goodsCateMapper.selectByPage(map);
        int count = goodsCateMapper.count(map);
        Map dataMap = new HashMap();
        dataMap.put("goodsCateList",goodsCateList);
        dataMap.put("count",count);
        return ResultUtil.success(dataMap);
    }

    @Override
    public Result addGoodsCate(GoodsCate goodsCate) {
        goodsCate.setState(UserState.COMMON.getValue());
        goodsCate.setCreateTime(new Date());
        goodsCate.setUpdateTime(goodsCate.getCreateTime());
        goodsCateMapper.insertSelective(goodsCate);
        return ResultUtil.success(null);
    }

    @Override
    public Result changeGoodsCate(GoodsCate goodsCate) {
        goodsCate.setUpdateTime(new Date());
        goodsCateMapper.updateByPrimaryKeySelective(goodsCate);
        return ResultUtil.success(null);
    }

    @Override
    public Result getGoodsList(Map map) {
        List<Goods> goodsList = goodsMapper.selectByPage(map);
        int count = goodsMapper.count(map);
        for(Goods goods : goodsList){
            GoodsCate goodsCate = goodsCateMapper.selectByPrimaryKey(goods.getCateId());
            goods.setCateName(null == goodsCate?"":goodsCate.getName());
            goods.setImage(goods.getImage());
        }
        Map dataMap = new HashMap();
        dataMap.put("goodsList",goodsList);
        dataMap.put("count",count);
        return ResultUtil.success(dataMap);
    }

    @Override
    public Result changeGoods(Goods goods) {
        goodsMapper.updateByPrimaryKeySelective(goods);
        return ResultUtil.success(null);
    }

    @Override
    public Result deleteGoods(Integer pkId) {
        goodsMapper.deleteByPrimaryKey(pkId);
        return ResultUtil.success(null);
    }
}
