package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.ArticleClass;
import com.hzitxx.hitao.mapper.ArticleClassMapper;
import com.hzitxx.hitao.service.IArticleClassService;
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
 * 文章分类表 服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class ArticleClassServiceImpl implements IArticleClassService {

    @Autowired
    private ArticleClassMapper mapper;

    @Override
    public ServerResponse addArticleClass(ArticleClass articleClass){
        int result =  this.mapper.addArticleClass(articleClass);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addArticleClassSelective(ArticleClass articleClass){
        int result =  this.mapper.addArticleClassSelective(articleClass);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int acId){
        int result = this.mapper.deleteById(acId);
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
    public  ServerResponse updateById(ArticleClass articleClass){
        int result = this.mapper.updateById(articleClass);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(ArticleClass articleClass){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(articleClass));
    }

    @Override
    public  ServerResponse<List<ArticleClass>> searchArticleClass(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchArticleClass(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<ArticleClass>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<ArticleClass>  obj=mapper.searchArticleClass(map);
        PageInfo<ArticleClass> pageInfo=new PageInfo<>(obj);
        LayuiEntity<ArticleClass> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param acId
     * @return
     */
    @Override
    public ServerResponse<ArticleClass> findOne(Integer acId){
        ArticleClass articleClass = this.mapper.findOne(acId);
        if(articleClass == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(articleClass);
     }
}

