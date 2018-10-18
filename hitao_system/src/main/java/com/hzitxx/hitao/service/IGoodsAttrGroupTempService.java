package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.GoodsAttrGroupTemp;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 属性和属性组中间表 服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface IGoodsAttrGroupTempService  {
    ServerResponse addGoodsAttrGroupTemp(GoodsAttrGroupTemp goodsAttrGroupTemp);

    ServerResponse addGoodsAttrGroupTempSelective(GoodsAttrGroupTemp obj);

    ServerResponse deleteById(int id);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(GoodsAttrGroupTemp goodsAttrGroupTemp);

    ServerResponse updateSelectiveById(GoodsAttrGroupTemp goodsAttrGroupTemp);

    ServerResponse<List<GoodsAttrGroupTemp>> searchGoodsAttrGroupTemp(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<GoodsAttrGroupTemp>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<GoodsAttrGroupTemp> findOne(Integer id);

}
