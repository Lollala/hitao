package com.hzitxx.hitao.service.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopSalenum;
import com.hzitxx.hitao.service.ShopSalenumService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=System8082.class)
public class ShopSaleunmSerivceText {
	@Autowired
	private ShopSalenumService ssm;
	
	@Test
	public void findTest(){
		Map<String,Object> map=new HashMap<>();
		ServerResponse<LayuiEntity<ShopSalenum>> ss=ssm.findShopSalenum(1, 2, map);
		System.out.println(ss.getData().getData());
	}
	
	@Test
	public void addTest(){
		
	}
	
	
}
