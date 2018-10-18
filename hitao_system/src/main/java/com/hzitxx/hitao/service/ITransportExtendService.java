package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.TransportExtend;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 运费模板扩展表 服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface ITransportExtendService  {
    ServerResponse addTransportExtend(TransportExtend transportExtend);

    ServerResponse addTransportExtendSelective(TransportExtend obj);

    ServerResponse deleteById(int id);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(TransportExtend transportExtend);

    ServerResponse updateSelectiveById(TransportExtend transportExtend);

    ServerResponse<List<TransportExtend>> searchTransportExtend(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<TransportExtend>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<TransportExtend> findOne(Integer id);

}
