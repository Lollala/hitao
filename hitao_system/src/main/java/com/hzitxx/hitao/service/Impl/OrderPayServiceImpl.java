package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.OrderPay;
import com.hzitxx.hitao.mapper.OrderPayMapper;
import com.hzitxx.hitao.service.IOrderPayService;
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
 * 订单支付表 服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class OrderPayServiceImpl implements IOrderPayService {

    @Autowired
    private OrderPayMapper mapper;

    @Override
    public ServerResponse addOrderPay(OrderPay orderPay){
        int result =  this.mapper.addOrderPay(orderPay);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addOrderPaySelective(OrderPay orderPay){
        int result =  this.mapper.addOrderPaySelective(orderPay);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int payId){
        int result = this.mapper.deleteById(payId);
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
    public  ServerResponse updateById(OrderPay orderPay){
        int result = this.mapper.updateById(orderPay);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(OrderPay orderPay){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(orderPay));
    }

    @Override
    public  ServerResponse<List<OrderPay>> searchOrderPay(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchOrderPay(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<OrderPay>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<OrderPay>  obj=mapper.searchOrderPay(map);
        PageInfo<OrderPay> pageInfo=new PageInfo<>(obj);
        LayuiEntity<OrderPay> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param payId
     * @return
     */
    @Override
    public ServerResponse<OrderPay> findOne(Integer payId){
        OrderPay orderPay = this.mapper.findOne(payId);
        if(orderPay == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(orderPay);
     }
}

