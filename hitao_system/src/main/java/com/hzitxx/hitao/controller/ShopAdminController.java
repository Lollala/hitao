package com.hzitxx.hitao.controller;

/**
 * 管理员表
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.hitao.entity.ShopAdmin;
import com.hzitxx.hitao.service.ShopAdminService;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;

@RestController // 代替@Controller和@ResponseBody
@RequestMapping("/admin") // 父路径
public class ShopAdminController {
	@Autowired
	private ShopAdminService service;

	/**
	 * 查询管理员表
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping("/select")
	public ServerResponse<PageUtil<List<ShopAdmin>>> sel(int page, int limit) {
		return service.selectShopAdmin(page, limit);
	}

	/**
	 * 添加管理员
	 * 
	 * @param shopAdmin
	 * @return
	 */
	@PostMapping("/add")
	public ServerResponse<String> add(ShopAdmin shopAdmin) {
		// 返回json格式要在请求参数前加上@requestBoby
		System.out.println(shopAdmin);
		service.addShopAdmin(shopAdmin);
		return ServerResponse.createBySuccessMessage("添加成功!");
	}

	/**
	 * 删除管理员
	 * 
	 * @param adminId
	 * @return
	 */
	@PostMapping("/delete")
	public ServerResponse<String> del(Integer adminId) {
		System.out.println(adminId);
		service.deleteShopAdmin(adminId);
		return ServerResponse.createBySuccessMessage("删除成功!");
	}

	/**
	 * 查询一条数据
	 */
	@PostMapping("/findone")
	public ServerResponse<ShopAdmin> findone(Integer adminId) {
		System.out.println(adminId);
		return service.findone(adminId);
	}

	/**
	 * 更新管理员
	 */
	@PostMapping("/update")
	public ServerResponse<String> del(ShopAdmin shopAdmin) {
		System.out.println(shopAdmin);
		service.updateShopAdmin(shopAdmin);
		return ServerResponse.createBySuccessMessage("更新成功!");
	}
}
