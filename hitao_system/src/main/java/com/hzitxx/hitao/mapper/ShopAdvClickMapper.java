package com.hzitxx.hitao.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopAdvClick;

public interface ShopAdvClickMapper {
	/**
	 * 查询广告点击率
	 * @param map
	 * @return
	 */
	public List<ShopAdvClick> findShopAdvClick(Map<String,Object> map);	
	/**
	 * 添加广告点击率信息
	 * @param shopAdvClick
	 * @return
	 */
	public Integer addShopAdvClick(ShopAdvClick shopAdvClick);
	/**
	 * 根据id修改广告点击率信息
	 * @param shopAdvClick
	 * @return
	 */
	public Integer updateShopAdvClick(ShopAdvClick shopAdvClick);
	/**
	 * 根据id删除广告点击率信息
	 * @param advId
	 * @return
	 */
	public Integer deleteShopAdvClick(Integer advId);
}
