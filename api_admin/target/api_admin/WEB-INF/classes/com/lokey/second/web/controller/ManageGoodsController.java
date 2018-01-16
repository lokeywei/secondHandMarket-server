package com.lokey.second.web.controller;

import com.lokey.second.web.constant.ParamConstant;
import com.lokey.second.web.entity.Goods;
import com.lokey.second.web.entity.GoodsCate;
import com.lokey.second.web.enums.UserState;
import com.lokey.second.web.result.Result;
import com.lokey.second.web.result.ResultUtil;
import com.lokey.second.web.service.ManageGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by lokey on 2018/1/12.
 */
@RestController
@RequestMapping(value = "managegoods")
public class ManageGoodsController {
    @Autowired
    private ManageGoodsService manageGoodsService;

    @PostMapping(value = "/getGoodsApplicationList")
    public Result getGoodsApplicationList(@RequestBody Map map){
        if(null == map.get(ParamConstant.PAGE_START)||null == map.get(ParamConstant.PAGE_END)){
            return ResultUtil.error("参数不全");
        }
        map.put(ParamConstant.IS_CHECKED, UserState.NOT_CHECKED.getValue()); //筛选条件
        return manageGoodsService.getGoodsList(map);
    }

    @PostMapping(value = "/changeGoods")
    public Result changeGoods(@RequestBody Goods goods){
        return manageGoodsService.changeGoods(goods);
    }

    @PostMapping(value = "/deleteGoods")
    public Result deleteGoods(@RequestParam(value = "pkId", required = false) Integer pkId){
        return manageGoodsService.deleteGoods(pkId);
    }

    @PostMapping(value = "/getGoodsCateList")
    public Result getGoodsCateList(@RequestBody Map map){
        return manageGoodsService.getGoodsCateList(map);
    }

    @PostMapping(value = "/changeGoodsCate")
    public Result changeGoodsCate(@RequestBody GoodsCate goodsCate){
        if(null == goodsCate.getPkId() || goodsCate.getPkId().equals(0)){
            goodsCate.setPkId(null);
            return manageGoodsService.addGoodsCate(goodsCate);
        }
        return manageGoodsService.changeGoodsCate(goodsCate);
    }


    @PostMapping(value = "/getGoodsList")
    public Result getGoodsList(@RequestBody Map map){
        if(null == map.get(ParamConstant.PAGE_START)||null == map.get(ParamConstant.PAGE_END)){
            return ResultUtil.error("参数不全");
        }
        map.put(ParamConstant.IS_CHECKED, UserState.COMMON.getValue());
        return manageGoodsService.getGoodsList(map);
    }


}
