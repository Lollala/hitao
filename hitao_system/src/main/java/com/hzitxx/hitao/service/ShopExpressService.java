package com.hzitxx.hitao.service;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopExpress;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;

/**
 * 快递公司表
 * 
 * @author Lenovo
 *
 */
public interface ShopExpressService {
	/**
	 * 添加
	 * 
	 * @param shopExpress
	 * @return
	 */
	ServerResponse<Integer> addShopExpress(ShopExpress shopExpress);

	/**
	 * 修改
	 * 
	 * @param shopExpress
	 * @return
	 */
	ServerResponse<Integer> updateShopExpress(ShopExpress shopExpress);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	ServerResponse<Integer> deleteShopExpress(Integer id);

	/**
	 * 查询一条
	 * 
	 * @param id
	 * @return
	 */
	ServerResponse<ShopExpress> findone(Integer id);

	/**
	 * 查询所有数据
	 * 
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	ServerResponse<PageUtil<List<ShopExpress>>> selectShopExpress(int page, int limit, Map<String, Object> map);
}
