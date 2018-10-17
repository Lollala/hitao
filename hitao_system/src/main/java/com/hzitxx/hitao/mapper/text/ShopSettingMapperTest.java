package com.hzitxx.hitao.mapper.text;

import java.util.List;

import org.antlr.stringtemplate.StringTemplate.STAttributeList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopBrand;
import com.hzitxx.hitao.entity.ShopSetting;
import com.hzitxx.hitao.mapper.ShopSettingMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=System8082.class)
public class ShopSettingMapperTest {
		@Autowired
		private ShopSettingMapper ssm;
		ShopSetting st= new ShopSetting();
		/**
		 * 增加
		 */
		@Test
		public void addTest(){
			st.setName("黄瓜");
			st.setValue("2333");
			System.out.println(ssm.addShopSetting(st));
		}
		
		/**
		 * 查询
		 */
		@Test
		public void selectTest(){
			List<ShopSetting> list = ssm.findShopSetting(null);
		       System.out.println(list);
		}
		/**
		 * 更新/编辑
		 */
		@Test
		public void updateTest(){
			st.setId(1);
			st.setName("巧");
			st.setValue("555");
			System.out.println(ssm.updateShopSetting(st));
		}
		/**
		 * 删除
		 */
		@Test
		public void deleteTest(){
			System.out.println(ssm.deleteShopSetting(2));
		}
}
