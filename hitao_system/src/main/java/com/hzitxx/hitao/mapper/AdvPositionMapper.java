package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.AdvPosition;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 广告位表 Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface AdvPositionMapper{

    int addAdvPosition(AdvPosition obj);

    int addAdvPositionSelective(AdvPosition obj);

    int deleteById(int apId);
                                                
    int deleteByIds(String[] ids);

    int updateById(AdvPosition advPosition);

    int updateSelectiveById(AdvPosition advPosition);

    AdvPosition findOne(Integer apId);
                                                
    List<AdvPosition> searchAdvPosition(Map<String,Object> map);
}