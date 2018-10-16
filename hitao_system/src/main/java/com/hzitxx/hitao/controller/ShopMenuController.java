package com.hzitxx.hitao.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.hitao.entity.ShopMenu;
import com.hzitxx.hitao.service.ShopMenuService;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;

/**
 * 菜单表
 * 
 * @author Lenovo
 *
 */
@RestController // controller注解+respbody注解
@RequestMapping("/menu") // 请求父路径
public class ShopMenuController {
	@Autowired
	private ShopMenuService service;

	/**
	 * 查询所有
	 * 
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	@GetMapping("/select")
	public ServerResponse<PageUtil<List<ShopMenu>>> sel(int page, int limit, Map<String, Object> map) {
		return service.selectShopMenu(page, limit, map);
	}

	/**
	 * 查询一条
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/findone")
	public ServerResponse<ShopMenu> findone(Integer id) {
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
		service.deleteShopMenu(id);
		return ServerResponse.createBySuccessMessage("删除成功");
	}

	/**
	 * 添加
	 * 
	 * @param shopMenu
	 * @return
	 */
	@PostMapping("/add")
	public ServerResponse<String> add(ShopMenu shopMenu) {
		service.addShopMenu(shopMenu);
		return ServerResponse.createBySuccessMessage("添加成功");
	}

	/**
	 * 修改
	 * 
	 * @param shopMenu
	 * @return
	 */
	@PostMapping("/update")
	public ServerResponse<String> update(ShopMenu shopMenu) {
		service.updateShopMenu(shopMenu);
		return ServerResponse.createBySuccessMessage("更新成功");
	}
}
