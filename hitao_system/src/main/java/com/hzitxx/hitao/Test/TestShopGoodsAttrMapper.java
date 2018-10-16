package com.hzitxx.hitao.Test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopGoodsAttr;
import com.hzitxx.hitao.mapper.ShopGoodsAttrMapper;

import net.sf.jsqlparser.statement.update.Update;

@RunWith(SpringJUnit4ClassRunner.class) // 指定junit类,让其创建ioc容器
@SpringBootTest(classes = System8082.class)
public class TestShopGoodsAttrMapper {
	@Autowired
	private ShopGoodsAttrMapper mapper;
	/**
	 * 查询所有
	 */
	@Test
	public void sel(){
		List<ShopGoodsAttr> list = mapper.selectShopGoodsAttr();
		System.out.println(list);
	}
	/**
	 * 查询一条
	 */
	@Test
	public void findone(){
		ShopGoodsAttr shopGoodsAttr = mapper.findone(1);
		System.out.println(shopGoodsAttr);
	}
	/**
	 * 测试删除
	 */
	@Test
	public void del(){
		mapper.deleteShopGoodsAttr(5);
	}
	/**
	 * 测式更新
	 */
	@Test
	public void Update(){
		ShopGoodsAttr shopGoodsAttr = new ShopGoodsAttr();
		shopGoodsAttr.setUpdatedTiime(new Date());
		shopGoodsAttr.setGoodsId(5);
		mapper.updateShopGoodsAttr(shopGoodsAttr);
	}
	/**
	 * 测试添加
	 */
	@Test
	public void add(){
		ShopGoodsAttr shopGoodsAttr = new ShopGoodsAttr();
		shopGoodsAttr.setGoodsId(5);
		shopGoodsAttr.setAttrValue("aa");
		shopGoodsAttr.setIsDel(0);
		shopGoodsAttr.setCreatedTime(new Date());
		mapper.addShopGoodsAttr(shopGoodsAttr);
	}
}
