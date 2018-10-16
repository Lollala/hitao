package com.hzitxx.hitao.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopGoods;

/**
 * 商品表
 * @author Lenovo
 *
 */
public interface ShopGoodsMapper {
	/**
	 * 添加商品
	 * @param shopGoods
	 * @return
	 */
   int addShopGoods(ShopGoods shopGoods);
   /**
    * 修改商品
    * @param shopGoods
    * @return
    */
   int updateShopGoods(ShopGoods shopGoods);
   /**
    * 删除商品
    * @param goodsId
    * @return
    */
   int deleteShopGoods(Integer goodsId);
   /**
    * 查询一条商品数据
    * @param goodsId
    * @return
    */
   ShopGoods findone(Integer goodsId);
   /**
    * 查询所有商品记录
    * @return
    */
   List<ShopGoods> selectShopGoods(Map<String, Object> map);
}
