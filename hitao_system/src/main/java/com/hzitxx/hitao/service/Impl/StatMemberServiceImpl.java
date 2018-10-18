package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.StatMember;
import com.hzitxx.hitao.mapper.StatMemberMapper;
import com.hzitxx.hitao.service.IStatMemberService;
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
 * 会员相关数据统计 服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class StatMemberServiceImpl implements IStatMemberService {

    @Autowired
    private StatMemberMapper mapper;

    @Override
    public ServerResponse addStatMember(StatMember statMember){
        int result =  this.mapper.addStatMember(statMember);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addStatMemberSelective(StatMember statMember){
        int result =  this.mapper.addStatMemberSelective(statMember);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse deleteById(int statmId){
        int result = this.mapper.deleteById(statmId);
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
    public  ServerResponse updateById(StatMember statMember){
        int result = this.mapper.updateById(statMember);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(StatMember statMember){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(statMember));
    }

    @Override
    public  ServerResponse<List<StatMember>> searchStatMember(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchStatMember(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<StatMember>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<StatMember>  obj=mapper.searchStatMember(map);
        PageInfo<StatMember> pageInfo=new PageInfo<>(obj);
        LayuiEntity<StatMember> layuiEntity=new LayuiEntity<>();
        layuiEntity.setCode(0);
        layuiEntity.setMsg("数据");
        layuiEntity.setCount(pageInfo.getTotal());
        layuiEntity.setData(pageInfo.getList());
        return ServerResponse.createBySuccess(layuiEntity);
    }

    /**
     * 根据id查询数据
     * @param statmId
     * @return
     */
    @Override
    public ServerResponse<StatMember> findOne(Integer statmId){
        StatMember statMember = this.mapper.findOne(statmId);
        if(statMember == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(statMember);
     }
}

