package com.hzitxx.hitao.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzitxx.hitao.entity.ShopAdv;
import com.hzitxx.hitao.service.ShopAdvService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

/**
 * 广告表
 * 
 * @author WE1
 *
 */
@Controller
public class ShopAdvController {
	@Autowired
	private ShopAdvService shopAdvService;// 注入servcer层对象
	private Map<String, Object> map = new HashMap<>();

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping("/findShopAdv")
	@ResponseBody
	public ServerResponse<LayuiEntity<ShopAdv>> findShopAdv(@RequestParam("page") Integer page,
			@RequestParam("limit") Integer limit, String advTitle) {
		map.put("advTitle", advTitle);
		return shopAdvService.findAllShopAdv(page, limit, map);
	}

	/**
	 * 添加广告信息
	 * 
	 * @param shopAdv
	 * @return
	 */
	@PostMapping("/addShopAdv")
	@ResponseBody
	public ServerResponse<?> addShopAdv(@RequestBody ShopAdv shopAdv) {
		return shopAdvService.addShopAdv(shopAdv);
	}

	/**
	 * 修改广告信息
	 * 
	 * @param shopAdv
	 * @return
	 */
	@PostMapping("/updateShopAdv")
	@ResponseBody
	public ServerResponse<?> updateShopAdv(@RequestBody ShopAdv shopAdv) {
		return shopAdvService.updateShopAdv(shopAdv);
	}

	/**
	 * 物理删除广告信息
	 * 
	 * @param advId
	 * @return
	 */
	@PostMapping("/deleteShopAdv")
	@ResponseBody
	public ServerResponse<?> deleteShopAdv(Integer advId) {
		return shopAdvService.deleteShopAdv(advId);
	}
}
