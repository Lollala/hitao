package com.hzitxx.hitao.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.entity.ShopAddress;
import com.hzitxx.hitao.entity.ShopSetting;
import com.hzitxx.hitao.mapper.ShopSettingMapper;
import com.hzitxx.hitao.service.ShopSettingService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

@Service
public class ShopSettingServiceImpl implements ShopSettingService{
	@Autowired
	private ShopSettingMapper shopSettingMapper;
	
	/**
	 * 分页
	 */
	@Override
	public ServerResponse<LayuiEntity<ShopSetting>> findShopSetting(Integer page, Integer limit,
			Map<String, Object> map) {
		PageHelper.startPage(page, limit);//Mybatis分页工具分页
		List<ShopSetting> settingsList=shopSettingMapper.findShopSetting(map);
		PageInfo<ShopSetting> pageInfo=new PageInfo<>(settingsList);//解析分页后的数据
		LayuiEntity<ShopSetting> layuiEntity=new LayuiEntity<>();
		layuiEntity.setCode(0);
		layuiEntity.setMsg("数据");
		layuiEntity.setCount(pageInfo.getTotal());
		layuiEntity.setData(pageInfo.getList());
		return ServerResponse.createBySuccess(layuiEntity);
		
	}
	/**
	 * 添加
	 */
	@Override
	public ServerResponse<?> addShopSetting(ShopSetting shopSetting) {
		int result=shopSettingMapper.addShopSetting(shopSetting);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("添加失败！");
		}
		return ServerResponse.createBySuccessMessage("添加成功！");
		
	}
	
	/**
	 * 更新
	 */
	@Override
	public ServerResponse<?> updateShopSetting(ShopSetting shopSetting) {
		int result=shopSettingMapper.updateShopSetting(shopSetting);
		if(result!=1){
			return ServerResponse.createByErrorMessage("更新失败");
		}
		return ServerResponse.createBySuccessMessage("更新成功");
	}
	
	/**
	 * 删除
	 */
	@Override
	public ServerResponse<?> deleteShopSetting(Integer id) {
		int  result=shopSettingMapper.deleteShopSetting(id);
		if (result!=1) {
			return ServerResponse.createByErrorMessage("删除失败");
		}
		return ServerResponse.createBySuccessMessage("删除成功");
	}
	
	
	
}
