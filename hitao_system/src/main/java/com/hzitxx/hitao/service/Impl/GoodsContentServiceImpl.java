package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.GoodsContent;
import com.hzitxx.hitao.mapper.GoodsContentMapper;
import com.hzitxx.hitao.service.IGoodsContentService;
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
 * 商品内容表 服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class GoodsContentServiceImpl implements IGoodsContentService {

    @Autowired
    private GoodsContentMapper mapper;

    @Override
    public ServerResponse addGoodsContent(GoodsContent goodsContent){
        int result =  this.mapper.addGoodsContent(goodsContent);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addGoodsContentSelective(GoodsContent goodsContent){
        int result =  this.mapper.addGoodsContentSelective(goodsContent);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int goodsId){
        int result = this.mapper.deleteById(goodsId);
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
    public  ServerResponse updateById(GoodsContent goodsContent){
        int result = this.mapper.updateById(goodsContent);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(GoodsContent goodsContent){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(goodsContent));
    }

    @Override
    public  ServerResponse<List<GoodsContent>> searchGoodsContent(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchGoodsContent(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<GoodsContent>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<GoodsContent>  obj=mapper.searchGoodsContent(map);
        PageInfo<GoodsContent> pageInfo=new PageInfo<>(obj);
        LayuiEntity<GoodsContent> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param goodsId
     * @return
     */
    @Override
    public ServerResponse<GoodsContent> findOne(Integer goodsId){
        GoodsContent goodsContent = this.mapper.findOne(goodsId);
        if(goodsContent == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(goodsContent);
     }
}

