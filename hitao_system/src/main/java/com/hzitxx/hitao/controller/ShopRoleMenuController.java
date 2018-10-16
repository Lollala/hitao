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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.hitao.entity.ShopRole;
import com.hzitxx.hitao.entity.ShopRoleMenu;
import com.hzitxx.hitao.service.ShopRoleMenuService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

/**
 * 角色菜单表
 * @author WE1
 *
 */
@RestController
public class ShopRoleMenuController {
	@Autowired
	private ShopRoleMenuService shopRoleMenuService;
	
	private Map<String,Object> map=new HashMap<>();
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @param roleId
	 * @return
	 */
	@GetMapping("/findShopRoleMenu")
	public ServerResponse<LayuiEntity<ShopRoleMenu>> findShopRoleMenu(@RequestParam("page")Integer page,
			@RequestParam("limit")Integer limit,Integer roleId){
		if(StringUtils.isEmpty(roleId)) {
			map.put("roleName", roleId);
		}
		return shopRoleMenuService.findShopRoleMenu(page, limit, map);
	}
	/**
	 * 添加角色菜单信息
	 * @param shopRoleMenu
	 * @return
	 */
	@PostMapping("/addShopRoleMenu")
	public ServerResponse<?> addShopRoleMenu(@RequestBody ShopRoleMenu shopRoleMenu){
		return shopRoleMenuService.addShopRoleMenu(shopRoleMenu);
	}
	/**
	 * 根据id修改角色菜单信息写
	 * @param shopRoleMenu
	 * @return
	 */
	@PostMapping("/updateShopRoleMenu")
	public ServerResponse<?> updateShopRoleMenu(@RequestBody ShopRoleMenu shopRoleMenu){
		return shopRoleMenuService.updateShopRoleMenu(shopRoleMenu);
	}
	/**
	 * 根据id删除角色菜单信息写
	 * @param id
	 * @return
	 */
	@PostMapping("/deleteShopRoleMenu")
	public ServerResponse<?> deleteShopRoleMenu(@RequestParam("id")Integer id){
		return shopRoleMenuService.deleteShopRoleMenu(id);
	}
}
