package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.OrderCommon;
import com.hzitxx.hitao.mapper.OrderCommonMapper;
import com.hzitxx.hitao.service.IOrderCommonService;
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
 * 订单公共信息
 服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class OrderCommonServiceImpl implements IOrderCommonService {

    @Autowired
    private OrderCommonMapper mapper;

    @Override
    public ServerResponse addOrderCommon(OrderCommon orderCommon){
        int result =  this.mapper.addOrderCommon(orderCommon);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addOrderCommonSelective(OrderCommon orderCommon){
        int result =  this.mapper.addOrderCommonSelective(orderCommon);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int orderId){
        int result = this.mapper.deleteById(orderId);
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
    public  ServerResponse updateById(OrderCommon orderCommon){
        int result = this.mapper.updateById(orderCommon);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(OrderCommon orderCommon){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(orderCommon));
    }

    @Override
    public  ServerResponse<List<OrderCommon>> searchOrderCommon(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchOrderCommon(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<OrderCommon>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<OrderCommon>  obj=mapper.searchOrderCommon(map);
        PageInfo<OrderCommon> pageInfo=new PageInfo<>(obj);
        LayuiEntity<OrderCommon> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param orderId
     * @return
     */
    @Override
    public ServerResponse<OrderCommon> findOne(Integer orderId){
        OrderCommon orderCommon = this.mapper.findOne(orderId);
        if(orderCommon == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(orderCommon);
     }
}

