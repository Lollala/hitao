package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.RefundReturn;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 退款退货表 服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface IRefundReturnService  {
    ServerResponse addRefundReturn(RefundReturn refundReturn);

    ServerResponse addRefundReturnSelective(RefundReturn obj);

    ServerResponse deleteById(int refundId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(RefundReturn refundReturn);

    ServerResponse updateSelectiveById(RefundReturn refundReturn);

    ServerResponse<List<RefundReturn>> searchRefundReturn(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<RefundReturn>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<RefundReturn> findOne(Integer refundId);

}
