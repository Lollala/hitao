package com.hzitxx.hitao.service.Impl;

import com.hzitxx.hitao.entity.MailMsgTemlates;
import com.hzitxx.hitao.mapper.MailMsgTemlatesMapper;
import com.hzitxx.hitao.service.IMailMsgTemlatesService;
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
 * 邮件模板表 服务实现类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@Service
public class MailMsgTemlatesServiceImpl implements IMailMsgTemlatesService {

    @Autowired
    private MailMsgTemlatesMapper mapper;

    @Override
    public ServerResponse addMailMsgTemlates(MailMsgTemlates mailMsgTemlates){
        int result =  this.mapper.addMailMsgTemlates(mailMsgTemlates);
        if(result != 1){
            return ServerResponse.createByErrorMessage("添加失败!");
        }
        return ServerResponse.createBySuccessMessage("添加成功!");
    }

    @Override
    public ServerResponse addMailMsgTemlatesSelective(MailMsgTemlates mailMsgTemlates){
        int result =  this.mapper.addMailMsgTemlatesSelective(mailMsgTemlates);
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
    public  ServerResponse updateById(MailMsgTemlates mailMsgTemlates){
        int result = this.mapper.updateById(mailMsgTemlates);
        if(result != 1){
            return ServerResponse.createByErrorMessage("编辑失败!");
        }
        return ServerResponse.createBySuccessMessage("编辑成功!");
    }

    @Override
    public  ServerResponse updateSelectiveById(MailMsgTemlates mailMsgTemlates){
        return ServerResponse.createBySuccess(mapper.updateSelectiveById(mailMsgTemlates));
    }

    @Override
    public  ServerResponse<List<MailMsgTemlates>> searchMailMsgTemlates(Map<String, Object> map){
        return ServerResponse.createBySuccess(this.mapper.searchMailMsgTemlates(map));
    }

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    @Override
    public ServerResponse<LayuiEntity<MailMsgTemlates>> page(int page,int limit,Map<String, Object> map){
        PageHelper.startPage(page,limit);
        List<MailMsgTemlates>  obj=mapper.searchMailMsgTemlates(map);
        PageInfo<MailMsgTemlates> pageInfo=new PageInfo<>(obj);
        LayuiEntity<MailMsgTemlates> layuiEntity=new LayuiEntity<>();
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
    public ServerResponse<MailMsgTemlates> findOne(Integer id){
        MailMsgTemlates mailMsgTemlates = this.mapper.findOne(id);
        if(mailMsgTemlates == null){
            return ServerResponse.createByErrorMessage("查询失败1!");
        }
        return ServerResponse.createBySuccess(mailMsgTemlates);
     }
}

