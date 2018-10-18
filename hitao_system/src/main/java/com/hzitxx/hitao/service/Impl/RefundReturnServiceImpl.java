package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.RefundReturn;
import com.hzitxx.hitao.mapper.RefundReturnMapper;
import com.hzitxx.hitao.service.IRefundReturnService;
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
 * 退款退货表 服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class RefundReturnServiceImpl implements IRefundReturnService {

    @Autowired
    private RefundReturnMapper mapper;

    @Override
    public ServerResponse addRefundReturn(RefundReturn refundReturn){
        int result =  this.mapper.addRefundReturn(refundReturn);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addRefundReturnSelective(RefundReturn refundReturn){
        int result =  this.mapper.addRefundReturnSelective(refundReturn);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int refundId){
        int result = this.mapper.deleteById(refundId);
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
    public  ServerResponse updateById(RefundReturn refundReturn){
        int result = this.mapper.updateById(refundReturn);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(RefundReturn refundReturn){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(refundReturn));
    }

    @Override
    public  ServerResponse<List<RefundReturn>> searchRefundReturn(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchRefundReturn(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<RefundReturn>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<RefundReturn>  obj=mapper.searchRefundReturn(map);
        PageInfo<RefundReturn> pageInfo=new PageInfo<>(obj);
        LayuiEntity<RefundReturn> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param refundId
     * @return
     */
    @Override
    public ServerResponse<RefundReturn> findOne(Integer refundId){
        RefundReturn refundReturn = this.mapper.findOne(refundId);
        if(refundReturn == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(refundReturn);
     }
}

