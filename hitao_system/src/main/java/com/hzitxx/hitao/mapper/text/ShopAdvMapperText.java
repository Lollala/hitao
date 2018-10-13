package com.hzitxx.hitao.mapper.text;

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
import com.hzitxx.hitao.entity.ShopAdv;
import com.hzitxx.hitao.mapper.ShopAdvMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=System8082.class)
public class ShopAdvMapperText {
	@Autowired
	private ShopAdvMapper sam;
	ShopAdv sa=new ShopAdv();
	/**
	 * 查找广告
	 */
	@Test
	public void findAllTest() {
		Map<String,Object> map=new HashMap<>();
		map.put("advTitle","Vivo");
		List<ShopAdv> list=sam.findAllShopAdv(map);
		System.out.println(list);
	}
	@Test
	public void addTest() {
		sa.setApId(2);
		sa.setAdvTitle("Vivo手机");
		sa.setAdvContent("VivoX300超大摄像头，照亮你的美");
		sa.setAdvStartDate(new Date());
		sa.setAdvEndDate(new Date());
		sa.setSlideSort(2);
		sa.setMemberId(1);
		sa.setMemberName("admin");
		sa.setClickNum(51515);
		sa.setIsAllow(1);
		sa.setBuyStyle("网上支付");
		sa.setGoldpay(153548);
		System.out.println(sam.addShopAdv(sa));
	}
	/**
	 * 修改测试
	 */
	@Test
	public void updateTest() {
		sa.setAdvId(2);
		sa.setApId(2);
		sa.setAdvTitle("Vivo手机");
		sa.setAdvContent("VivoZ3，首款千元屏幕指纹手机");
		System.out.println(sam.updateShopAdv(sa));
	}
	/**
	 * 物理删除测试
	 */
	@Test
	public void deleteTest() {
		System.out.println(sam.deleteShopAdv(4));
	}
}
