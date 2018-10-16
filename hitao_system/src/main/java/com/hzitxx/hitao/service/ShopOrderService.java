package com.hzitxx.hitao.service;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopOrder;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;

/**
 * 订单表
 * 
 * @author Lenovo
 *
 */
public interface ShopOrderService {
	/**
	 * 添加
	 * 
	 * @param shopOrder
	 * @return
	 */
	ServerResponse<Integer> addShopOrder(ShopOrder shopOrder);

	/**
	 * 修改
	 * 
	 * @param shopOrder
	 * @return
	 */
	ServerResponse<Integer> updateShopOrder(ShopOrder shopOrder);

	/**
	 * 删除
	 * 
	 * @param orderId
	 * @return
	 */
	ServerResponse<Integer> deleteShopOrder(Integer orderId);

	/**
	 * 查询一条数据
	 * 
	 * @param orderId
	 * @return
	 */
	ServerResponse<ShopOrder> findone(Integer orderId);

	/**
	 * 查询所有数据
	 * 
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	ServerResponse<PageUtil<List<ShopOrder>>> selectShopOrder(int page, int limit, Map<String, Object> map);
}
