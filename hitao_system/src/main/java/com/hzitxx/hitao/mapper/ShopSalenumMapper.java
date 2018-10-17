package com.hzitxx.hitao.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopSalenum;

public interface ShopSalenumMapper {
	/**
	 * 查询销售统计信息
	 * @param map
	 * @return
	 */
	public List<ShopSalenum> findAll(Map<String,Object> map);
		
	/**
	 * 编辑商品销售统计信息
	 * @param shopSalenum
	 * @return
	 */
	public int updateShopSalenum(ShopSalenum shopSalenum);
	
	/**
	 * 添加商品销售统计信息
	 * @param shopSalenum
	 * @return
	 */
	public int addShopSalenum(ShopSalenum shopSalenum);
	
	/**
	 * 删除商品销售统计信息
	 * @param shopSalenum
	 * @return
	 */
	public int delectShopSalenum(Integer Id);
	
	
	
}
