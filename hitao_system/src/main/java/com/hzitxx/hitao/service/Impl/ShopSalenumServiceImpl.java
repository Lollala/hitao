package com.hzitxx.hitao.service.Impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.entity.ShopSalenum;
import com.hzitxx.hitao.mapper.ShopSalenumMapper;
import com.hzitxx.hitao.service.ShopSalenumService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

@Service
public class ShopSalenumServiceImpl implements ShopSalenumService {
	@Autowired
	private ShopSalenumMapper shopSalenumMapper;
	
	@Override
	public ServerResponse<LayuiEntity<ShopSalenum>> findShopSalenum(Integer page, Integer limit,
			Map<String, Object> map) {
		PageHelper.startPage(page, limit);//分页工具分页
		List<ShopSalenum> SalenumList=shopSalenumMapper.findAll(map);//获取数据
		PageInfo<ShopSalenum> pageInfo=new PageInfo<>(SalenumList);//解析分页处理后的数据
		LayuiEntity<ShopSalenum> layuiEntity=new LayuiEntity<>();
		layuiEntity.setCode(0);
		layuiEntity.setMsg("数据");
		layuiEntity.setCount(pageInfo.getTotal());
		layuiEntity.setData(pageInfo.getList());
		return ServerResponse.createBySuccess(layuiEntity);
	}

	@Override
	public ServerResponse<?> addShopSalenum(ShopSalenum shopSalenum) {
		int result=this.shopSalenumMapper.addShopSalenum(shopSalenum);
		if(result!=1) {
			return ServerResponse.createBySuccessMessage("添加失败！");
		}
		return ServerResponse.createByErrorMessage("添加成功！");
	}

	@Override
	public ServerResponse<?> updateShopSalenum(ShopSalenum shopSalenum) {
		int result=this.shopSalenumMapper.updateShopSalenum(shopSalenum);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("添加失败！");
		}
		return ServerResponse.createBySuccessMessage("添加成功");
	}

	@Override
	public ServerResponse<?> deleteShopSalenum(Integer id) {
		int result=this.shopSalenumMapper.delectShopSalenum(id);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("添加失败！");
		}
		return ServerResponse.createBySuccessMessage("添加成功 ！");
	}

}
