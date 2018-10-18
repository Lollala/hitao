package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.GoodsImages;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品图片 Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface GoodsImagesMapper{

    int addGoodsImages(GoodsImages obj);

    int addGoodsImagesSelective(GoodsImages obj);

    int deleteById(int goodsImageId);
                        
    int deleteByIds(String[] ids);

    int updateById(GoodsImages goodsImages);

    int updateSelectiveById(GoodsImages goodsImages);

    GoodsImages findOne(Integer goodsImageId);
                        
    List<GoodsImages> searchGoodsImages(Map<String,Object> map);
}