package com.hzitxx.hitao.Test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopExpress;
import com.hzitxx.hitao.mapper.ShopexpressMapper;

@RunWith(SpringJUnit4ClassRunner.class) //指定junit类,让其创建ioc容器
@SpringBootTest(classes=System8082.class)
public class TestShopExpressMapper {
	@Autowired
	private ShopexpressMapper mapper;
	/**
	 * 测试查询快递公司信息
	 */
   @Test
   public void testSel(){
	   //System.out.println(mapper);
	   //org.apache.ibatis.binding.MapperProxy@3daf03d8
	  List<ShopExpress> list = mapper.selectShopexpress();
	  System.out.println(list);
   }
   /**
    * 测试添加快递公司信息
    */
   @Test
   public void testAdd(){
	   ShopExpress shopExpress = new ShopExpress();
	   shopExpress.seteName("晨晨快递");
	   shopExpress.seteLetter("c");
	   shopExpress.seteCode("10033");
	   shopExpress.seteOrder(2);
	   shopExpress.seteState(0);
	   shopExpress.seteUrl("www.cc.com");
	   shopExpress.setIsDel(0);
	   int result = mapper.addShopexpress(shopExpress);
	   System.out.println(result);
	   
   }
   /**
    * 测试根新快递公司信息+逻辑删除
    */
   @Test
   public void testUpdate(){
	   ShopExpress shopExpress = new ShopExpress();
	   /*shopExpress.seteName("晨晨快递2");
	   shopExpress.seteLetter("c");
	   shopExpress.seteCode("10033");
	   shopExpress.seteOrder(2);
	   shopExpress.seteState(0);
	   shopExpress.seteUrl("www.cc.com");*/
	   shopExpress.setIsDel(1);
	   shopExpress.setId(3);
	   int result = mapper.updateShopExpress(shopExpress);
	   System.out.println(result);
   }
   /**
    * 真删除  delete
    */
   @Test
   public void testDel(){
	   int id=2;
	   id=mapper.deleteShopExpress(id);
	   System.out.println(id);
   }
   @Test
   public void testFindone(){
	   ShopExpress shopExpress = mapper.findone(2);
	   System.out.println(shopExpress);
   }
}
