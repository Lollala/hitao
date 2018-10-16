package com.hzitxx.hitao.service.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopAdmin;
import com.hzitxx.hitao.service.ShopAdminService;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;

@RunWith(SpringJUnit4ClassRunner.class) // 指定junit类,让其创建ioc容器
@SpringBootTest(classes = System8082.class)
public class TestShopAdminService {
	@Autowired
	private ShopAdminService service;

	/**
	 * 测试添加管理员
	 */
	@Test
	public void add() {
		// System.out.println(service);
		ShopAdmin shopAdmin = new ShopAdmin();
		shopAdmin.setActionList("a");
		shopAdmin.setAdminLoginNum(5);
		shopAdmin.setAdminName("cjw高德伟");
		shopAdmin.setAdminPassword("995995");
		shopAdmin.setCreatedBy(1);
		shopAdmin.setCreatedTime(new Date());
		shopAdmin.setEmail("cc@163.com");
		shopAdmin.setIsDel(0);
		shopAdmin.setLoginIp("152.168.1.9");
		shopAdmin.setLoginStatus(1);
		shopAdmin.setLoginTime(new Date());
		shopAdmin.setNavList("a");
		ServerResponse<Integer> msg = service.addShopAdmin(shopAdmin);
		System.out.println(msg.getMsg());
	}

	/**
	 * 测试分页查询功能
	 */
	@Test
	public void testSel() {
		ServerResponse<PageUtil<List<ShopAdmin>>> response = service.selectShopAdmin(1, 5);
		System.out.println(response.getMsg() + response.getData().getData());
	}
	
	/**
	 * 测试查询一条数据
	 */
	@Test
	public void testFindone(){
		ServerResponse<ShopAdmin> shopAdmin = service.findone(8);
		System.out.println(shopAdmin.getData()+shopAdmin.getMsg());
	}
	/**
	 * 测试更新
	 */
	@Test
	public void testupdate(){
		ShopAdmin shopAdmin = new ShopAdmin();
		shopAdmin.setAdminId(8);
		shopAdmin.setAdminName("骚的亚匹");
		ServerResponse<Integer> response = service.updateShopAdmin(shopAdmin);
		System.out.println(response.getMsg());
	}
	/**
	 * 测试删除
	 */
	@Test
	public void testDel(){
		ServerResponse<Integer> response = service.deleteShopAdmin(19);
		System.out.println(response.getMsg());
	}
}
