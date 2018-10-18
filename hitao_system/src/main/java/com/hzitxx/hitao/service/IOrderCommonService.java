package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.OrderCommon;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单公共信息
 服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface IOrderCommonService  {
    ServerResponse addOrderCommon(OrderCommon orderCommon);

    ServerResponse addOrderCommonSelective(OrderCommon obj);

    ServerResponse deleteById(int orderId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(OrderCommon orderCommon);

    ServerResponse updateSelectiveById(OrderCommon orderCommon);

    ServerResponse<List<OrderCommon>> searchOrderCommon(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<OrderCommon>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<OrderCommon> findOne(Integer orderId);

}
