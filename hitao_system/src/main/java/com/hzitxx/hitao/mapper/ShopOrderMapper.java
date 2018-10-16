package com.hzitxx.hitao.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopOrder;

/**
 * 订单表
 * 
 * @author Lenovo
 *
 */
public interface ShopOrderMapper {
	/**
	 * 添加订单
	 * 
	 * @param shopOrder
	 * @return
	 */
	int addShopOrder(ShopOrder shopOrder);

	/**
	 * 更新订单
	 * 
	 * @param shopOrder
	 * @return
	 */
	int updateShopOrder(ShopOrder shopOrder);

	/**
	 * 删除订单
	 * 
	 * @param orderId
	 * @return
	 */
	int deleteShopOrder(Integer orderId);

	/**
	 * 查询一条订单
	 * 
	 * @param orderId
	 * @return
	 */
	ShopOrder findone(Integer orderId);

	/**
	 * 查询所有订单
	 * 
	 * @return
	 */
	List<ShopOrder> selectShopOrder(Map<String, Object> map);
}
