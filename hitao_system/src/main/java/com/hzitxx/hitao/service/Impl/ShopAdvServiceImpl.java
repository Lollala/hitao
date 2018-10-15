package com.hzitxx.hitao.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.entity.ShopAdv;
import com.hzitxx.hitao.mapper.ShopAdvMapper;
import com.hzitxx.hitao.service.ShopAdvService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;
/**
 * 广告表
 * @author WE1
 *
 */
@Service
public class ShopAdvServiceImpl implements ShopAdvService {
	@Autowired
	private ShopAdvMapper sam;
	
	
	@Override
	public ServerResponse<LayuiEntity<ShopAdv>> findAllShopAdv(Integer page, Integer limit, Map<String, Object> map) {
		PageHelper.startPage(page, limit);//分页
		List<ShopAdv> advList=sam.findAllShopAdv(map);//获取数据
//		System.out.println(advList);
		PageInfo<ShopAdv> pageInfo=new PageInfo<>(advList);//将advList解析，因为它不是一个list对象，而是一个pagehelper对象
		LayuiEntity<ShopAdv> layuiEntity=new LayuiEntity<>();//创建返回工具类
		layuiEntity.setCode(0);
		layuiEntity.setMsg("数据");
		layuiEntity.setCount(pageInfo.getTotal());
		layuiEntity.setData(pageInfo.getList());
		return ServerResponse.createBySuccess(layuiEntity);
	}

	@Override
	public ServerResponse<?> addShopAdv(ShopAdv shopAdv) {
		int result=this.sam.addShopAdv(shopAdv);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("添加失败！");
		}
		return ServerResponse.createBySuccessMessage("添加成功！");
	}

	@Override
	public ServerResponse<?> updateShopAdv(ShopAdv shopAdv) {
		int result=this.sam.updateShopAdv(shopAdv);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("添加失败！");
		}
		return ServerResponse.createBySuccessMessage("添加成功！");
	}

	@Override
	public ServerResponse<?> deleteShopAdv(Integer advId) {
		int result=this.sam.deleteShopAdv(advId);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("添加失败！");
		}
		return ServerResponse.createBySuccessMessage("添加成功！");
	}

}
