package com.hzitxx.hitao.mapper.text;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopMessage;
import com.hzitxx.hitao.mapper.ShopMessageMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=System8082.class)
public class ShopMessageMapperTest {
	@Autowired 
	private  ShopMessageMapper smm;
	ShopMessage sm=new ShopMessage();
	
	@Test
	public void addTest(){
		sm.setMessageParentId(3);
		sm.setFromMemberId(173294);
		sm.setFromMemberName("李白");
		sm.setToMemberId("71231429");
		sm.setToMemberName("江大白");
		sm.setMessageTitle("singledog");
		sm.setMessageBody("你好吗？");
		sm.setMessageTime("3245");
		sm.setMessageUpdateTime("3245");
		sm.setMessageOpen(0);
		sm.setMessageState(0);
		sm.setMessageType(1);
		sm.setReadMemberId("1");
		sm.setDelMemberId("0");
		sm.setMessageIsmore(1);
		System.out.println(smm.addShopMessage(sm));	
	}
	
	@Test
	public void updateTest(){
		sm.setMessageId(4);
		sm.setMessageParentId(5);
		sm.setFromMemberId(173294);
		sm.setFromMemberName("李白");
		sm.setToMemberId("71231429");
		sm.setToMemberName("江大白");
		sm.setMessageTitle("singledog");
		sm.setMessageBody("你好吗？");
		sm.setMessageTime("12345");
		sm.setMessageUpdateTime("12423");
		sm.setMessageOpen(0);
		sm.setMessageState(0);
		sm.setMessageType(1);
		sm.setReadMemberId("1");
		sm.setDelMemberId("0");
		sm.setMessageIsmore(1);
		System.out.println(smm.updateShopMessage(sm));	
	}
	
	/**
	 * 删除消息
	 */
	@Test
	public void deleteTest(){
		smm.deleteShopMessage(1);
	}
	
	/**
	 * 根据Id查找一条消息
	 */
	@Test
	public void findoneTest(){
		System.out.println(smm.findone(4));
	}
	
	/**
	 * 查询所有消息
	 */
	@Test
	public void selectshopMessage(){
		List<ShopMessage> list = smm.selectShopMessage(null);
		System.out.println(list);
	}
}
