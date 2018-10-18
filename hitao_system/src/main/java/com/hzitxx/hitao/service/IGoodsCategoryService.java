package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.GoodsCategory;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品分类表 服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface IGoodsCategoryService  {
    ServerResponse addGoodsCategory(GoodsCategory goodsCategory);

    ServerResponse addGoodsCategorySelective(GoodsCategory obj);

    ServerResponse deleteById(int catId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(GoodsCategory goodsCategory);

    ServerResponse updateSelectiveById(GoodsCategory goodsCategory);

    ServerResponse<List<GoodsCategory>> searchGoodsCategory(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<GoodsCategory>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<GoodsCategory> findOne(Integer catId);

}
