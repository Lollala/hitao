package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.AdvPosition;
import com.hzitxx.hitao.mapper.AdvPositionMapper;
import com.hzitxx.hitao.service.IAdvPositionService;
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
 * 广告位表 服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class AdvPositionServiceImpl implements IAdvPositionService {

    @Autowired
    private AdvPositionMapper mapper;

    @Override
    public ServerResponse addAdvPosition(AdvPosition advPosition){
        int result =  this.mapper.addAdvPosition(advPosition);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addAdvPositionSelective(AdvPosition advPosition){
        int result =  this.mapper.addAdvPositionSelective(advPosition);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int apId){
        int result = this.mapper.deleteById(apId);
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
    public  ServerResponse updateById(AdvPosition advPosition){
        int result = this.mapper.updateById(advPosition);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(AdvPosition advPosition){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(advPosition));
    }

    @Override
    public  ServerResponse<List<AdvPosition>> searchAdvPosition(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchAdvPosition(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<AdvPosition>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<AdvPosition>  obj=mapper.searchAdvPosition(map);
        PageInfo<AdvPosition> pageInfo=new PageInfo<>(obj);
        LayuiEntity<AdvPosition> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param apId
     * @return
     */
    @Override
    public ServerResponse<AdvPosition> findOne(Integer apId){
        AdvPosition advPosition = this.mapper.findOne(apId);
        if(advPosition == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(advPosition);
     }
}

