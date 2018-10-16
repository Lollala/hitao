package com.hzitxx.hitao.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopRoleMenu;
/**
 * 角色菜单表
 * @author WE1
 *
 */
public interface ShopRoleMenuMapper {
	/**
	 * 查询数据
	 * @param map
	 * @return
	 */
	public List<ShopRoleMenu> findShopRoleMenu(Map<String,Object> map);
	/**
	 * 添加角色菜单信息
	 * @param shopRoleMenu
	 * @return
	 */
	public Integer addShopRoleMenu(ShopRoleMenu shopRoleMenu);
	/**
	 * 根据id修改角色菜单信息
	 * @param shopRoleMenu
	 * @return
	 */
	public Integer updateShopRoleMenu(ShopRoleMenu shopRoleMenu);
	/**
	 * 根据id物理删除角色菜单信息
	 * @param id
	 * @return
	 */
	public Integer deleteShopRoleMenu(Integer id);
}
