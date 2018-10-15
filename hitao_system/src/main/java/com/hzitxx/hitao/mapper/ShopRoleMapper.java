package com.hzitxx.hitao.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopRole;

/**
 * 平台后台角色表
 * @author WE1
 *
 */
public interface ShopRoleMapper {
	/**
	 * 查询角色
	 * @param map
	 * @return
	 */
	public List<ShopRole> findShopRole(Map<String,Object> map);
	/**
	 * 添加角色
	 * @param shopRole
	 * @return
	 */
	public Integer addShopRole(ShopRole shopRole);
	/**
	 * 修改角色
	 * @param shopRole
	 * @return
	 */
	public Integer updateShopRole(ShopRole shopRole);
	/**
	 * 物理删除角色
	 * @param roleId
	 * @return
	 */
	public Integer deleteShopRole(Integer roleId);
}
