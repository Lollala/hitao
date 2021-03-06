package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.OrderGoods;
import com.hzitxx.hitao.mapper.OrderGoodsMapper;
import com.hzitxx.hitao.service.IOrderGoodsService;
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
 * 订单商品表 服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class OrderGoodsServiceImpl implements IOrderGoodsService {

    @Autowired
    private OrderGoodsMapper mapper;

    @Override
    public ServerResponse addOrderGoods(OrderGoods orderGoods){
        int result =  this.mapper.addOrderGoods(orderGoods);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addOrderGoodsSelective(OrderGoods orderGoods){
        int result =  this.mapper.addOrderGoodsSelective(orderGoods);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int recId){
        int result = this.mapper.deleteById(recId);
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
    public  ServerResponse updateById(OrderGoods orderGoods){
        int result = this.mapper.updateById(orderGoods);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(OrderGoods orderGoods){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(orderGoods));
    }

    @Override
    public  ServerResponse<List<OrderGoods>> searchOrderGoods(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchOrderGoods(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<OrderGoods>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<OrderGoods>  obj=mapper.searchOrderGoods(map);
        PageInfo<OrderGoods> pageInfo=new PageInfo<>(obj);
        LayuiEntity<OrderGoods> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param recId
     * @return
     */
    @Override
    public ServerResponse<OrderGoods> findOne(Integer recId){
        OrderGoods orderGoods = this.mapper.findOne(recId);
        if(orderGoods == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(orderGoods);
     }
}

