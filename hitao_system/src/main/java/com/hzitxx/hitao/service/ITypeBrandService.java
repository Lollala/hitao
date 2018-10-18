package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.TypeBrand;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品类型与品牌对应表 服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface ITypeBrandService  {
    ServerResponse addTypeBrand(TypeBrand typeBrand);

    ServerResponse addTypeBrandSelective(TypeBrand obj);


    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(TypeBrand typeBrand);

    ServerResponse updateSelectiveById(TypeBrand typeBrand);

    ServerResponse<List<TypeBrand>> searchTypeBrand(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<TypeBrand>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */

}
