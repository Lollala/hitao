package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.OrderCommon;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单公共信息
 Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface OrderCommonMapper{

    int addOrderCommon(OrderCommon obj);

    int addOrderCommonSelective(OrderCommon obj);

    int deleteById(int orderId);
                                                                    
    int deleteByIds(String[] ids);

    int updateById(OrderCommon orderCommon);

    int updateSelectiveById(OrderCommon orderCommon);

    OrderCommon findOne(Integer orderId);
                                                                    
    List<OrderCommon> searchOrderCommon(Map<String,Object> map);
}