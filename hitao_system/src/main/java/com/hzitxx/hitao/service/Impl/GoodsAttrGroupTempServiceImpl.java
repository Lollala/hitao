package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.GoodsAttrGroupTemp;
import com.hzitxx.hitao.mapper.GoodsAttrGroupTempMapper;
import com.hzitxx.hitao.service.IGoodsAttrGroupTempService;
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
 * 属性和属性组中间表 服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class GoodsAttrGroupTempServiceImpl implements IGoodsAttrGroupTempService {

    @Autowired
    private GoodsAttrGroupTempMapper mapper;

    @Override
    public ServerResponse addGoodsAttrGroupTemp(GoodsAttrGroupTemp goodsAttrGroupTemp){
        int result =  this.mapper.addGoodsAttrGroupTemp(goodsAttrGroupTemp);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addGoodsAttrGroupTempSelective(GoodsAttrGroupTemp goodsAttrGroupTemp){
        int result =  this.mapper.addGoodsAttrGroupTempSelective(goodsAttrGroupTemp);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int id){
        int result = this.mapper.deleteById(id);
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
    public  ServerResponse updateById(GoodsAttrGroupTemp goodsAttrGroupTemp){
        int result = this.mapper.updateById(goodsAttrGroupTemp);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(GoodsAttrGroupTemp goodsAttrGroupTemp){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(goodsAttrGroupTemp));
    }

    @Override
    public  ServerResponse<List<GoodsAttrGroupTemp>> searchGoodsAttrGroupTemp(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchGoodsAttrGroupTemp(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<GoodsAttrGroupTemp>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<GoodsAttrGroupTemp>  obj=mapper.searchGoodsAttrGroupTemp(map);
        PageInfo<GoodsAttrGroupTemp> pageInfo=new PageInfo<>(obj);
        LayuiEntity<GoodsAttrGroupTemp> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public ServerResponse<GoodsAttrGroupTemp> findOne(Integer id){
        GoodsAttrGroupTemp goodsAttrGroupTemp = this.mapper.findOne(id);
        if(goodsAttrGroupTemp == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(goodsAttrGroupTemp);
     }
}

