package com.hzitxx.hitao.controller;

import java.util.Date;
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

import com.hzitxx.hitao.entity.ShopRole;
import com.hzitxx.hitao.service.ShopRoleService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

/**
 * 平台后台角色表
 * @author WE1
 *
 */
@Controller
public class ShopRoleController {
	@Autowired
	private ShopRoleService shopRoleService;
	
	private Map<String,Object> map=new HashMap<>();
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @param roleName
	 * @return
	 */
	@GetMapping("/findShopRole")
	@ResponseBody
	public ServerResponse<LayuiEntity<ShopRole>> findShopRole(@RequestParam("page")Integer page,
			@RequestParam("limit")Integer limit,String roleName){
		if(StringUtils.isEmpty(roleName)) {
			map.put("roleName", roleName);
		}
		return shopRoleService.findShopRole(page, limit, map);
	}
	/**
	 * 添加角色
	 * @param shopRole
	 * @return
	 */
	@PostMapping("/addShopRole")
	@ResponseBody
	public ServerResponse<?> addShopRole(@RequestBody ShopRole shopRole){
		shopRole.setCreatedTime(new Date());
		return shopRoleService.addShopRole(shopRole);
	}
	/**
	 * 修改角色信息
	 * @param shopRole
	 * @return
	 */
	@PostMapping("/updaetShopRole")
	@ResponseBody
	public ServerResponse<?> updaetShopRole(@RequestBody ShopRole shopRole){
		shopRole.setUpdatedTime(new Date());
		return shopRoleService.updateShopRole(shopRole);
	}
	/**
	 * 删除角色信息
	 * @param roleId
	 * @return
	 */
	@PostMapping("/deleteShopRole")
	@ResponseBody
	public ServerResponse<?> deleteShopRole(@RequestParam("roleId")Integer roleId){
		return shopRoleService.deleteShopRole(roleId);
	}
}
