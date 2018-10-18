package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.TypeBrand;
import com.hzitxx.hitao.mapper.TypeBrandMapper;
import com.hzitxx.hitao.service.ITypeBrandService;
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
 * 商品类型与品牌对应表 服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class TypeBrandServiceImpl implements ITypeBrandService {

    @Autowired
    private TypeBrandMapper mapper;

    @Override
    public ServerResponse addTypeBrand(TypeBrand typeBrand){
        int result =  this.mapper.addTypeBrand(typeBrand);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addTypeBrandSelective(TypeBrand typeBrand){
        int result =  this.mapper.addTypeBrandSelective(typeBrand);
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
    public  ServerResponse updateById(TypeBrand typeBrand){
        int result = this.mapper.updateById(typeBrand);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(TypeBrand typeBrand){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(typeBrand));
    }

    @Override
    public  ServerResponse<List<TypeBrand>> searchTypeBrand(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchTypeBrand(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<TypeBrand>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<TypeBrand>  obj=mapper.searchTypeBrand(map);
        PageInfo<TypeBrand> pageInfo=new PageInfo<>(obj);
        LayuiEntity<TypeBrand> layuiEntity=new LayuiEntity<>();
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

