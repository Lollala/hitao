package com.hzitxx.hitao.mapper;


import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopMessage;
/**
 * 消息列表
 * @author THINK
 *
 */
public interface ShopMessageMapper {
	/**
	 * 新增消息
	 * @param shopMessage
	 * @return
	 */
	public	int addShopMessage(ShopMessage shopMessage);
	
	/**
	 * 删除消息
	 * @param messageId
	 * @return
	 */
	public int deleteShopMessage(Integer messageId);
	
	/**
	 * 编辑消息
	 * @param shopMessage
	 * @return
	 */
	public int updateShopMessage(ShopMessage shopMessage);
	
	/**
	 * 根据ID查找一条消息
	 * @param messgaeId
	 * @return
	 */
	public  ShopMessage findone(Integer messgaeId);
	
	/**
	 * 查询所有消息
	 * @param map 
	 * @return
	 */
	public List<ShopMessage> selectShopMessage(Map<String, Object> map);

}
