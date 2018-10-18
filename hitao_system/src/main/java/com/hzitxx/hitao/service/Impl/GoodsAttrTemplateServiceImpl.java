package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.GoodsAttrTemplate;
import com.hzitxx.hitao.mapper.GoodsAttrTemplateMapper;
import com.hzitxx.hitao.service.IGoodsAttrTemplateService;
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
 * 商品属性模板表 服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class GoodsAttrTemplateServiceImpl implements IGoodsAttrTemplateService {

    @Autowired
    private GoodsAttrTemplateMapper mapper;

    @Override
    public ServerResponse addGoodsAttrTemplate(GoodsAttrTemplate goodsAttrTemplate){
        int result =  this.mapper.addGoodsAttrTemplate(goodsAttrTemplate);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addGoodsAttrTemplateSelective(GoodsAttrTemplate goodsAttrTemplate){
        int result =  this.mapper.addGoodsAttrTemplateSelective(goodsAttrTemplate);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int attrId){
        int result = this.mapper.deleteById(attrId);
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
    public  ServerResponse updateById(GoodsAttrTemplate goodsAttrTemplate){
        int result = this.mapper.updateById(goodsAttrTemplate);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(GoodsAttrTemplate goodsAttrTemplate){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(goodsAttrTemplate));
    }

    @Override
    public  ServerResponse<List<GoodsAttrTemplate>> searchGoodsAttrTemplate(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchGoodsAttrTemplate(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<GoodsAttrTemplate>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<GoodsAttrTemplate>  obj=mapper.searchGoodsAttrTemplate(map);
        PageInfo<GoodsAttrTemplate> pageInfo=new PageInfo<>(obj);
        LayuiEntity<GoodsAttrTemplate> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param attrId
     * @return
     */
    @Override
    public ServerResponse<GoodsAttrTemplate> findOne(Integer attrId){
        GoodsAttrTemplate goodsAttrTemplate = this.mapper.findOne(attrId);
        if(goodsAttrTemplate == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(goodsAttrTemplate);
     }
}

