package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.OrderLog;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单处理历史表 服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface IOrderLogService  {
    ServerResponse addOrderLog(OrderLog orderLog);

    ServerResponse addOrderLogSelective(OrderLog obj);

    ServerResponse deleteById(int logId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(OrderLog orderLog);

    ServerResponse updateSelectiveById(OrderLog orderLog);

    ServerResponse<List<OrderLog>> searchOrderLog(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<OrderLog>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<OrderLog> findOne(Integer logId);

}
