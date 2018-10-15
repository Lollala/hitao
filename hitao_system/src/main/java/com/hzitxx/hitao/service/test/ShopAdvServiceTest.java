package com.hzitxx.hitao.service.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopAdv;
import com.hzitxx.hitao.service.ShopAdvService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=System8082.class)
public class ShopAdvServiceTest {
	@Autowired
	private ShopAdvService sas;

	@Test
	public void findTest() {
		Map<String,Object> map=new HashMap<>();
		ServerResponse<LayuiEntity<ShopAdv>> a=sas.findAllShopAdv(1, 4, map);
		System.out.println(a.getData().getData());
	}
}
