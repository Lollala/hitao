package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.TransportExtend;
import com.hzitxx.hitao.mapper.TransportExtendMapper;
import com.hzitxx.hitao.service.ITransportExtendService;
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
 * 运费模板扩展表 服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class TransportExtendServiceImpl implements ITransportExtendService {

    @Autowired
    private TransportExtendMapper mapper;

    @Override
    public ServerResponse addTransportExtend(TransportExtend transportExtend){
        int result =  this.mapper.addTransportExtend(transportExtend);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addTransportExtendSelective(TransportExtend transportExtend){
        int result =  this.mapper.addTransportExtendSelective(transportExtend);
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
    public  ServerResponse updateById(TransportExtend transportExtend){
        int result = this.mapper.updateById(transportExtend);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(TransportExtend transportExtend){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(transportExtend));
    }

    @Override
    public  ServerResponse<List<TransportExtend>> searchTransportExtend(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchTransportExtend(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<TransportExtend>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<TransportExtend>  obj=mapper.searchTransportExtend(map);
        PageInfo<TransportExtend> pageInfo=new PageInfo<>(obj);
        LayuiEntity<TransportExtend> layuiEntity=new LayuiEntity<>();
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
    public ServerResponse<TransportExtend> findOne(Integer id){
        TransportExtend transportExtend = this.mapper.findOne(id);
        if(transportExtend == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(transportExtend);
     }
}

