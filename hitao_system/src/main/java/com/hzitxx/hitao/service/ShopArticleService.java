package com.hzitxx.hitao.service;
/**
 *  CMS文章表
 * @author WE1
 *
 */

import java.util.Map;

import com.hzitxx.hitao.entity.ShopArticle;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

public interface ShopArticleService {
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @param map
	 * @return
	 */
	public ServerResponse<LayuiEntity<ShopArticle>> findShopArticle(Integer page,Integer limit,Map<String,Object> map);
	/**
	 * 添加文章信息
	 * @param shopArticle
	 * @return
	 */
	public ServerResponse<?> addShopArticle(ShopArticle shopArticle);
	/**
	 * 修改文章信息
	 * @param shopArticle
	 * @return
	 */
	public ServerResponse<?> updateShopArticle(ShopArticle shopArticle);
	/**
	 * 删除文章信息
	 * @param articleId
	 * @return
	 */
	public ServerResponse<?> deleteShopArticle(Integer articleId);
}
