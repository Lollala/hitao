package com.hzitxx.hitao.service;

import java.util.Map;

import com.hzitxx.hitao.entity.ShopSetting;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

public interface ShopSettingService {
	/**
	 * 分页
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	public ServerResponse<LayuiEntity<ShopSetting>> findShopSetting(Integer page,Integer limit,Map<String,Object> map);
	
	/**
	 * 添加
	 * @param shopSetting
	 * @return
	 */
	public ServerResponse<?> addShopSetting(ShopSetting shopSetting);
	
	/**
	 * 更新/编辑
	 * @param shopSetting
	 * @return
	 */
	public ServerResponse<?> updateShopSetting(ShopSetting shopSetting);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public ServerResponse<?> deleteShopSetting(Integer id);
}
