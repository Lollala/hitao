package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.RefundReturn;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 退款退货表 Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface RefundReturnMapper{

    int addRefundReturn(RefundReturn obj);

    int addRefundReturnSelective(RefundReturn obj);

    int deleteById(int refundId);
                                                                                                                                        
    int deleteByIds(String[] ids);

    int updateById(RefundReturn refundReturn);

    int updateSelectiveById(RefundReturn refundReturn);

    RefundReturn findOne(Integer refundId);
                                                                                                                                        
    List<RefundReturn> searchRefundReturn(Map<String,Object> map);
}