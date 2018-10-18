package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.PermissionRoute;
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

public interface IPermissionRouteService  {
    ServerResponse addPermissionRoute(PermissionRoute permissionRoute);

    ServerResponse addPermissionRouteSelective(PermissionRoute obj);

    ServerResponse deleteById(int routeId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(PermissionRoute permissionRoute);

    ServerResponse updateSelectiveById(PermissionRoute permissionRoute);

    ServerResponse<List<PermissionRoute>> searchPermissionRoute(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<PermissionRoute>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<PermissionRoute> findOne(Integer routeId);

}
