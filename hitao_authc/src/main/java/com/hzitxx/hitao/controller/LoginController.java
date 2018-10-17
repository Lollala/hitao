package com.hzitxx.hitao.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzitxx.hitao.utils.JwtTokenUtil;

@RestController
public class LoginController {
	@Autowired
	private 
	
	@GetMapping("/login")
	public String login(@RequestParam("username")String username,
			@RequestParam("password")String password) throws UnsupportedEncodingException {
		
		if()
		
		String token=JwtTokenUtil.createToken(username, password);
		return token;
	}
}
