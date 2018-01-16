package com.lokey.second.web.dao;

import com.lokey.second.web.entity.GoodsBiddingResult;

public interface GoodsBiddingResultMapper {
    int deleteByPrimaryKey(Integer pkId);

    int insert(GoodsBiddingResult record);

    int insertSelective(GoodsBiddingResult record);

    GoodsBiddingResult selectByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(GoodsBiddingResult record);

    int updateByPrimaryKey(GoodsBiddingResult record);
}