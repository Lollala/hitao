package com.hzitxx.hitao.service;

import java.util.Map;

import com.hzitxx.hitao.entity.ShopAdminLog;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

/**
 * 管理员操作日志
 * @author WE1
 *
 */
public interface ShopAdminLogService {
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	public ServerResponse<LayuiEntity<ShopAdminLog>> findShopAdminLog(Integer page,Integer limit,Map<String,Object> map);
	/**
	 * 添加日志
	 * @param shopAdminLog
	 * @return
	 */
	public ServerResponse<?> addShopAdminLog(ShopAdminLog shopAdminLog);
	/**
	 * 修改日志
	 * @param shopAdminLog
	 * @return
	 */
	public ServerResponse<?> updateShopAdminLog(ShopAdminLog shopAdminLog);
	/**
	 * 物理删除日志
	 * @param logId
	 * @return
	 */
	public ServerResponse<?> deleteShopAdminLog(Integer logId);
}
