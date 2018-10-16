package com.hzitxx.hitao.service;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopMenu;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;

public interface ShopMenuService {
	/**
	 * 添加菜单
	 * 
	 * @param shopMenu
	 * @return
	 */
	ServerResponse<Integer> addShopMenu(ShopMenu shopMenu);

	/**
	 * 删除菜单
	 * 
	 * @param id
	 * @return
	 */
	ServerResponse<Integer> deleteShopMenu(Integer id);

	/**
	 * 更新菜单
	 * 
	 * @param shopMenu
	 * @return
	 */
	ServerResponse<Integer> updateShopMenu(ShopMenu shopMenu);

	/**
	 * 分页查询所有数据
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	ServerResponse<PageUtil<List<ShopMenu>>> selectShopMenu(int page, int limit
			,Map<String, Object> map);

	/**
	 * 查询一条数据
	 * 
	 * @param id
	 * @return
	 */
	ServerResponse<ShopMenu> findone(Integer id);
}
