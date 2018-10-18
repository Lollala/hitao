package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.OrderPay;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单支付表 服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface IOrderPayService  {
    ServerResponse addOrderPay(OrderPay orderPay);

    ServerResponse addOrderPaySelective(OrderPay obj);

    ServerResponse deleteById(int payId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(OrderPay orderPay);

    ServerResponse updateSelectiveById(OrderPay orderPay);

    ServerResponse<List<OrderPay>> searchOrderPay(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<OrderPay>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<OrderPay> findOne(Integer payId);

}
