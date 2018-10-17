package com.hzitxx.hitao.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopAdmin;
import com.hzitxx.hitao.mapper.ShopAdminMapper;

@RunWith(SpringJUnit4ClassRunner.class) //指定junit类,让其创建ioc容器
@SpringBootTest(classes=System8082.class)
public class TestShopAdminMapper2 {
	@Autowired
	private ShopAdminMapper mapper;
	/**
	 * 更新管理员信息+isdel逻辑删除
	 */
	@Test
	public void testUpdate(){
		ShopAdmin shopAdmin = new ShopAdmin();
		shopAdmin.setAdminId(20);
		shopAdmin.setAdminName("jjjjj");
		/*shopAdmin.setActionList("a");
		shopAdmin.setAdminLoginNum(5);
		shopAdmin.setAdminName("cc高德伟5号");
		shopAdmin.setAdminPassword("995995");
		shopAdmin.setCreatedBy(1);
		shopAdmin.setCreatedTime(new Date());
		shopAdmin.setEmail("cc@163.com");
		shopAdmin.setLoginIp("152.168.1.9");
		shopAdmin.setLoginStatus(1);
		shopAdmin.setLoginTime(new Date());
		shopAdmin.setNavList("a");*/
		int a = mapper.updateShopAdmin(shopAdmin);
		System.out.println(a);
	}
	
	/**
	 * 测试删除管理员信息--真的
	 */
	@Test
	public void testDel(){
		mapper.deleteShopAdmin(18);
	}
	/**
	 * 测试查询所有管理员信息
	 */
	@Test
	public void testSel(){
		Map<String, Object> map = new HashMap<>();
		map.put("adminName", "jack");
		map.put("adminPassword", "123456");
		List<ShopAdmin> list = mapper.selectShopAdmin(map);
		System.out.println(list);
	}
	/**
	 * 测试添加管理员
	 */
	@Test
	public void testAdd(){
		ShopAdmin shopAdmin = new ShopAdmin();
		shopAdmin.setActionList("a");
		shopAdmin.setAdminLoginNum(5);
		shopAdmin.setAdminName("cc高德伟");
		shopAdmin.setAdminPassword("995995");
		shopAdmin.setCreatedBy(1);
		shopAdmin.setCreatedTime(new Date());
		shopAdmin.setEmail("cc@163.com");
		shopAdmin.setIsDel(0);
		shopAdmin.setLoginIp("152.168.1.9");
		shopAdmin.setLoginStatus(1);
		shopAdmin.setLoginTime(new Date());
		shopAdmin.setNavList("a");
		int a =mapper.addShopAdmin(shopAdmin);
		System.out.println(a);
	}
	/**
	 * 测试查询一条数据
	 */
	@Test
	public void testFindone(){
		ShopAdmin shopAdmin = mapper.findone(2);
		System.out.println(shopAdmin);
	}

}
