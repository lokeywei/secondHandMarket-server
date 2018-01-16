package com.lokey.second.web.dao;

import com.lokey.second.web.entity.GoodsBidding;

public interface GoodsBiddingMapper {
    int deleteByPrimaryKey(Integer pkId);

    int insert(GoodsBidding record);

    int insertSelective(GoodsBidding record);

    GoodsBidding selectByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(GoodsBidding record);

    int updateByPrimaryKey(GoodsBidding record);
}