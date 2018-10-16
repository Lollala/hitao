package com.hzitxx.hitao.mapper;

import java.util.List;

import com.hzitxx.hitao.entity.ShopInvoice;

/**
 * 买家发票信息表
 * @author Lenovo
 *
 */
public interface ShopInvoiceMapper {
	/**
	 * 增加买家发票
	 * @param shopInvoice
	 * @return
	 */
   int addShopInvoice(ShopInvoice shopInvoice);
   /**
    * 修改买家发票
    * @param shopInvoice
    * @return
    */
   int updateShopInvoice(ShopInvoice shopInvoice);
   /**
    * 物理删除
    * @param invId
    * @return
    */
   int deleteShopInvoice(Integer invId);
   /**
    * 查询一条
    * @param invId
    * @return
    */
   ShopInvoice findone(Integer invId);
   /**
    * 查询所有发票信息
    * @return
    */
   List<ShopInvoice> selectShopInvoice();
}
