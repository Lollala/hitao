package com.hzitxx.hitao.service;

import java.util.List;

import com.hzitxx.hitao.entity.ShopAdmin;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;

/**
 *  分页返回数据的格式
 * {
	"status": 0,
	"msg": null,
	"data": {
		"code": 0,
		"msg": "数据",
		"count": 12,
		"data": [{}]
		
	 }
	}
 * @author Lenovo
 *
 */
public interface ShopAdminService {
   /**
    * 添加管理员
    * @param shopAdmin
    * @return
    */
	public ServerResponse<Integer> addShopAdmin(ShopAdmin shopAdmin);
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @return
	 */
	public ServerResponse<PageUtil<List<ShopAdmin>>> selectShopAdmin
	(int page,int limit);
	/**
	 * 根据编号查询
	 */
	public ServerResponse<ShopAdmin> findone(Integer adminId);
	/**
	 * 更新
	 */
	public ServerResponse<Integer> updateShopAdmin(ShopAdmin shopAdmin);
	/**
	 * 物理删除
	 */
	public ServerResponse<Integer> deleteShopAdmin(Integer adminId);
}





