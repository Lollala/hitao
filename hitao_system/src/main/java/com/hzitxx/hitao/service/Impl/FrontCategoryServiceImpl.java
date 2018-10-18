package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.FrontCategory;
import com.hzitxx.hitao.mapper.FrontCategoryMapper;
import com.hzitxx.hitao.service.IFrontCategoryService;
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
 *  服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class FrontCategoryServiceImpl implements IFrontCategoryService {

    @Autowired
    private FrontCategoryMapper mapper;

    @Override
    public ServerResponse addFrontCategory(FrontCategory frontCategory){
        int result =  this.mapper.addFrontCategory(frontCategory);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addFrontCategorySelective(FrontCategory frontCategory){
        int result =  this.mapper.addFrontCategorySelective(frontCategory);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int frontCatId){
        int result = this.mapper.deleteById(frontCatId);
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
    public  ServerResponse updateById(FrontCategory frontCategory){
        int result = this.mapper.updateById(frontCategory);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(FrontCategory frontCategory){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(frontCategory));
    }

    @Override
    public  ServerResponse<List<FrontCategory>> searchFrontCategory(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchFrontCategory(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<FrontCategory>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<FrontCategory>  obj=mapper.searchFrontCategory(map);
        PageInfo<FrontCategory> pageInfo=new PageInfo<>(obj);
        LayuiEntity<FrontCategory> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param frontCatId
     * @return
     */
    @Override
    public ServerResponse<FrontCategory> findOne(Integer frontCatId){
        FrontCategory frontCategory = this.mapper.findOne(frontCatId);
        if(frontCategory == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(frontCategory);
     }
}

