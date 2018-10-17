package com.hzitxx.hitao.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.interfaces.Claim;
import com.hzitxx.hitao.entity.ShopAdmin;
import com.hzitxx.hitao.service.ShopAdminService;
import com.hzitxx.hitao.utils.JwtTokenUtil;
import com.hzitxx.hitao.utils.ServerResponse;

@RestController
@RequestMapping("/shopAdmin")
public class LoginController {
	@Autowired
	private ShopAdminService shopAdminService;

	/**
	 * 登陆验证，在验证成功后生成token返回
	 * 
	 * @param adminName
	 * @param adminPassword
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@PostMapping("/login")
	public ServerResponse<?> login(@RequestBody ShopAdmin shopAdmin) throws UnsupportedEncodingException {
		List<ShopAdmin> shopAdminList = shopAdminService.findOneShopAdminByUAP(shopAdmin.getAdminName(),
				shopAdmin.getAdminPassword());
		if (shopAdminList.size() == 0) {
			return ServerResponse.createByErrorMessage("登陆失败！用户或密码错误！");
		} else {
			System.out.println(shopAdminList.get(0).getAdminId());
			String token = JwtTokenUtil.createToken(shopAdmin.getAdminName(), shopAdminList.get(0).getAdminId() + "");
			Map<String, String> tokenMap = new HashMap<>();
			tokenMap.put("token", token);
			return ServerResponse.createBySuccess("验证成功！返回token", JSON.toJSON(tokenMap));
		}
	}

	@GetMapping("/info")
	public ServerResponse<?> info(@RequestHeader("token") String token) {
		try {
			Map<String, Claim> tokenMap = JwtTokenUtil.parseToken(token);
			if (StringUtils.isEmpty(tokenMap)) {
				return ServerResponse.createByErrorMessage("用户信息获取失败！");
			} else {
				Map<String, Object> result = new HashMap<>();
				Integer adminId = Integer.parseInt(JwtTokenUtil.getUserId(token));
				result.put("shopAdmin", shopAdminService.findone(adminId));

				
				
				List<Object> permissions=new ArrayList<>();

				Map<String,Object> perMap=new HashMap<>();
				perMap.put("path", "/order");
				perMap.put("component", "order/order");
				perMap.put("name", "/order");
				{
					Map<String, Object> meta = new HashMap<>();
					meta.put("title", "order");
					meta.put("icon", "form");
					perMap.put("meta", meta);
				}
				List<Object> children=new ArrayList<>();
				
				Map<String,Object> chiMap=new HashMap<>();
				chiMap.put("path", "order");
				chiMap.put("component", "order/order");
				chiMap.put("name", "order");
				{
					Map<String, Object> meta = new HashMap<>();
					meta.put("title", "order");
					meta.put("noCache", "true");
					chiMap.put("meta", meta);
				}
				children.add(chiMap);
				perMap.put("children", children);
				permissions.add(perMap);

				result.put("permissions", permissions);

				List<String> roles=new ArrayList<>();
				roles.add("admin");
				result.put("roles", roles);

				result.put("avatar",
						"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=925993276,4023638545&fm=27&gp=0.jpg");
				return ServerResponse.createBySuccess("获取用户数据成功！", JSON.toJSON(result));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ServerResponse.createByErrorMessage("系统错误！");
	}
}
