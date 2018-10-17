package com.hzitxx.hitao.service;

import java.util.Map;

import com.hzitxx.hitao.entity.ShopArea;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

public interface ShopAreaService {


	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	public ServerResponse<LayuiEntity<ShopArea>> findShopArea(Integer page,Integer limit,Map<String,Object> map);
	
	/**
	 * 
	 * @param shoparea
	 * @return
	 */
	public ServerResponse<?> addShopArea(ShopArea shoparea);
	
	/**
	 * 
	 * @param shoparea
	 * @return
	 */
	public ServerResponse<?> updateShopArea(ShopArea shoparea);
	
	/**
	 * 
	 * @param areaId
	 * @return
	 */
	public ServerResponse<?> deleteShopArea(Integer areaId);
	
	

	
}
