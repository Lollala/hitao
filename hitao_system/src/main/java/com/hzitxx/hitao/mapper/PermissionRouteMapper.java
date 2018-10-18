package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.PermissionRoute;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface PermissionRouteMapper{

    int addPermissionRoute(PermissionRoute obj);

    int addPermissionRouteSelective(PermissionRoute obj);

    int deleteById(int routeId);
                            
    int deleteByIds(String[] ids);

    int updateById(PermissionRoute permissionRoute);

    int updateSelectiveById(PermissionRoute permissionRoute);

    PermissionRoute findOne(Integer routeId);
                            
    List<PermissionRoute> searchPermissionRoute(Map<String,Object> map);
}