package com.hzitxx.hitao.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopTransport;

/**
 * 运费表
 * 
 * @author Lenovo
 *
 */
public interface ShopTransportMapper {
	/**
	 * 添加运费
	 * 
	 * @param shopTransport
	 * @return
	 */
	int addShopTransport(ShopTransport shopTransport);

	/**
	 * 修改运费
	 * 
	 * @param shopTransport
	 * @return
	 */
	int updateTransport(ShopTransport shopTransport);

	/**
	 * 删除运费
	 * 
	 * @param id
	 * @return
	 */
	int deleteTransport(Integer id);

	/**
	 * 查询一条结果
	 * 
	 * @param id
	 * @return
	 */
	ShopTransport findone(Integer id);

	/**
	 * 查询所有结果
	 * 
	 * @return
	 */
	List<ShopTransport> selectShopTransport(Map<String, Object> map);
}
