package com.hzitxx.hitao.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.hitao.entity.ShopAdmin;
import com.hzitxx.hitao.service.ShopAdminService;
import com.hzitxx.hitao.utils.JwtTokenUtil;
import com.hzitxx.hitao.utils.ServerResponse;

@RestController
@RequestMapping("/authc")
public class LoginController {
	@Autowired
	private ShopAdminService shopAdminService;

	@GetMapping("/login")
	public ServerResponse<?> login(@RequestParam("adminName") String adminName, @RequestParam("adminPassword") String adminPassword)
			throws UnsupportedEncodingException {
		List<ShopAdmin> shopAdminList = shopAdminService.findOneShopAdminByUAP(adminName, adminPassword);
		if (shopAdminList.size()==0) {
			return ServerResponse.createByErrorMessage("登陆失败！用户或密码错误！");
		} else {
			String token = JwtTokenUtil.createToken(adminName,shopAdminList.get(0).getAdminId());
			return ServerResponse.createBySuccess("验证成功！返回token", token);
		}
	}
}
