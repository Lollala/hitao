package com.hzitxx.hitao.mapper;

import java.util.List;
import java.util.Map;

import com.hzitxx.hitao.entity.ShopArticle;

/**
 * CMS文章表
 * @author WE1
 *
 */
public interface ShopArticleMapper {
	/**
	 * 查询文章信息
	 * @param map
	 * @return
	 */
	public List<ShopArticle> findShopArticle(Map<String,Object> map);
	/**
	 * 添加文章信息
	 * @param shopArticle
	 * @return
	 */
	public int addShopArticle(ShopArticle shopArticle); 
	/**
	 * 修改文章信息
	 * @param shopArticle
	 * @return
	 */
	public int updateShopArticle(ShopArticle shopArticle);
	/**
	 * 物理删除文章信息
	 * @param articleId
	 * @return
	 */
	public int deleteShopArticle(Integer articleId);
}
