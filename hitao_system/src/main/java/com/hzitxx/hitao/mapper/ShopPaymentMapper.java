package com.hzitxx.hitao.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopPayment;

/**
 * 支付方式表
 * 
 * @author Lenovo
 *
 */
public interface ShopPaymentMapper {
	/**
	 * 添加支付方式
	 * 
	 * @param shopPayment
	 * @return
	 */
	int addShopPayment(ShopPayment shopPayment);

	/**
	 * 删除支付方式
	 * 
	 * @param paymentId
	 * @return
	 */
	int deleteShopPayment(Integer paymentId);

	/**
	 * 更新支付方式
	 * 
	 * @param shopPayment
	 * @return
	 */
	int updateShopPayment(ShopPayment shopPayment);

	/**
	 * 查询一条结果
	 * 
	 * @param paymentId
	 * @return
	 */
	ShopPayment findone(Integer paymentId);

	/**
	 * 查询所有结果
	 * 
	 * @return
	 */
	List<ShopPayment> selectShopPayment(Map<String, Object> map);
}
