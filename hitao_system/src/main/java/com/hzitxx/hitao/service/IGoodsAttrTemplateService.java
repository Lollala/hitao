package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.GoodsAttrTemplate;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品属性模板表 服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface IGoodsAttrTemplateService  {
    ServerResponse addGoodsAttrTemplate(GoodsAttrTemplate goodsAttrTemplate);

    ServerResponse addGoodsAttrTemplateSelective(GoodsAttrTemplate obj);

    ServerResponse deleteById(int attrId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(GoodsAttrTemplate goodsAttrTemplate);

    ServerResponse updateSelectiveById(GoodsAttrTemplate goodsAttrTemplate);

    ServerResponse<List<GoodsAttrTemplate>> searchGoodsAttrTemplate(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<GoodsAttrTemplate>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<GoodsAttrTemplate> findOne(Integer attrId);

}
