package com.hzitxx.hitao.filter;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.interfaces.Claim;
import com.hzitxx.hitao.utils.JwtTokenUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Configuration
public class LoginFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		RequestContext context=RequestContext.getCurrentContext();//获取当前请求对象的上下文对象
		HttpServletRequest req=context.getRequest();
		String uri=req.getRequestURI();//获取当前请求路径
		if(uri.contains("/login")) {
			return false;//放行登陆请求
		}
		return true;//拦截其他请求
	}

	@Override
	public Object run() {
		RequestContext context=RequestContext.getCurrentContext();//获取当前访问对象的上下文对象
		HttpServletRequest req=context.getRequest();
		String token=req.getParameter("token");
		context.getResponse().setContentType("application/json;charset=utf-8");//设置返回数据的格式
		if(StringUtils.isEmpty(token)) {
			context.setSendZuulResponse(false);//不进行路由
			Map<String,Object> map=new HashMap<>();
			map.put("code", 1);
			map.put("msg", "您未登陆或登陆失效！请先登陆！");
			map.put("success",false);
			map.put("data", null);
			context.setResponseBody(JSON.toJSONString(map));//设置被拦截后，返回的数据
		}
		try {
			Map<String,Claim> map=JwtTokenUtil.parseToken(token);
			if(StringUtils.isEmpty(map)) {
				context.setSendZuulResponse(false);
				Map<String,Object> map2=new HashMap<>();
				map2.put("code", 1);
				map2.put("msg", "登陆失效！请先登陆！");
				map2.put("success",false);
				map2.put("data", null);
				context.setResponseBody(JSON.toJSONString(map2));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String filterType() {
		return FilterType.PRE;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
