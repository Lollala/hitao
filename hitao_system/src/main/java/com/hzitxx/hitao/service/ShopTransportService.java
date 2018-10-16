package com.hzitxx.hitao.service;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopTransport;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;

/**
 * 运费表
 * 
 * @author Lenovo
 *
 */
public interface ShopTransportService {
	/**
	 * 添加
	 * 
	 * @param shopTransport
	 * @return
	 */
	ServerResponse<Integer> addShopTransport(ShopTransport shopTransport);

	/**
	 * 修改
	 * 
	 * @param shopTransport
	 * @return
	 */
	ServerResponse<Integer> updateShopTransport(ShopTransport shopTransport);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	ServerResponse<Integer> deleteShopTransport(Integer id);

	/**
	 * 查询一条
	 * 
	 * @param id
	 * @return
	 */
	ServerResponse<ShopTransport> findone(Integer id);

	/**
	 * 查询所有数据
	 * 
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	ServerResponse<PageUtil<List<ShopTransport>>> selectShopTransport(int page, int limit, Map<String, Object> map);
}
