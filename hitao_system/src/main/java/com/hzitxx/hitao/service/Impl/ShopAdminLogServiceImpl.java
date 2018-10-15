package com.hzitxx.hitao.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.entity.ShopAdminLog;
import com.hzitxx.hitao.mapper.ShopAdminLogMapper;
import com.hzitxx.hitao.service.ShopAdminLogService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;
/**
 * 管理员操作日志
 * @author WE1
 *
 */
@Service
public class ShopAdminLogServiceImpl implements ShopAdminLogService {
	@Autowired
	private ShopAdminLogMapper shopAdminLogMappse;
	
	@Override
	public ServerResponse<LayuiEntity<ShopAdminLog>> findShopAdminLog(Integer page,Integer limit,Map<String, Object> map) {
		PageHelper.startPage(page, limit);
		List<ShopAdminLog> adminLogList=shopAdminLogMappse.findShopAdminLog(map);
		PageInfo<ShopAdminLog> pageInfo=new PageInfo<>(adminLogList);
		LayuiEntity<ShopAdminLog> layuiEntity=new LayuiEntity<ShopAdminLog>();
		layuiEntity.setCode(0);
		layuiEntity.setMsg("数据");
		layuiEntity.setCount(pageInfo.getTotal());
		layuiEntity.setData(pageInfo.getList());
		return ServerResponse.createBySuccess(layuiEntity);
	}

	@Override
	public ServerResponse<?> addShopAdminLog(ShopAdminLog shopAdminLog) {
		int result=shopAdminLogMappse.addShopAdminLog(shopAdminLog);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("添加失败！");
		}
		return ServerResponse.createBySuccessMessage("添加成功！");
	}

	@Override
	public ServerResponse<?> updateShopAdminLog(ShopAdminLog shopAdminLog) {
		int result=shopAdminLogMappse.updateShopAdminLog(shopAdminLog);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("修改失败！");
		}
		return ServerResponse.createBySuccessMessage("修改成功！");
	}

	@Override
	public ServerResponse<?> deleteShopAdminLog(Integer logId) {
		int result=shopAdminLogMappse.deleteShopAdminLog(logId);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("删除失败！");
		}
		return ServerResponse.createBySuccessMessage("删除成功！");
	}

}
