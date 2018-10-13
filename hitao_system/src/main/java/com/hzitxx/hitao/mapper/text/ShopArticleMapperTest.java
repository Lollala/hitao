package com.hzitxx.hitao.mapper.text;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopArticle;
import com.hzitxx.hitao.mapper.ShopArticleMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=System8082.class)
public class ShopArticleMapperTest {
	@Autowired
	private ShopArticleMapper sam;
	private ShopArticle sa=new ShopArticle();
	private Map<String,Object> map=new HashMap<>();
	/**
	 * 查询测试
	 */
	@Test
	public void findShopArticleTest() {
		System.out.println(sam.findShopArticle(map));
	}
	/**
	 * 添加测试
	 */
	@Test
	public void addShopArticleTest() {
		sa.setArticleTitle("小米手机");
		sa.setArticleClassId(1);
		sa.setArticleOrigin("1");
		sa.setArticleOriginAddress("1");
		sa.setArticleAuthor("d");
		sa.setArticleAbstract("a");
		sa.setArticleContent("d");
		sa.setArticleImage("d");
		sa.setArticleKeyword("dd");
		sa.setArticleLink("d");
		sa.setArticleGoods("ff");
		sa.setArticleStartTime(32);
		sa.setArticleEndTime(2342);
		sa.setArticlePublishTime(2234);
		sa.setArticleClick(2342);
		sa.setArticleSort(234);
		sa.setArticleCommendFlag(234);
		sa.setArticleCommentFlag(24);
		sa.setArticleVerifyAdmin("123");
		sa.setArticleVerifyTime(123);
		sa.setArticleState(23);
		sa.setArticlePublisherName("sds");
		sa.setArticlePublisherId(123);
		sa.setArticleAttachmentPath("asfad");
		sa.setArticleImageAll("123123");
		sa.setArticleModifyTime(232);
		sa.setArticleTag("1123");
		sa.setArticleCommentCount(123123);
        sa.setArticleCommendImageFlag(131);
		sa.setArticleShareCount(32432);
		sa.setArticleVerifyReason("3234");
		System.out.println(sam.addShopArticle(sa));
	}
	
	/**
	 * 修改
	 */
	@Test
	public void updateShopArticleTest() {
		sa.setArticleId(2);
		sa.setArticleTitle("小米mix3");
		sa.setArticleClassId(1);
		sa.setArticleOrigin("1");
		sa.setArticleOriginAddress("1");
		sa.setArticleAuthor("d");
		sa.setArticleAbstract("a");
		sa.setArticleContent("d");
		sa.setArticleImage("d");
		sa.setArticleKeyword("dd");
		sa.setArticleLink("d");
		sa.setArticleGoods("ff");
		sa.setArticleStartTime(32);
		sa.setArticleEndTime(2342);
		sa.setArticlePublishTime(2234);
		sa.setArticleClick(2342);
		sa.setArticleSort(234);
		sa.setArticleCommendFlag(234);
		sa.setArticleCommentFlag(24);
		sa.setArticleVerifyAdmin("123");
		sa.setArticleVerifyTime(123);
		sa.setArticleState(23);
		sa.setArticlePublisherName("sds");
		sa.setArticlePublisherId(123);
		sa.setArticleAttachmentPath("asfad");
		sa.setArticleImageAll("123123");
		sa.setArticleModifyTime(232);
		sa.setArticleTag("1123");
		sa.setArticleCommentCount(123123);
        sa.setArticleCommendImageFlag(131);
		sa.setArticleShareCount(32432);
		sa.setArticleVerifyReason("3234");
		System.out.println(sam.updateShopArticle(sa));
	}
	/**
	 * 物理删除测试
	 */
	@Test
	public void deleteShopArticleTest() {
		System.out.println(sam.deleteShopArticle(2));
	}
}
