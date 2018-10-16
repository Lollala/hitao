package com.hzitxx.hitao.Test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopMember;
import com.hzitxx.hitao.mapper.ShopMemberMapper;

@RunWith(SpringJUnit4ClassRunner.class) // 指定junit类,让其创建ioc容器
@SpringBootTest(classes = System8082.class)
public class TestShopMemberMapper {
	@Autowired
	private ShopMemberMapper mapper;

	/**
	 * 测试查询所有会员信息
	 */
	@Test
	public void sel() {
		List<ShopMember> list = mapper.selectShopMember();
		for (ShopMember shopMember : list) {
			System.out.println(shopMember);
		}
	}

	/**
	 * 测试查询一条数据
	 */
	@Test
	public void findone() {
		ShopMember shopMember = mapper.findone(11);
		System.out.println(shopMember);
	}
	/**
	 * 测试更新
	 */
	@Test
	public void update(){
		ShopMember shopMember = new ShopMember();
		shopMember.setMemberId(29);
		//shopMember.setMemberName("皮皮");
		shopMember.setIsDel(1);
		mapper.updateShopMember(shopMember);
	}
	/**
	 * 测试添加会员
	 */
	@Test
	public void add(){
		ShopMember shopMember = new ShopMember();
		shopMember.setMemberName("高德微");
		mapper.addShopMember(shopMember);
	}
	/**
	 * 测试删除
	 */
    @Test
    public void del(){
    	mapper.deleteShopMember(34);
    }
}
