package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.Dic;
import com.hzitxx.hitao.mapper.DicMapper;
import com.hzitxx.hitao.service.IDicService;
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
public class DicServiceImpl implements IDicService {

    @Autowired
    private DicMapper mapper;

    @Override
    public ServerResponse addDic(Dic dic){
        int result =  this.mapper.addDic(dic);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addDicSelective(Dic dic){
        int result =  this.mapper.addDicSelective(dic);
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
    public  ServerResponse updateById(Dic dic){
        int result = this.mapper.updateById(dic);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(Dic dic){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(dic));
    }

    @Override
    public  ServerResponse<List<Dic>> searchDic(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchDic(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<Dic>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<Dic>  obj=mapper.searchDic(map);
        PageInfo<Dic> pageInfo=new PageInfo<>(obj);
        LayuiEntity<Dic> layuiEntity=new LayuiEntity<>();
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

