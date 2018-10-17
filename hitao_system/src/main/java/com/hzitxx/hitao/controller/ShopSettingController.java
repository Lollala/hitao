package com.hzitxx.hitao.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzitxx.hitao.entity.ShopSetting;
import com.hzitxx.hitao.service.ShopSettingService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

@Controller
public class ShopSettingController {
	@Autowired
	private ShopSettingService shopSettingService;
	private Map<String, Object> map = new HashMap<>();
	
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @param name
	 * @return
	 */
	@GetMapping("/findShopSetting")
	@ResponseBody
	public ServerResponse<LayuiEntity<ShopSetting>> findShopSetting(@RequestParam("page") Integer page,
			@RequestParam("limit") Integer limit, String name) {
		map.put("name", name);
		return shopSettingService.findShopSetting(page, limit, map);
	}
	
	/**
	 * 添加
	 * @param shopSetting
	 * @return
	 */
	@GetMapping("/addShopSetting")
	@ResponseBody
	public ServerResponse<?> addShopSetting(@RequestBody ShopSetting shopSetting) {
		return shopSettingService.addShopSetting(shopSetting);
	}
	/**
	 * 
	 * @param shopSetting
	 * @return
	 */
	@GetMapping("/updateShopSetting")
	@ResponseBody
	public ServerResponse<?> updateShopSetting(@RequestBody ShopSetting shopSetting){
		return shopSettingService.updateShopSetting(shopSetting);
	}
	/**
	 * 删除
	 * @param shopSetting
	 * @return
	 */
	@GetMapping()
	@ResponseBody
	public ServerResponse<?> deleteShopSetting(@RequestBody Integer id){
		return shopSettingService.deleteShopSetting(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
