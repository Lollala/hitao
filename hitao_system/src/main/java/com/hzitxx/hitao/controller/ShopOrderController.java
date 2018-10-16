package com.hzitxx.hitao.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.hitao.entity.ShopOrder;
import com.hzitxx.hitao.service.ShopOrderService;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;

@RestController
@RequestMapping("/order")
public class ShopOrderController {
  @Autowired
  private ShopOrderService service;
  
  /**
	 * 查询所有
	 * 
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	@GetMapping("/select")
	public ServerResponse<PageUtil<List<ShopOrder>>> sel(int page, int limit, Map<String, Object> map) {
		return service.selectShopOrder(page, limit, map);
	}

	/**
	 * 查询一条
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/findone")
	public ServerResponse<ShopOrder> findone(Integer orderId) {
		return service.findone(orderId);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/delete")
	public ServerResponse<String> del(Integer orderId) {
		service.deleteShopOrder(orderId);
		return ServerResponse.createBySuccessMessage("删除成功");
	}

	/**
	 * 添加
	 * 
	 * @param shopMenu
	 * @return
	 */
	@PostMapping("/add")
	public ServerResponse<String> add(ShopOrder shopOrder) {
		service.addShopOrder(shopOrder);
		return ServerResponse.createBySuccessMessage("添加成功");
	}

	/**
	 * 修改
	 * 
	 * @param shopMenu
	 * @return
	 */
	@PostMapping("/update")
	public ServerResponse<String> update(ShopOrder shopOrder) {
		service.updateShopOrder(shopOrder);
		return ServerResponse.createBySuccessMessage("更新成功");
	}
}
