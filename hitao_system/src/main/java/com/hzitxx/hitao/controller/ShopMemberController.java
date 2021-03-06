package com.hzitxx.hitao.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.hitao.entity.ShopMember;
import com.hzitxx.hitao.service.ShopMemberService;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;

@RestController
@RequestMapping("/member")
public class ShopMemberController {
	@Autowired
	private ShopMemberService service;

	/**
	 * 分页查询所有数据
	 * 
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	@GetMapping("/select")
	public ServerResponse<PageUtil<List<ShopMember>>> sel(Integer page, Integer limit, Map<String, Object> map) {
		return service.selectShopMember(page, limit, map);
	}

	/**
	 * 查询一条数据
	 * 
	 * @param memberId
	 * @return
	 */
	@GetMapping("/findone")
	public ServerResponse<ShopMember> findone(Integer memberId) {
		return service.findone(memberId);
	}

	/**
	 * 添加
	 * 
	 * @param shopMember
	 * @return
	 */
	@PostMapping("/add")
	public ServerResponse<String> add(ShopMember shopMember) {
		service.addShopMember(shopMember);
		return ServerResponse.createBySuccessMessage("添加成功");
	}

	/**
	 * 修改
	 * 
	 * @param shopMember
	 * @return
	 */
	@PostMapping("/update")
	public ServerResponse<String> update(ShopMember shopMember) {
		service.updateShopMember(shopMember);
		return ServerResponse.createBySuccessMessage("更新成功!");
	}

	/**
	 * 删除
	 * 
	 * @param memberId
	 * @return
	 */
	@PostMapping("/delete")
	public ServerResponse<String> del(Integer memberId) {
		service.deleteShopMember(memberId);
		return ServerResponse.createBySuccessMessage("删除成功!");
	}

}
