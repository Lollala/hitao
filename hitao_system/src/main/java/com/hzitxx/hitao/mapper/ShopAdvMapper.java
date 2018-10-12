package com.hzitxx.hitao.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopAdv;
/**
 * 广告表
 * @author WE1
 *
 */
public interface ShopAdvMapper {
	/**
	 * 查询广告
	 * @return
	 */
	public List<ShopAdv> findAllShopAdv(Map<String,Object> map);
	/**
	 * 添加一条广告
	 * @param shopAdv
	 * @return
	 */
	public int addShopAdv(ShopAdv shopAdv);
	/**
	 * 修改广告数据，包括修改内容和启用和禁用
	 * @param shopAdv
	 * @return
	 */
	public int updateShopAdv(ShopAdv shopAdv);
	/**
	 * 物理删除广告信息
	 * @param advId
	 * @return
	 */
	public int deleteShopAdv(Integer advId);
}
