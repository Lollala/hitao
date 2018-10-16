package com.hzitxx.hitao.Test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopTransport;
import com.hzitxx.hitao.mapper.ShopTransportMapper;

@RunWith(SpringJUnit4ClassRunner.class) // 指定junit类,让其创建ioc容器
@SpringBootTest(classes = System8082.class)
public class TestShopTransportMapper {
	@Autowired
	private ShopTransportMapper mapper;
	/**
	 * 测试查询所有
	 */
	@Test
	public void sel(){
		List<ShopTransport> list = mapper.selectShopTransport(null);
		System.out.println(list);
	}
	/**
	 * 测试查询一条
	 */
	@Test
	public void findone(){
		ShopTransport shopTransport = mapper.findone(1);
		System.out.println(shopTransport);
	}
	/**
	 * 测试添加运费
	 */
	@Test
	public void add(){
		ShopTransport shopTransport = new ShopTransport();
		shopTransport.setTitle("测试一号");
		mapper.addShopTransport(shopTransport);
	}
	/**
	 * 测试删除
	 */
	@Test
	public void del(){
		mapper.deleteTransport(1);
	}
	/**
	 * 测试更新
	 */
	@Test
	public void update(){
		ShopTransport shopTransport = new ShopTransport();
		shopTransport.setTitle("测试一号999");
		shopTransport.setId(2);
		mapper.updateTransport(shopTransport);
	}
}

