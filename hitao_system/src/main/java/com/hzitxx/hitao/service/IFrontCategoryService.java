package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.FrontCategory;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface IFrontCategoryService  {
    ServerResponse addFrontCategory(FrontCategory frontCategory);

    ServerResponse addFrontCategorySelective(FrontCategory obj);

    ServerResponse deleteById(int frontCatId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(FrontCategory frontCategory);

    ServerResponse updateSelectiveById(FrontCategory frontCategory);

    ServerResponse<List<FrontCategory>> searchFrontCategory(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<FrontCategory>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<FrontCategory> findOne(Integer frontCatId);

}
