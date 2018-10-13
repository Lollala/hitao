package com.hzitxx.hitao.mapper;

import java.util.List;

import com.hzitxx.hitao.entity.ShopBrand;

/**
 * 品牌表
 * 
 * @author Lenovo
 *
 */
public interface ShopBrandMapper {
	/**
	 * 添加一个品牌
	 * 
	 * @param shopBrand
	 * @return
	 */
	int addShopBrand(ShopBrand shopBrand);

	/**
	 * 更新某个品牌
	 * 
	 * @param shopBrand
	 * @return
	 */
	int updateShopBrand(ShopBrand shopBrand);

	/**
	 * 删除某个品牌
	 * 
	 * @param brandId
	 * @return
	 */
	int deleteShopBrand(Integer brandId);

	/**
	 * 查询所有品牌
	 * 
	 * @return
	 */
	List<ShopBrand> selectShopBrand();
	/**
	 * 根据id查询这条数据信息
	 * @param brandId
	 * @return
	 */
	ShopBrand findone(Integer brandId);
}
