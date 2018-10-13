package com.hzitxx.hitao.mapper.text;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopAddress;
import com.hzitxx.hitao.mapper.ShopAddressMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=System8082.class)
public class ShopAddressMapperTest {
	@Autowired
	private ShopAddressMapper sam;
	Map<String,Object> map=new HashMap<>();
	private ShopAddress sa=new ShopAddress();
	/**
	 * 查询测试
	 */
	@Test
	public void findShopAddressTest() {
		map.put("memberName", '鸡');
		System.out.println(sam.findShopAddress(map));
	}
	/**
	 * 添加测试
	 */
	@Test
	public void addShopAddressTest() {
		sa.setMemberId(5);
		sa.setMemberName("GODV");
		sa.setProvinceId(0);
		sa.setCityId(0);
		sa.setDistrictId(0);
		sa.setFullRegion("中心");
		sa.setAddress("最中心");
		sa.setTelNumber("6516118");
		sa.setPostCode(191929);
		sa.setIsDefault(1);
		System.out.println(sam.addShopAddress(sa));
	}
	/**
	 * 修改测试
	 */
	@Test
	public void updateShopAddressTest() {
		sa.setId(18);
		sa.setMemberId(5);
		sa.setMemberName("GodV");
		sa.setProvinceId(1);
		sa.setCityId(1);
		sa.setDistrictId(1);
		sa.setFullRegion("中心");
		sa.setAddress("最中心");
		sa.setTelNumber("6516118");
		sa.setPostCode(191929);
		sa.setIsDefault(1);
		System.out.println(sam.updateShopAddress(sa));
	}
	/**
	 * 删除测试
	 */
	@Test
	public void deleteShopAddressTest() {
		System.out.println(sam.deleteShopAddress(16));
	}
}
