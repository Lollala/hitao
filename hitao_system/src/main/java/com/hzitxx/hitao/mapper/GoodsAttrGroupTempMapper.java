package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.GoodsAttrGroupTemp;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 属性和属性组中间表 Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface GoodsAttrGroupTempMapper{

    int addGoodsAttrGroupTemp(GoodsAttrGroupTemp obj);

    int addGoodsAttrGroupTempSelective(GoodsAttrGroupTemp obj);

    int deleteById(int id);
            
    int deleteByIds(String[] ids);

    int updateById(GoodsAttrGroupTemp goodsAttrGroupTemp);

    int updateSelectiveById(GoodsAttrGroupTemp goodsAttrGroupTemp);

    GoodsAttrGroupTemp findOne(Integer id);
            
    List<GoodsAttrGroupTemp> searchGoodsAttrGroupTemp(Map<String,Object> map);
}