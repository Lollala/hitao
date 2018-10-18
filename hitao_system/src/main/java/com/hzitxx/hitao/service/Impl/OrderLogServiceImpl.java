package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.OrderLog;
import com.hzitxx.hitao.mapper.OrderLogMapper;
import com.hzitxx.hitao.service.IOrderLogService;
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
 * 订单处理历史表 服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class OrderLogServiceImpl implements IOrderLogService {

    @Autowired
    private OrderLogMapper mapper;

    @Override
    public ServerResponse addOrderLog(OrderLog orderLog){
        int result =  this.mapper.addOrderLog(orderLog);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addOrderLogSelective(OrderLog orderLog){
        int result =  this.mapper.addOrderLogSelective(orderLog);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int logId){
        int result = this.mapper.deleteById(logId);
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
    public  ServerResponse updateById(OrderLog orderLog){
        int result = this.mapper.updateById(orderLog);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(OrderLog orderLog){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(orderLog));
    }

    @Override
    public  ServerResponse<List<OrderLog>> searchOrderLog(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchOrderLog(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<OrderLog>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<OrderLog>  obj=mapper.searchOrderLog(map);
        PageInfo<OrderLog> pageInfo=new PageInfo<>(obj);
        LayuiEntity<OrderLog> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param logId
     * @return
     */
    @Override
    public ServerResponse<OrderLog> findOne(Integer logId){
        OrderLog orderLog = this.mapper.findOne(logId);
        if(orderLog == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(orderLog);
     }
}

