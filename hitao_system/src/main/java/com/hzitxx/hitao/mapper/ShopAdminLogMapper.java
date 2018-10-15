package com.hzitxx.hitao.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopAdminLog;

/**
 * 管理员操作日志
 * @author WE1
 *
 */
public interface ShopAdminLogMapper {
	/**
	 * 分页查找日志信息
	 */
	public List<ShopAdminLog> findShopAdminLog(Map<String,Object> map);
	/**
	 * 添加日志信息
	 */
	public Integer addShopAdminLog(ShopAdminLog shopAdminLog);
	/**
	 * 修改日志信息
	 * @param shopAdminLog
	 * @return
	 */
	public Integer updateShopAdminLog(ShopAdminLog shopAdminLog);
	/**
	 * 物理删除日志信息
	 * @param logId
	 * @return
	 */
	public Integer deleteShopAdminLog(Integer logId);
}
