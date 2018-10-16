package com.hzitxx.hitao.Test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopMenu;
import com.hzitxx.hitao.mapper.ShopMenuMapper;

@RunWith(SpringJUnit4ClassRunner.class) // 指定junit类,让其创建ioc容器
@SpringBootTest(classes = System8082.class)
public class TestShopMenuMapper {
	
	@Autowired
	private ShopMenuMapper mapper;
	/**
	 * 测试查询所有菜单
	 */
	@Test
	public void sel(){
		List<ShopMenu> list = mapper.selectShopMenu(null);
		System.out.println(list);
	}
	/**
	 * 查询一条信息
	 */
	@Test
	public void findone(){
		ShopMenu shopMenu = mapper.findone(3);
		System.out.println(shopMenu);
	}
	/**
	 * 测试添加菜单
	 * 
	 */
	@Test
	public void add(){
		ShopMenu shopMenu = new ShopMenu();
		shopMenu.setAlwaysShow(null);
		shopMenu.setComponent(null);
		shopMenu.setCreatedBy(null);
		shopMenu.setCreatedTime(new Date());
		shopMenu.setDescription(null);
		shopMenu.setLevel(null);
		shopMenu.setMeta(null);
		shopMenu.setName("lol");
		shopMenu.setParentId(1);
		shopMenu.setPath(null);
		shopMenu.setRedirect(null);
		shopMenu.setSort(null);
		shopMenu.setUrl(null);
	    mapper.addShopMenu(shopMenu);
	}
	/**
	 * 测试修改菜单
	 */
	@Test
	public void update(){
		ShopMenu shopMenu = new ShopMenu();
		shopMenu.setId(25);
		shopMenu.setName("高德威");
		shopMenu.setUpdatedTime(new Date());
		mapper.updateShopMenu(shopMenu);
	}
	/**
	 * 测试删除
	 */
	@Test
	public void del(){
		mapper.deleteShopMenu(25);
	}
}
