package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.GoodsCategory;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品分类表 Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface GoodsCategoryMapper{

    int addGoodsCategory(GoodsCategory obj);

    int addGoodsCategorySelective(GoodsCategory obj);

    int deleteById(int catId);
                                            
    int deleteByIds(String[] ids);

    int updateById(GoodsCategory goodsCategory);

    int updateSelectiveById(GoodsCategory goodsCategory);

    GoodsCategory findOne(Integer catId);
                                            
    List<GoodsCategory> searchGoodsCategory(Map<String,Object> map);
}