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

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopArea;
import com.hzitxx.hitao.mapper.ShopAreaMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=System8082.class)
public class ShopAreaMapperTest {
		@Autowired
		private ShopAreaMapper sam;
		ShopArea sa=new ShopArea();
		/**
		 * 根据编号查询区域信息
		 */
		@Test
		public void findShopArea(){
			Map<String,Object> map=new HashMap<>();
			 List<ShopArea> list = sam.findShopArea(map);
		       System.out.println(list);
		} 
		
		/**
		 * 添加区域信息
		 */
		@Test
		public void addTest(){
			sa.setAreaName("日本县");
			sa.setAreaParentId(123456);
			sa.setAreaSort(0);
			sa.setPostCode(123456);
			sa.setAreaDeep(4);
			sa.setIsDel(0);
			sa.setCreatedTime(new Date());
			System.out.println(sam.addShopArea(sa));
		}
		
		
		/**
		 * 编辑区域信息，逻辑删除
		 */
		@Test
		public void update(){
			sa.setAreaName("北京市");
			sa.setAreaParentId(0);
			sa.setAreaSort(0);
			sa.setPostCode(100000);
			sa.setAreaDeep(1);
			sa.setIsDel(0);
			sa.setUpdatedTime(new Date());
			System.out.println(sam.updateShopArea(sa));
		}
			
}
