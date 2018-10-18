package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.OrderGoods;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单商品表 服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface IOrderGoodsService  {
    ServerResponse addOrderGoods(OrderGoods orderGoods);

    ServerResponse addOrderGoodsSelective(OrderGoods obj);

    ServerResponse deleteById(int recId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(OrderGoods orderGoods);

    ServerResponse updateSelectiveById(OrderGoods orderGoods);

    ServerResponse<List<OrderGoods>> searchOrderGoods(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<OrderGoods>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<OrderGoods> findOne(Integer recId);

}
