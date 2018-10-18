package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.GoodsContent;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品内容表 服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface IGoodsContentService  {
    ServerResponse addGoodsContent(GoodsContent goodsContent);

    ServerResponse addGoodsContentSelective(GoodsContent obj);

    ServerResponse deleteById(int goodsId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(GoodsContent goodsContent);

    ServerResponse updateSelectiveById(GoodsContent goodsContent);

    ServerResponse<List<GoodsContent>> searchGoodsContent(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<GoodsContent>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<GoodsContent> findOne(Integer goodsId);

}
