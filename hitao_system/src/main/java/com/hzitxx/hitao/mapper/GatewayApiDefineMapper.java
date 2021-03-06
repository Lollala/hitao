package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.GatewayApiDefine;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface GatewayApiDefineMapper{

    int addGatewayApiDefine(GatewayApiDefine obj);

    int addGatewayApiDefineSelective(GatewayApiDefine obj);

    int deleteById(int id);
                                
    int deleteByIds(String[] ids);

    int updateById(GatewayApiDefine gatewayApiDefine);

    int updateSelectiveById(GatewayApiDefine gatewayApiDefine);

    GatewayApiDefine findOne(Integer id);
                                
    List<GatewayApiDefine> searchGatewayApiDefine(Map<String,Object> map);
}