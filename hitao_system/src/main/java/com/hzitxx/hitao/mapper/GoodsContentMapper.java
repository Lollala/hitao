package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.GoodsContent;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品内容表 Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface GoodsContentMapper{

    int addGoodsContent(GoodsContent obj);

    int addGoodsContentSelective(GoodsContent obj);

    int deleteById(int goodsId);
                
    int deleteByIds(String[] ids);

    int updateById(GoodsContent goodsContent);

    int updateSelectiveById(GoodsContent goodsContent);

    GoodsContent findOne(Integer goodsId);
                
    List<GoodsContent> searchGoodsContent(Map<String,Object> map);
}