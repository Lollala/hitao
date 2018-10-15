package com.hzitxx.hitao.service;

import java.util.Map;

import com.hzitxx.hitao.entity.ShopAdv;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

/**
 * 广告表
 * @author WE1
 *
 */
public interface ShopAdvService {
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	public ServerResponse<LayuiEntity<ShopAdv>> findAllShopAdv(Integer page,Integer limit,Map<String,Object> map);
	/**
	 * 增加广告
	 * @param shopAdv
	 * @return
	 */
	public ServerResponse<?> addShopAdv(ShopAdv shopAdv);
	/**
	 * 修改广告
	 * @param shopAdv
	 * @return
	 */
	public ServerResponse<?> updateShopAdv(ShopAdv shopAdv);
	/**
	 * 物理删除广告
	 * @param advId
	 * @return
	 */
	public ServerResponse<?> deleteShopAdv(Integer advId);
}
