package com.hzitxx.hitao.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopSetting;

public interface ShopSettingMapper {
	/**
	 * 查询
	 * @param map
	 * @return
	 */
	public List<ShopSetting> findShopSetting(Map<String,Object> map);
	
	/**
	 * 添加
	 * @param shopSetting
	 * @return
	 */
	public int addShopSetting(ShopSetting shopSetting);
	
	/**
	 * 更新
	 * @param shopSetting
	 * @return
	 */
	public int updateShopSetting(ShopSetting shopSetting);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int deleteShopSetting(Integer id);
}
