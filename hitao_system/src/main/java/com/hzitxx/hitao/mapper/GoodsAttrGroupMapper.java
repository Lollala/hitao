package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.GoodsAttrGroup;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品属性组 Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface GoodsAttrGroupMapper{

    int addGoodsAttrGroup(GoodsAttrGroup obj);

    int addGoodsAttrGroupSelective(GoodsAttrGroup obj);

    int deleteById(int groupId);
                    
    int deleteByIds(String[] ids);

    int updateById(GoodsAttrGroup goodsAttrGroup);

    int updateSelectiveById(GoodsAttrGroup goodsAttrGroup);

    GoodsAttrGroup findOne(Integer groupId);
                    
    List<GoodsAttrGroup> searchGoodsAttrGroup(Map<String,Object> map);
}