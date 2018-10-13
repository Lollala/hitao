package com.hzitxx.hitao.Test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzitxx.System8082;
import com.hzitxx.hitao.entity.ShopBrand;
import com.hzitxx.hitao.mapper.ShopBrandMapper;

@RunWith(SpringJUnit4ClassRunner.class) //指定junit类,让其创建ioc容器
@SpringBootTest(classes=System8082.class)
public class TestShopBrandMapper {
	@Autowired
	private ShopBrandMapper mapper;
	
     /**
      * 测试查询所有品牌信息
      */
	@Test
	public void testSel() {
       List<ShopBrand> list = mapper.selectShopBrand();
       System.out.println(list);
	}
	/**
	 * 测试添加一个品牌
	 */
	@Test
	public void testAdd(){
		ShopBrand shopBrand = new ShopBrand();
		shopBrand.setBrandApply(1);
		shopBrand.setBrandClass("gay");
		shopBrand.setBrandName("高德伟1号");
		shopBrand.setBrandPic("xxx.png");
		shopBrand.setBrandRecommend(1);
		shopBrand.setBrandSort(1);
		shopBrand.setClassId(2);
		shopBrand.setCreatedTime(new Date());
		shopBrand.setIsDel(0);
		mapper.addShopBrand(shopBrand);
	}
	/**
	 * 更新品牌表+逻辑删除
	 */
	@Test
	public void testUpdate(){
		ShopBrand shopBrand = new ShopBrand();
		shopBrand.setBrandId(15);
		/*shopBrand.setBrandApply(1);
		shopBrand.setBrandClass("gay");
		shopBrand.setBrandName("高德伟2号");
		shopBrand.setBrandPic("xxx.png");
		shopBrand.setBrandRecommend(1);
		shopBrand.setBrandSort(1);
		shopBrand.setClassId(2);
		shopBrand.setUpdatedTime(new Date());*/
		shopBrand.setIsDel(0);
		mapper.updateShopBrand(shopBrand);
	}
	/**
	 * 删除品牌信息,物理删除
	 */
	@Test
	public void testDel(){
		mapper.deleteShopBrand(15);
	}
	@Test
	public void testFindone(){
		ShopBrand shopBrand = mapper.findone(17);
		System.out.println(shopBrand);
	}
}
