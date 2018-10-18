package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.OffpayArea;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 货到付款支持地区表 服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface IOffpayAreaService  {
    ServerResponse addOffpayArea(OffpayArea offpayArea);

    ServerResponse addOffpayAreaSelective(OffpayArea obj);


    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(OffpayArea offpayArea);

    ServerResponse updateSelectiveById(OffpayArea offpayArea);

    ServerResponse<List<OffpayArea>> searchOffpayArea(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<OffpayArea>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */

}
