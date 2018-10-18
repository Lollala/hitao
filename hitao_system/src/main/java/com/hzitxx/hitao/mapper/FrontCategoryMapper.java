package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.FrontCategory;

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
public interface FrontCategoryMapper{

    int addFrontCategory(FrontCategory obj);

    int addFrontCategorySelective(FrontCategory obj);

    int deleteById(int frontCatId);
                                        
    int deleteByIds(String[] ids);

    int updateById(FrontCategory frontCategory);

    int updateSelectiveById(FrontCategory frontCategory);

    FrontCategory findOne(Integer frontCatId);
                                        
    List<FrontCategory> searchFrontCategory(Map<String,Object> map);
}