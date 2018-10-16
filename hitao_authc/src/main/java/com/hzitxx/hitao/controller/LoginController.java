package com.hzitxx.hitao.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.hitao.utils.JwtTokenUtil;

@RestController
public class LoginController {
	@GetMapping("/login")
	public String login(@RequestParam("username")String username,
			@RequestParam("password")String password) throws UnsupportedEncodingException {
		String token=JwtTokenUtil.createToken(username, password);
		return token;
	}
}
