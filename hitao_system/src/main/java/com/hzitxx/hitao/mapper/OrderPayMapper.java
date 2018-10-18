package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.OrderPay;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单支付表 Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface OrderPayMapper{

    int addOrderPay(OrderPay obj);

    int addOrderPaySelective(OrderPay obj);

    int deleteById(int payId);
                
    int deleteByIds(String[] ids);

    int updateById(OrderPay orderPay);

    int updateSelectiveById(OrderPay orderPay);

    OrderPay findOne(Integer payId);
                
    List<OrderPay> searchOrderPay(Map<String,Object> map);
}