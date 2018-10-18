package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.GoodsAttrGroup;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品属性组 服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface IGoodsAttrGroupService  {
    ServerResponse addGoodsAttrGroup(GoodsAttrGroup goodsAttrGroup);

    ServerResponse addGoodsAttrGroupSelective(GoodsAttrGroup obj);

    ServerResponse deleteById(int groupId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(GoodsAttrGroup goodsAttrGroup);

    ServerResponse updateSelectiveById(GoodsAttrGroup goodsAttrGroup);

    ServerResponse<List<GoodsAttrGroup>> searchGoodsAttrGroup(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<GoodsAttrGroup>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<GoodsAttrGroup> findOne(Integer groupId);

}
