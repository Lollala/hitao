package com.hzitxx.hitao.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzitxx.hitao.entity.ShopSalenum;
import com.hzitxx.hitao.service.ShopSalenumService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

@Controller
public class ShopSalenumController{
	@Autowired
	private ShopSalenumService shopSalenumService;// 注入servcer层对象
	private Map<String, Object> map = new HashMap<>();

	/**
	 * 查询销售信息
	 * @param page
	 * @param limit
	 * @param id
	 * @return
	 */
	@GetMapping("/findShopSalenum")
	@ResponseBody
	public ServerResponse<LayuiEntity<ShopSalenum>> findShopSalenum(@RequestParam("page")Integer page, @RequestParam("limit")Integer limit,
	Integer id) {
		if (StringUtils.isEmpty(id)) {//判断筛选条件是否存在
			map.put("id", id);
		}
		return shopSalenumService.findShopSalenum(page, limit, map);
	}
	
	/**
	 * 添加销售统计
	 * @param shopSalenum
	 * @return
	 */
	@PostMapping("/addShopSalenum")
	@ResponseBody
	public ServerResponse<?> addShopSalenum(ShopSalenum shopSalenum) {
		return shopSalenumService.addShopSalenum(shopSalenum);
	}
	
	/**
	 * 更新销售统计
	 * @param shopSalenum
	 * @return
	 */
	@PostMapping("/updateShopSalenum")
	@ResponseBody
	public ServerResponse<?> updateShopSalenum(ShopSalenum shopSalenum) {
		return shopSalenumService.updateShopSalenum(shopSalenum);
	}
	
	/**
	 * 删除销售统计
	 * @param id
	 * @return
	 */
	@PostMapping("/deleteShopSalenum")
	@ResponseBody
	public ServerResponse<?> deleteShopSalenum(Integer id) {
		return shopSalenumService.deleteShopSalenum(id);
	}


}
