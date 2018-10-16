package com.hzitxx.hitao.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.hitao.entity.ShopGoods;
import com.hzitxx.hitao.entity.ShopPayment;
import com.hzitxx.hitao.service.ShopPaymentService;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;

@RestController
@RequestMapping("/payment")
public class ShopPaymentController {
  @Autowired
  private ShopPaymentService service;
  /**
	 * 查询所有
	 * 
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	@GetMapping("/select")
	public ServerResponse<PageUtil<List<ShopPayment>>> sel(int page, int limit, Map<String, Object> map) {
		return service.selectShopPayment(page, limit, map);
	}

	/**
	 * 查询一条
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/findone")
	public ServerResponse<ShopPayment> findone(Integer paymentId) {
		return service.findoneShopPayment(paymentId);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/delete")
	public ServerResponse<String> del(Integer paymentId) {
		service.deleteShopPayment(paymentId);
		return ServerResponse.createBySuccessMessage("删除成功");
	}

	/**
	 * 添加
	 * 
	 * @param shopMenu
	 * @return
	 */
	@PostMapping("/add")
	public ServerResponse<String> add(ShopPayment shopPayment) {
		service.addShopPayment(shopPayment);
		return ServerResponse.createBySuccessMessage("添加成功");
	}

	/**
	 * 修改
	 * 
	 * @param shopMenu
	 * @return
	 */
	@PostMapping("/update")
	public ServerResponse<String> update(ShopPayment shopPayment) {
		service.updateShopPayment(shopPayment);
		return ServerResponse.createBySuccessMessage("更新成功");
	}
}
