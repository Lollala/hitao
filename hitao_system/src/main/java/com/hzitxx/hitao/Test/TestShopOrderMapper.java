package com.hzitxx.hitao.Test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopOrder;
import com.hzitxx.hitao.mapper.ShopOrderMapper;

@RunWith(SpringJUnit4ClassRunner.class) // 指定junit类,让其创建ioc容器
@SpringBootTest(classes = System8082.class)
public class TestShopOrderMapper {
	@Autowired
	private ShopOrderMapper mapper;
	/**
	 * 测试查询一条数据
	 */
	@Test
	public void findone(){
		ShopOrder shopOrder = mapper.findone(1);
		System.out.println(shopOrder);
	}
	/**
	 * 测试查询所有数据
	 */
	@Test
	public void sel(){
		List<ShopOrder> list = mapper.selectShopOrder(null);
		System.out.println(list);
	}
	/**
	 * 测试删除
	 */
	@Test
	public void del(){
		mapper.deleteShopOrder(1);
	}
	/**
	 * 测试 添加订单
	 */
	@Test
	public void add(){
		ShopOrder shopOrder = new ShopOrder();
		shopOrder.setCreatedTime(new Date());
		shopOrder.setBuyerName("开心测试");
		mapper.addShopOrder(shopOrder);
	}
	/**
	 * 测试修改
	 */
	@Test
	public void update(){
		ShopOrder shopOrder = new ShopOrder();
		shopOrder.setOrderId(3);
		shopOrder.setBuyerName("jack");
		mapper.updateShopOrder(shopOrder);
	}
}
