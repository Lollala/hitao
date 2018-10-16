package com.hzitxx.hitao.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopMenu;

/**
 * 后台菜单表
 * 
 * @author Lenovo
 *
 */
public interface ShopMenuMapper {
	/**
	 * 添加菜单
	 * 
	 * @param shopMenu
	 * @return
	 */
	int addShopMenu(ShopMenu shopMenu);

	/**
	 * 修改菜单
	 * 
	 * @param shopMenu
	 * @return
	 */
	int updateShopMenu(ShopMenu shopMenu);

	/**
	 * 查询所有菜单
	 * 
	 * @return
	 */
	List<ShopMenu> selectShopMenu(Map<String, Object> map);

	/**
	 * 查询一条菜单
	 * 
	 * @param id
	 * @return
	 */
	ShopMenu findone(Integer id);

	/**
	 * 删除菜单
	 * 
	 * @param id
	 * @return
	 */
	int deleteShopMenu(Integer id);
}
