package com.hzitxx.hitao.service;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopGoods;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;

/**
 * 商品表
 * 
 * @author Lenovo
 *
 */
public interface ShopGoodsServices {
	/**
	 * 添加
	 * 
	 * @param shopGoods
	 * @return
	 */
	ServerResponse<Integer> add(ShopGoods shopGoods);

	/**
	 * 删除
	 * 
	 * @param goodsId
	 * @return
	 */
	ServerResponse<Integer> delete(Integer goodsId);

	/**
	 * 修改
	 * 
	 * @param shopGoods
	 * @return
	 */
	ServerResponse<Integer> update(ShopGoods shopGoods);

	/**
	 * 查询所有数据
	 * 
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	ServerResponse<PageUtil<List<ShopGoods>>> select(int page, int limit, Map<String, Object> map);

	/**
	 * 查询一条数据
	 * 
	 * @param goodsId
	 * @return
	 */
	ServerResponse<ShopGoods> findone(Integer goodsId);
}
