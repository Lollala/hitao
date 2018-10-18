package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.OffpayArea;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 货到付款支持地区表 Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface OffpayAreaMapper{

    int addOffpayArea(OffpayArea obj);

    int addOffpayAreaSelective(OffpayArea obj);

                
    int deleteByIds(String[] ids);

    int updateById(OffpayArea offpayArea);

    int updateSelectiveById(OffpayArea offpayArea);

                
    List<OffpayArea> searchOffpayArea(Map<String,Object> map);
}