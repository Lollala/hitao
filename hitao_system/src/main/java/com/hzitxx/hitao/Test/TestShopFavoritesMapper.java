package com.hzitxx.hitao.Test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopFavorites;
import com.hzitxx.hitao.mapper.ShopFavoritesMapper;

@RunWith(SpringJUnit4ClassRunner.class) // 指定junit类,让其创建ioc容器
@SpringBootTest(classes = System8082.class)
public class TestShopFavoritesMapper {
	@Autowired
	private ShopFavoritesMapper mapper;

	/**
	 * 测试添加收藏
	 */
	@Test
	public void testAdd() {
		ShopFavorites shopFavorites = new ShopFavorites();
		shopFavorites.setFavTime(new Date());
		shopFavorites.setFavType("1");
		shopFavorites.setGoodsId(1);
		shopFavorites.setGoodsJingle("很烦");
		shopFavorites.setGoodsName("高德地图");
		shopFavorites.setMainImage("http:xxx.js");
		shopFavorites.setMemberId(20);
		mapper.addShopFavorites(shopFavorites);
	}

	/**
	 * 测试查询所有收藏
	 */
	@Test
	public void testSel() {
		List<ShopFavorites> list = mapper.selectShopFavorites();
		System.out.println(list);
	}

	/**
	 * 测试更新收藏信息
	 */
	@Test
	public void testUpdate() {
		ShopFavorites shopFavorites = new ShopFavorites();
		shopFavorites.setFavId(8);
		shopFavorites.setFavType("1");
		shopFavorites.setGoodsId(1);
		shopFavorites.setGoodsJingle("很烦啊");
		shopFavorites.setGoodsName("高德地图666");
		shopFavorites.setMainImage("http:xxx.js");
		shopFavorites.setMemberId(20);
		mapper.updateShopFavorites(shopFavorites);
	}
	/**
	 * 测试查询一条数据
	 */
	@Test
	public void testFindone(){
		ShopFavorites shopFavorites =mapper.findone(8);
		System.out.println(shopFavorites);
	}
	/**
	 * 测试物理删除收藏
	 */
	@Test
	public void testDelete(){
		mapper.deleteShopFavorites(8);
	}
}
