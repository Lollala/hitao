package com.hzitxx.hitao.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.entity.ShopMessage;
import com.hzitxx.hitao.mapper.ShopMessageMapper;
import com.hzitxx.hitao.service.ShopMessageService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

@Service
public class ShopMessageServiceImpl implements ShopMessageService {
	@Autowired
	private ShopMessageMapper shopMessageMapper;

	@Override
	public ServerResponse<LayuiEntity<ShopMessage>> findShopMessage(Integer page, Integer limit,
			Map<String, Object> map) {
		PageHelper.startPage(page, limit);//Mybatis分页工具分页
		List<ShopMessage> messageList=shopMessageMapper.selectShopMessage(map);
		PageInfo<ShopMessage> pageInfo=new PageInfo<>(messageList);//解析分页后的数据
		LayuiEntity<ShopMessage> layuiEntity=new LayuiEntity<>();
		layuiEntity.setCode(0);
		layuiEntity.setMsg("数据");
		layuiEntity.setCount(pageInfo.getTotal());
		layuiEntity.setData(pageInfo.getList());
		return ServerResponse.createBySuccess(layuiEntity);
	}

	@Override
	public ServerResponse<?> addShopMessage(ShopMessage shopMessage) {
		int result=shopMessageMapper.addShopMessage(shopMessage);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("添加失败！");
		}
		return ServerResponse.createBySuccessMessage("添加成功！");
	}

	@Override
	public ServerResponse<?> updateShopMessage(ShopMessage shopMessage) {
		int result=shopMessageMapper.updateShopMessage(shopMessage);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("修改失败！");
		}
		return ServerResponse.createBySuccessMessage("修改成功！");
	}

	@Override
	public ServerResponse<?> deleteShopMessage(Integer messageId) {
		int result=shopMessageMapper.deleteShopMessage(messageId);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("删除失败！");
		}
		return ServerResponse.createBySuccessMessage("删除成功！");
	}

}
