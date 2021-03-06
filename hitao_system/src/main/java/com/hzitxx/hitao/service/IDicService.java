package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.Dic;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface IDicService  {
    ServerResponse addDic(Dic dic);

    ServerResponse addDicSelective(Dic obj);


    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(Dic dic);

    ServerResponse updateSelectiveById(Dic dic);

    ServerResponse<List<Dic>> searchDic(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<Dic>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */

}
