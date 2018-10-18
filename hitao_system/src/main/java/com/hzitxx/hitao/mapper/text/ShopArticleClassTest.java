package com.hzitxx.hitao.mapper.text;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.mapper.ArticleClassMapper;
import com.hzitxx.hitao.mapper.PermissionRouteMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = System8082.class)
public class ShopArticleClassTest {
	@Autowired
	private ArticleClassMapper acm;
	@Autowired
	private PermissionRouteMapper prm;
	
	@Test
	public void find() {
		Map<String,Object> map=new HashMap<>();
		map.put("acId", 5);
		System.out.println(acm.searchArticleClass(map));
	}
}
