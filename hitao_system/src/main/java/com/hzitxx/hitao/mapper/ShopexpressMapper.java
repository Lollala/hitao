package com.hzitxx.hitao.mapper;

import java.util.List;

import com.hzitxx.hitao.entity.ShopExpress;

/**
 * 快递公司shopexpress
 * @author Lenovo
 *
 */
public interface ShopexpressMapper {
	/**
	 * 查询所有快递公司信息
	 * @return
	 */
	List<ShopExpress> selectShopexpress();
	
	/**
	 * 增加快递公司
	 * @param shopExpress
	 * @return
	 */
	int addShopexpress(ShopExpress shopExpress);
	/**
	 * 修改快递公司信息
	 * @param shopExpress
	 * @return
	 */
	int updateShopExpress(ShopExpress shopExpress);
	/**
	 * 真的删除
	 * @param id
	 * @return
	 */
	int deleteShopExpress(Integer id);
	/**
	 * 查询一条
	 * @param id
	 * @return
	 */
	ShopExpress findone(Integer id);

}
