package com.hzitxx.hitao.mapper.text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopSalenum;
import com.hzitxx.hitao.mapper.ShopSalenumMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=System8082.class)
public class ShopSalenumMapperTest {
	@Autowired
	private ShopSalenumMapper ssm;
	ShopSalenum sm=new ShopSalenum();
	
	@Test
	public void findAllTest(){
		Map<String,Object> map=new HashMap<>();
		map.put("areaId","100000");
		List<ShopSalenum> list=ssm.findAll(map);
		System.out.println(list);
	}
	
	@Test
	public void addTest(){
		sm.setId(1006);
		sm.setDate(20181012);
		sm.setSalenum(200);
		sm.setGoodsId(18);
		System.out.println(ssm.addShopSalenum(sm));
	}
	
	@Test
	public void UpdateTest(){
		sm.setId(1001);
		sm.setDate(20181012);
		sm.setSalenum(156);
		sm.setGoodsId(20);
		System.out.println(ssm.updateShopSalenum(sm));
	}
	
	@Test
	public void DelectTest(){
		System.out.println(ssm.delectShopSalenum(1002));
	}
	
}
