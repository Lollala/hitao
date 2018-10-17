package com.hzitxx.hitao.service;

import java.util.Map;

import com.hzitxx.hitao.entity.ShopMessage;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

public interface ShopMessageService {
	/**
	 * 消息分页
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	public ServerResponse<LayuiEntity<ShopMessage>> findShopMessage(Integer page,Integer limit,Map<String,Object> map);
	/**
	 * 添加消息
	 * @param shopAddress
	 * @return
	 */
	public ServerResponse<?> addShopMessage(ShopMessage shopMessage);
	/**
	 * 修改消息
	 * @param shopAddress
	 * @return
	 */
	public ServerResponse<?> updateShopMessage(ShopMessage shopMessage);
	/**
	 * 删除消息
	 * @param id
	 * @return
	 */
	public ServerResponse<?> deleteShopMessage(Integer messageId);
	
}
