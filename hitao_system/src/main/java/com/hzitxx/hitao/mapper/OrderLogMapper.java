package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.OrderLog;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单处理历史表 Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface OrderLogMapper{

    int addOrderLog(OrderLog obj);

    int addOrderLogSelective(OrderLog obj);

    int deleteById(int logId);
                            
    int deleteByIds(String[] ids);

    int updateById(OrderLog orderLog);

    int updateSelectiveById(OrderLog orderLog);

    OrderLog findOne(Integer logId);
                            
    List<OrderLog> searchOrderLog(Map<String,Object> map);
}