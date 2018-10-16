package com.hzitxx.hitao.Test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopInvoice;
import com.hzitxx.hitao.mapper.ShopInvoiceMapper;

@RunWith(SpringJUnit4ClassRunner.class) // 指定junit类,让其创建ioc容器
@SpringBootTest(classes = System8082.class)
public class TestShopInvoiceMapper {
	@Autowired
	private ShopInvoiceMapper mapper;

	/**
	 * 测试查询
	 */
	@Test
	public void sel() {
		List<ShopInvoice> list = mapper.selectShopInvoice();
		System.out.println(list);
	}
	/**
	 * 测试添加
	 */
	@Test
	public void add(){
		ShopInvoice shopInvoice = new ShopInvoice();
		shopInvoice.setInvCode(null);
		shopInvoice.setInvCompany(null);
		shopInvoice.setInvContent(null);
		shopInvoice.setInvGotoAddr(null);
		shopInvoice.setInvRecMobphone(null);
		shopInvoice.setInvRecName(null);
		shopInvoice.setInvRecProvince(null);
		shopInvoice.setInvRegAddr(null);
		shopInvoice.setInvRegBaccount(null);
		shopInvoice.setInvRegBname(null);
		shopInvoice.setInvRegPhone(null);
		shopInvoice.setInvState(null);
		shopInvoice.setInvTitle(null);
		shopInvoice.setMemberId(123);
		mapper.addShopInvoice(shopInvoice);
	}
	/**
	 * 测试更新
	 */
	@Test
	public void update(){
		ShopInvoice shopInvoice = new ShopInvoice();
		shopInvoice.setInvCode("纳税人识别号");
		shopInvoice.setInvId(2);
		mapper.updateShopInvoice(shopInvoice);
	}
	/**
	 * 测试删除
	 */
	@Test
	public void del(){
		mapper.deleteShopInvoice(2);
	}
	/**
	 * 测试查询一条
	 */
	@Test
	public void findone(){
		ShopInvoice shopInvoice =mapper.findone(1);
		System.out.println(shopInvoice);
	}
}
