package com.hzitxx.hitao.service;
/**
 * 平台后台角色表
 * @author WE1
 *
 */

import java.util.Map;

import com.hzitxx.hitao.entity.ShopRole;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

public interface ShopRoleService {
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	public ServerResponse<LayuiEntity<ShopRole>> findShopRole(Integer page,Integer limit,Map<String,Object> map);
	/**
	 * 添加角色
	 * @param shopRole
	 * @return
	 */
	public ServerResponse<?> addShopRole(ShopRole shopRole);
	/**
	 * 修改角色信息
	 * @param shopRole
	 * @return
	 */
	public ServerResponse<?> updateShopRole(ShopRole shopRole);
	/**
	 * 物理删除角色信息（根据Id）
	 * @param roleId
	 * @return
	 */
	public ServerResponse<?> deleteShopRole(Integer roleId);
}
