package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.OffpayArea;
import com.hzitxx.hitao.mapper.OffpayAreaMapper;
import com.hzitxx.hitao.service.IOffpayAreaService;
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
 * 货到付款支持地区表 服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class OffpayAreaServiceImpl implements IOffpayAreaService {

    @Autowired
    private OffpayAreaMapper mapper;

    @Override
    public ServerResponse addOffpayArea(OffpayArea offpayArea){
        int result =  this.mapper.addOffpayArea(offpayArea);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addOffpayAreaSelective(OffpayArea offpayArea){
        int result =  this.mapper.addOffpayAreaSelective(offpayArea);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
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
    public  ServerResponse updateById(OffpayArea offpayArea){
        int result = this.mapper.updateById(offpayArea);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(OffpayArea offpayArea){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(offpayArea));
    }

    @Override
    public  ServerResponse<List<OffpayArea>> searchOffpayArea(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchOffpayArea(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<OffpayArea>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<OffpayArea>  obj=mapper.searchOffpayArea(map);
        PageInfo<OffpayArea> pageInfo=new PageInfo<>(obj);
        LayuiEntity<OffpayArea> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param 
     * @return
     */
}

