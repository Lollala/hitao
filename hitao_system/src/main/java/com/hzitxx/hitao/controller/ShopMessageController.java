package com.hzitxx.hitao.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hzitxx.hitao.entity.ShopAdminLog;
import com.hzitxx.hitao.entity.ShopMessage;
import com.hzitxx.hitao.entity.ShopRoleMenu;
import com.hzitxx.hitao.service.ShopMessageService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;


@Controller
public class ShopMessageController {
	@Autowired
	private ShopMessageService shopMessageService;
	
	private Map<String, Object> map = new HashMap<>();
	/**
	 * 消息分页
	 * @param page
	 * @param limit
	 * @param messageId
	 * @return
	 */
	@GetMapping("/findShopMessage")
	public ServerResponse<LayuiEntity<ShopMessage>> findShopMessage(@RequestParam("page") Integer page,
			@RequestParam("limit") Integer limit, Integer messageId) {
		map.put("messageId", messageId);
		return shopMessageService.findShopMessage(page, limit, map);
	}
	
	/**
	 * 添加消息
	 * @param shopMessage
	 * @return
	 */
	@PostMapping("/addShopMessage")
	public ServerResponse<?> addShopMessage(@RequestBody ShopMessage shopMessage) {
		return shopMessageService.addShopMessage(shopMessage);
	}
	/**
	 * 编辑消息
	 * @param shopMessage
	 * @return
	 */
	@PostMapping("/updateShopMessage")
	public ServerResponse<?> updateShopMessage(@RequestBody ShopMessage shopMessage) {
		return shopMessageService.updateShopMessage(shopMessage);
	}
	
	/**
	 * 删除消息
	 * @param messageId
	 * @return
	 */
	@PostMapping("/deleteShopMessage")
	public ServerResponse<?> deleteShopMessage(@RequestBody Integer messageId) {
		return shopMessageService.deleteShopMessage(messageId);
	}

}
