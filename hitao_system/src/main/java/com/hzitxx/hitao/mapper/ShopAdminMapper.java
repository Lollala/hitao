package com.hzitxx.hitao.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopAdmin;
import com.hzitxx.hitao.utils.ServerResponse;

/**
 * 管理员表
 * 
 * @author Lenovo
 *
 */
public interface ShopAdminMapper {
	/**
	 * 增加一个管理员信息
	 * 
	 * @param shopAdmin
	 * @return
	 */
	int addShopAdmin(ShopAdmin shopAdmin);

	/**
	 * 删除某个管理员信息
	 * 
	 * @param adminId
	 * @return
	 */
	int deleteShopAdmin(Integer adminId);

	/**
	 * 更新管理员信息
	 * 
	 * @param shopAdmin
	 * @return
	 */
	int updateShopAdmin(ShopAdmin shopAdmin);

	/**
	 * 查询所有管理员信息
	 * 
	 * @return
	 */
	List<ShopAdmin> selectShopAdmin(Map<String, Object> map);
	/**
	 * 查询一条数据
	 * @param adminId
	 * @return
	 */
	ShopAdmin findone(Integer adminId);

}
