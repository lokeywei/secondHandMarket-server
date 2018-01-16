package com.lokey.second.web.dao;

import com.lokey.second.web.entity.GoodsCate;
import java.util.List;
import java.util.Map;

public interface GoodsCateMapper {
    int deleteByPrimaryKey(Integer pkId);

    int insert(GoodsCate record);

    int insertSelective(GoodsCate record);

    GoodsCate selectByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(GoodsCate record);

    int updateByPrimaryKey(GoodsCate record);

    List<GoodsCate> selectByPage(Map map);

    int count(Map map);
}