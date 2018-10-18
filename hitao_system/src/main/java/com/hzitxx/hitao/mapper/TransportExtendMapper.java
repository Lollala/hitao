package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.TransportExtend;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 运费模板扩展表 Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface TransportExtendMapper{

    int addTransportExtend(TransportExtend obj);

    int addTransportExtendSelective(TransportExtend obj);

    int deleteById(int id);
                                                        
    int deleteByIds(String[] ids);

    int updateById(TransportExtend transportExtend);

    int updateSelectiveById(TransportExtend transportExtend);

    TransportExtend findOne(Integer id);
                                                        
    List<TransportExtend> searchTransportExtend(Map<String,Object> map);
}