package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.GoodsImages;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品图片 服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface IGoodsImagesService  {
    ServerResponse addGoodsImages(GoodsImages goodsImages);

    ServerResponse addGoodsImagesSelective(GoodsImages obj);

    ServerResponse deleteById(int goodsImageId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(GoodsImages goodsImages);

    ServerResponse updateSelectiveById(GoodsImages goodsImages);

    ServerResponse<List<GoodsImages>> searchGoodsImages(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<GoodsImages>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<GoodsImages> findOne(Integer goodsImageId);

}
