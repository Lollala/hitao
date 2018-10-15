package com.hzitxx.hitao.mapper.text;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopRole;
import com.hzitxx.hitao.mapper.ShopRoleMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=System8082.class)
public class ShopRoleTest {
	@Autowired
	private ShopRoleMapper srm;
	private ShopRole shopRole=new ShopRole();
	private Map<String,Object> map=new HashMap<>();
	/**
	 * 查询测试
	 */
	@Test
	public void findTest() {
		map.put("roleName", "管理");
		System.out.println(srm.findShopRole(map));
	}
	/**
	 * 添加测试
	 */
	@Test
	public void addTest() {
		shopRole.setRoleName("ow");
		shopRole.setRoleDescription("系统拥有者");
		shopRole.setCreatedTime(new Date());
		shopRole.setCreatedBy(1);
		shopRole.setIsDel(0);
		System.out.println(srm.addShopRole(shopRole));
	}
	
	/**
	 * 修改测试
	 */
	@Test
	public void updateTest() {
		shopRole.setRoleId(46);
		shopRole.setRoleName("ow");
		shopRole.setRoleDescription("系统拥有者");
		shopRole.setUpdatedTime(new Date());
		shopRole.setUpdatedBy(1);
		shopRole.setIsDel(1);
		System.out.println(srm.updateShopRole(shopRole));
	}
	/**
	 * 删除测试
	 */
	@Test
	public void deleteTest() {
		System.out.println(srm.deleteShopRole(35));
		
	}
}
