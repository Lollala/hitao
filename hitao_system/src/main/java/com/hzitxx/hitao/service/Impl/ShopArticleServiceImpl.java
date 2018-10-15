package com.hzitxx.hitao.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.entity.ShopArticle;
import com.hzitxx.hitao.mapper.ShopArticleMapper;
import com.hzitxx.hitao.service.ShopArticleService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;
/**
 *  CMS文章表
 * @author WE1
 *
 */
@Service
public class ShopArticleServiceImpl implements ShopArticleService {
	@Autowired
	private ShopArticleMapper shopArticleMapper;
	@Override
	public ServerResponse<LayuiEntity<ShopArticle>> findShopArticle(Integer page, Integer limit,
			Map<String, Object> map) {
		PageHelper.startPage(page, limit);//分页工具分页
		List<ShopArticle> articleList=shopArticleMapper.findShopArticle(map);//获取数据
		PageInfo<ShopArticle> pageInfo=new PageInfo<>(articleList);//解析分页处理后的数据
		LayuiEntity<ShopArticle> layuiEntity=new LayuiEntity<>();
		layuiEntity.setCode(0);
		layuiEntity.setMsg("数据");
		layuiEntity.setCount(pageInfo.getTotal());
		layuiEntity.setData(pageInfo.getList());
		return ServerResponse.createBySuccess(layuiEntity);
	}

	@Override
	public ServerResponse<?> addShopArticle(ShopArticle shopArticle) {
		int result=this.shopArticleMapper.addShopArticle(shopArticle);
		if(result!=1) {
			return ServerResponse.createBySuccessMessage("添加失败！");
		}
		return ServerResponse.createByErrorMessage("添加成功！");
	}

	@Override
	public ServerResponse<?> updateShopArticle(ShopArticle shopArticle) {
		int result=this.shopArticleMapper.updateShopArticle(shopArticle);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("添加失败！");
		}
		return ServerResponse.createBySuccessMessage("添加成功");
	}

	@Override
	public ServerResponse<?> deleteShopArticle(Integer articleId) {
		int result=this.shopArticleMapper.deleteShopArticle(articleId);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("添加失败！");
		}
		return ServerResponse.createBySuccessMessage("添加成功 ！");
	}

}
