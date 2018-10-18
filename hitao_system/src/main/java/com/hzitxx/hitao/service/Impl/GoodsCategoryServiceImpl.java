package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.GoodsCategory;
import com.hzitxx.hitao.mapper.GoodsCategoryMapper;
import com.hzitxx.hitao.service.IGoodsCategoryService;
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
 * 商品分类表 服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class GoodsCategoryServiceImpl implements IGoodsCategoryService {

    @Autowired
    private GoodsCategoryMapper mapper;

    @Override
    public ServerResponse addGoodsCategory(GoodsCategory goodsCategory){
        int result =  this.mapper.addGoodsCategory(goodsCategory);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addGoodsCategorySelective(GoodsCategory goodsCategory){
        int result =  this.mapper.addGoodsCategorySelective(goodsCategory);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int catId){
        int result = this.mapper.deleteById(catId);
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
    public  ServerResponse updateById(GoodsCategory goodsCategory){
        int result = this.mapper.updateById(goodsCategory);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(GoodsCategory goodsCategory){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(goodsCategory));
    }

    @Override
    public  ServerResponse<List<GoodsCategory>> searchGoodsCategory(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchGoodsCategory(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<GoodsCategory>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<GoodsCategory>  obj=mapper.searchGoodsCategory(map);
        PageInfo<GoodsCategory> pageInfo=new PageInfo<>(obj);
        LayuiEntity<GoodsCategory> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param catId
     * @return
     */
    @Override
    public ServerResponse<GoodsCategory> findOne(Integer catId){
        GoodsCategory goodsCategory = this.mapper.findOne(catId);
        if(goodsCategory == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(goodsCategory);
     }
}

