package com.hzitxx.hitao.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.hitao.entity.ShopGoods;
import com.hzitxx.hitao.entity.ShopTransport;
import com.hzitxx.hitao.service.ShopTransportService;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;

@RestController
@RequestMapping("/transport")
public class ShopTransportController {
  @Autowired
  private ShopTransportService service;
  
  /**
	 * 查询所有
	 * 
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	@GetMapping("/select")
	public ServerResponse<PageUtil<List<ShopTransport>>> sel(int page, int limit, Map<String, Object> map) {
		return service.selectShopTransport(page, limit, map);
	}

	/**
	 * 查询一条
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/findone")
	public ServerResponse<ShopTransport> findone(Integer id) {
		return service.findone(id);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/delete")
	public ServerResponse<String> del(Integer id) {
		service.deleteShopTransport(id);
		return ServerResponse.createBySuccessMessage("删除成功");
	}

	/**
	 * 添加
	 * 
	 * @param shopMenu
	 * @return
	 */
	@PostMapping("/add")
	public ServerResponse<String> add(ShopTransport shopTransport) {
		service.addShopTransport(shopTransport);
		return ServerResponse.createBySuccessMessage("添加成功");
	}

	/**
	 * 修改
	 * 
	 * @param shopMenu
	 * @return
	 */
	@PostMapping("/update")
	public ServerResponse<String> update(ShopTransport shopTransport) {
		service.updateShopTransport(shopTransport);
		return ServerResponse.createBySuccessMessage("更新成功");
	}
}
