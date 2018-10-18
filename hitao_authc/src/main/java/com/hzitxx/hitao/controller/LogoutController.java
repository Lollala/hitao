package com.hzitxx.hitao.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.hzitxx.hitao.utils.ServerResponse;
/**
 * 注销用户
 * @author WE1
 *
 */
@RequestMapping("/account")
@RestController
public class LogoutController {
	@GetMapping("/logout")
	public ServerResponse<?> logout(@RequestHeader("token")String token){
		Map<String,Object> tokenMap=new HashMap<>();
		tokenMap.put("token", "");
		return ServerResponse.createBySuccess("注销!",JSON.toJSONString(tokenMap));
	}
}
