package com.hzitxx.hitao.service;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopBrand;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;

/**
 * 品牌表
 * 
 * @author Lenovo
 *
 */
public interface ShopBrandService {
	/**
	 * 添加
	 * 
	 * @param shopBrand
	 * @return
	 */
	ServerResponse<Integer> addShopBrand(ShopBrand shopBrand);

	/**
	 * 删除
	 * 
	 * @param brandId
	 * @return
	 */
	ServerResponse<Integer> deleteShopBrand(Integer brandId);

	/**
	 * 更新
	 * 
	 * @param shopBrand
	 * @return
	 */
	ServerResponse<Integer> updateShopBrand(ShopBrand shopBrand);

	/**
	 * 查询所有数据
	 * 
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	ServerResponse<PageUtil<List<ShopBrand>>> selectShopBrand(int page, int limit, Map<String, Object> map);

	/**
	 * 查询一条数据
	 * 
	 * @param brandId
	 * @return
	 */
	ServerResponse<ShopBrand> findone(Integer brandId);
}
