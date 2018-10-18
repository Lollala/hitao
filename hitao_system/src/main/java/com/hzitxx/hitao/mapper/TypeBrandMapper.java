package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.TypeBrand;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品类型与品牌对应表 Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface TypeBrandMapper{

    int addTypeBrand(TypeBrand obj);

    int addTypeBrandSelective(TypeBrand obj);

                    
    int deleteByIds(String[] ids);

    int updateById(TypeBrand typeBrand);

    int updateSelectiveById(TypeBrand typeBrand);

                    
    List<TypeBrand> searchTypeBrand(Map<String,Object> map);
}