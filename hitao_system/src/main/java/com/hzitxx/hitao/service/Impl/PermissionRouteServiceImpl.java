package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.PermissionRoute;
import com.hzitxx.hitao.mapper.PermissionRouteMapper;
import com.hzitxx.hitao.service.IPermissionRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class PermissionRouteServiceImpl implements IPermissionRouteService {

    @Autowired
    private PermissionRouteMapper mapper;

    @Override
    public ServerResponse addPermissionRoute(PermissionRoute permissionRoute){
        int result =  this.mapper.addPermissionRoute(permissionRoute);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addPermissionRouteSelective(PermissionRoute permissionRoute){
        int result =  this.mapper.addPermissionRouteSelective(permissionRoute);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int routeId){
        int result = this.mapper.deleteById(routeId);
        if(result != 1){
            return ServerResponse.createByErrorMessage("删除失败!");
        }
        return ServerResponse.createBySuccessMessage("删除成功!");
    }

    @Override
    public ServerResponse deleteByIds(String[]ids){
        int result = this.mapper.deleteByIds(ids);
        if(result != 0){
            return ServerResponse.createByErrorMessage("批量删除失败!");
        }
        return ServerResponse.createBySuccessMessage("批量删除成功!");
    }

    @Override
    public  ServerResponse updateById(PermissionRoute permissionRoute){
        int result = this.mapper.updateById(permissionRoute);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(PermissionRoute permissionRoute){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(permissionRoute));
    }

    @Override
    public  ServerResponse<List<PermissionRoute>> searchPermissionRoute(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchPermissionRoute(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<PermissionRoute>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<PermissionRoute>  obj=mapper.searchPermissionRoute(map);
        PageInfo<PermissionRoute> pageInfo=new PageInfo<>(obj);
        LayuiEntity<PermissionRoute> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param routeId
     * @return
     */
    @Override
    public ServerResponse<PermissionRoute> findOne(Integer routeId){
        PermissionRoute permissionRoute = this.mapper.findOne(routeId);
        if(permissionRoute == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(permissionRoute);
     }
}

