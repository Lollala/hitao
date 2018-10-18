package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.GoodsAttrGroup;
import com.hzitxx.hitao.mapper.GoodsAttrGroupMapper;
import com.hzitxx.hitao.service.IGoodsAttrGroupService;
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
 * 商品属性组 服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class GoodsAttrGroupServiceImpl implements IGoodsAttrGroupService {

    @Autowired
    private GoodsAttrGroupMapper mapper;

    @Override
    public ServerResponse addGoodsAttrGroup(GoodsAttrGroup goodsAttrGroup){
        int result =  this.mapper.addGoodsAttrGroup(goodsAttrGroup);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addGoodsAttrGroupSelective(GoodsAttrGroup goodsAttrGroup){
        int result =  this.mapper.addGoodsAttrGroupSelective(goodsAttrGroup);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int groupId){
        int result = this.mapper.deleteById(groupId);
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
    public  ServerResponse updateById(GoodsAttrGroup goodsAttrGroup){
        int result = this.mapper.updateById(goodsAttrGroup);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(GoodsAttrGroup goodsAttrGroup){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(goodsAttrGroup));
    }

    @Override
    public  ServerResponse<List<GoodsAttrGroup>> searchGoodsAttrGroup(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchGoodsAttrGroup(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<GoodsAttrGroup>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<GoodsAttrGroup>  obj=mapper.searchGoodsAttrGroup(map);
        PageInfo<GoodsAttrGroup> pageInfo=new PageInfo<>(obj);
        LayuiEntity<GoodsAttrGroup> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param groupId
     * @return
     */
    @Override
    public ServerResponse<GoodsAttrGroup> findOne(Integer groupId){
        GoodsAttrGroup goodsAttrGroup = this.mapper.findOne(groupId);
        if(goodsAttrGroup == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(goodsAttrGroup);
     }
}

