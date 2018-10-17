package com.hzitxx.hitao.service;

import java.util.Map;

import com.hzitxx.hitao.entity.ShopSalenum;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

public interface ShopSalenumService {
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	public ServerResponse<LayuiEntity<ShopSalenum>> findShopSalenum(Integer page,Integer limit,Map<String,Object> map);
	
	/**
	 * 
	 * @param shopSalenum
	 * @return
	 */
	public ServerResponse<?> addShopSalenum(ShopSalenum shopSalenum);
	
	/**
	 * 
	 * @param shopSalenum
	 * @return
	 */
	public ServerResponse<?> updateShopSalenum(ShopSalenum shopSalenum);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public ServerResponse<?> deleteShopSalenum(Integer id);

}
