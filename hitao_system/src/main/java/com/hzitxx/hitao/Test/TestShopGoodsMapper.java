package com.hzitxx.hitao.Test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopGoods;
import com.hzitxx.hitao.mapper.ShopGoodsMapper;

@RunWith(SpringJUnit4ClassRunner.class) //指定junit类,让其创建ioc容器
@SpringBootTest(classes=System8082.class)
public class TestShopGoodsMapper {
	@Autowired
   private ShopGoodsMapper mapper;
	/**
	 * 测试查询所有商品信息
	 */
	@Test
	public void sel(){
		List<ShopGoods> list = mapper.selectShopGoods(null);
		System.out.println(list);
	}
	/**
	 * 测试查询一条商品记录
	 */
	@Test
	public void findone(){
		ShopGoods shopGoods = mapper.findone(14);
		System.out.println(shopGoods);
	}
	/**
	 * 测试删除商品
	 * 
	 */
	@Test
	public void del(){
		mapper.deleteShopGoods(20);
	}
	/**
	 * 测试添加商品
	 */
	@Test
	public void add(){
		ShopGoods shopGoods = new ShopGoods();
		shopGoods.setGoodsName("妈卖批");
		mapper.addShopGoods(shopGoods);
	}
	/**
	 * 测试修改商品信息
	 */
	@Test
	public void update(){
		ShopGoods shopGoods = new ShopGoods();
		shopGoods.setGoodsName("妈卖批2号");
		shopGoods.setGoodsId(26);
		mapper.updateShopGoods(shopGoods);
	}
}
