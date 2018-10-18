package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.OrderGoods;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单商品表 Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface OrderGoodsMapper{

    int addOrderGoods(OrderGoods obj);

    int addOrderGoodsSelective(OrderGoods obj);

    int deleteById(int recId);
                                                            
    int deleteByIds(String[] ids);

    int updateById(OrderGoods orderGoods);

    int updateSelectiveById(OrderGoods orderGoods);

    OrderGoods findOne(Integer recId);
                                                            
    List<OrderGoods> searchOrderGoods(Map<String,Object> map);
}