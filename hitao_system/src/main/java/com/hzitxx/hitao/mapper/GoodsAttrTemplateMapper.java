package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.GoodsAttrTemplate;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品属性模板表 Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface GoodsAttrTemplateMapper{

    int addGoodsAttrTemplate(GoodsAttrTemplate obj);

    int addGoodsAttrTemplateSelective(GoodsAttrTemplate obj);

    int deleteById(int attrId);
                        
    int deleteByIds(String[] ids);

    int updateById(GoodsAttrTemplate goodsAttrTemplate);

    int updateSelectiveById(GoodsAttrTemplate goodsAttrTemplate);

    GoodsAttrTemplate findOne(Integer attrId);
                        
    List<GoodsAttrTemplate> searchGoodsAttrTemplate(Map<String,Object> map);
}