package com.hzitxx.hitao.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopAdminRole;
/**
 * 管理员权限表
 * @author WE1
 *
 */
public interface ShopAdminRoleMapper {
	/**
	 * 查询管理员权限表数据
	 * @param map
	 * @return
	 */
	public List<ShopAdminRole> findShopAdminRole(Map<String,Object> map);
	/**
	 * 添加管理员权限
	 * @param shopAdminRole
	 * @return
	 */
	public Integer addShopAdminRole(ShopAdminRole shopAdminRole);
	/**
	 * 修改管理员权限
	 * @param shopAdminRole
	 * @return
	 */
	public Integer updateShopAdminRole(ShopAdminRole shopAdminRole);
	/**
	 * 物理删除管理员权限
	 * @param id
	 * @return
	 */
	public Integer deleteShopAdminRole(Integer id);
}
