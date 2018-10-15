package com.hzitxx.hitao.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.hitao.entity.ShopAdminLog;
import com.hzitxx.hitao.service.ShopAdminLogService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

/**
 * 管理员操作日志
 * @author WE1
 *
 */
@RestController
public class ShopAdminLogController {
	@Autowired
	private ShopAdminLogService shopAdminLogService;
	
	private Map<String,Object> map=new HashMap<>();
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @param content
	 * @return
	 */
	@GetMapping("/findShopAdminLog")
	public ServerResponse<LayuiEntity<ShopAdminLog>> findShopAdminLog(@RequestParam("page")Integer page,
			@RequestParam("limit")Integer limit,String content){
		if(StringUtils.isEmpty(content)) {
			map.put("content", content);
		}
		return shopAdminLogService.findShopAdminLog(page, limit, map);
	}
	/**
	 * 添加日志
	 * @param shopAdminLog
	 * @return
	 */
	@PostMapping("/addShopAdminLog")
	public ServerResponse<?> addShopAdminLog(@RequestBody ShopAdminLog shopAdminLog){
		shopAdminLog.setCreatedTime(new Date());
		return shopAdminLogService.addShopAdminLog(shopAdminLog);
	}
	/**
	 * 修改日志
	 * @param shopAdminLog
	 * @return
	 */
	@PostMapping("/updateShopAdminLog")
	public ServerResponse<?> updateShopAdminLog(@RequestBody ShopAdminLog shopAdminLog){
		shopAdminLog.setUpdatedTime(new Date());
		return shopAdminLogService.updateShopAdminLog(shopAdminLog);
	}
	/**
	 * 物理删除日志
	 * @param logId
	 * @return
	 */
	@PostMapping("/deleteShopAdminLog")
	public ServerResponse<?> deleteShopAdminLog(@RequestParam("logId")Integer logId){
		
		return shopAdminLogService.deleteShopAdminLog(logId);
	}
}
