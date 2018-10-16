package com.hzitxx.hitao.Test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopPayment;
import com.hzitxx.hitao.mapper.ShopPaymentMapper;

@RunWith(SpringJUnit4ClassRunner.class) // 指定junit类,让其创建ioc容器
@SpringBootTest(classes = System8082.class)
public class TestShopPaymentMapper {
	@Autowired
	private ShopPaymentMapper mapper;
	
	/**
	 * 测试查询一条数据
	 */
	@Test
	public void findone(){
		ShopPayment shopPayment = mapper.findone(1);
		System.out.println(shopPayment);
	}
	/**
	 * 测试查询所有
	 */
	@Test
	public void sel(){
		List<ShopPayment> list = mapper.selectShopPayment();
		System.out.println(list);
	}
	/**
	 * 测试删除
	 */
	@Test
	public void del(){
		mapper.deleteShopPayment(2);
	}
	/**
	 * 测试添加
	 */
	@Test
	public void add(){
		ShopPayment shopPayment = new ShopPayment();
		shopPayment.setPaymentName("daidai");
		mapper.addShopPayment(shopPayment);
	}
	/**
	 * 测试更新
	 */
	@Test
	public void update(){
		ShopPayment shopPayment = new ShopPayment();
		shopPayment.setPaymentName("daidai");
		shopPayment.setPaymentId(1);
		mapper.updateShopPayment(shopPayment);
	}
}
