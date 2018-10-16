package com.hzitxx.hitao.service;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopPayment;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;

/**
 * 支付方式表
 * 
 * @author Lenovo
 *
 */
public interface ShopPaymentService {
	/**
	 * 添加
	 * 
	 * @param shopPayment
	 * @return
	 */
	ServerResponse<Integer> addShopPayment(ShopPayment shopPayment);

	/**
	 * 修改
	 * 
	 * @param shopPayment
	 * @return
	 */
	ServerResponse<Integer> updateShopPayment(ShopPayment shopPayment);

	/**
	 * 删除
	 * 
	 * @param paymentId
	 * @return
	 */
	ServerResponse<ShopPayment> deleteShopPayment(Integer paymentId);

	/**
	 * 查询一条数据
	 * 
	 * @param paymentId
	 * @return
	 */
	ServerResponse<ShopPayment> findoneShopPayment(Integer paymentId);

	/**
	 * 查询所有数据
	 * 
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	ServerResponse<PageUtil<List<ShopPayment>>> selectShopPayment(int page, int limit, Map<String, Object> map);
}
