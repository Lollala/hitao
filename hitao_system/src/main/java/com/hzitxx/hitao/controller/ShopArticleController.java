package com.hzitxx.hitao.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hzitxx.hitao.entity.ShopArticle;
import com.hzitxx.hitao.service.ShopArticleService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

/**
 *  CMS文章表
 * @author WE1
 *
 */
@Controller
public class ShopArticleController {
	@Autowired
	private ShopArticleService shopArticleService;
	private Map<String,Object> map=new HashMap<>();
	/**
	 * 分页查询
	 * @param page
	 * @param limit
	 * @param articleTitle
	 * @return
	 */
	@GetMapping("/findShopArticle")
	@ResponseBody
	public ServerResponse<LayuiEntity<ShopArticle>> findShopArticle(@RequestParam("page")Integer page,
			@RequestParam("limit")Integer limit,String articleTitle){
		if(StringUtils.isEmpty(articleTitle)) {
			map.put("articleTitle", articleTitle);
		}
		return shopArticleService.findShopArticle(page, limit, map);
	}
	/**
	 * 添加文章信息
	 * @param shopArticle
	 * @return
	 */
	@GetMapping("/addShopArticle")
	@ResponseBody
	public ServerResponse<?> addShopArticle(ShopArticle shopArticle){
		return shopArticleService.addShopArticle(shopArticle);
	}
	/**
	 * 修改文章信息
	 * @param shopArticle
	 * @return
	 */
	@GetMapping("/updateShopArticle")
	@ResponseBody
	public ServerResponse<?> updateShopArticle(ShopArticle shopArticle){
		return shopArticleService.updateShopArticle(shopArticle);
	}
	/**
	 * 物理删除文章信息
	 * @param articleId
	 * @return
	 */
	@GetMapping("/deleteShopArticle")
	@ResponseBody
	public ServerResponse<?> deleteShopArticle(Integer articleId){
		return shopArticleService.deleteShopArticle(articleId);
	}
}
