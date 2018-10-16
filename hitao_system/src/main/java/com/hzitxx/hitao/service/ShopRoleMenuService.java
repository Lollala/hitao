package com.hzitxx.hitao.service;
/**
 * 角色菜单表
 * @author WE1
 *
 */

import java.util.Map;

import com.hzitxx.hitao.entity.ShopRoleMenu;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

public interface ShopRoleMenuService {
	/**
	 * 分页查询数据
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	public ServerResponse<LayuiEntity<ShopRoleMenu>> findShopRoleMenu(Integer page,Integer limit,Map<String,Object> map);
	/**
	 * 添加角色菜单信息
	 * @param shopRoleMenu
	 * @return
	 */
	public ServerResponse<?> addShopRoleMenu(ShopRoleMenu shopRoleMenu);
	/**
	 * 根据id修改角色菜单信息
	 * @param shopRoleMenu
	 * @return
	 */
	public ServerResponse<?> updateShopRoleMenu(ShopRoleMenu shopRoleMenu);
	/**
	 * 根据id修改角色菜单信息
	 * @param id
	 * @return
	 */
	public ServerResponse<?> deleteShopRoleMenu(Integer id);
}
