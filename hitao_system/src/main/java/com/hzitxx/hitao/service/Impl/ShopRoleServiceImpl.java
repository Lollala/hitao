package com.hzitxx.hitao.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.entity.ShopRole;
import com.hzitxx.hitao.mapper.ShopRoleMapper;
import com.hzitxx.hitao.service.ShopRoleService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;
/**
 * 平台后台角色表
 * @author WE1
 *
 */
@Service
public class ShopRoleServiceImpl implements ShopRoleService {
	
	@Autowired
	private ShopRoleMapper shopRoleMapper;
	
	@Override
	public ServerResponse<LayuiEntity<ShopRole>> findShopRole(Integer page, Integer limit, Map<String, Object> map) {
		PageHelper.startPage(page, limit);//利用mybatis分页工具在获取数据时分页处理
		List<ShopRole> roleList=shopRoleMapper.findShopRole(map);
		PageInfo<ShopRole> pageInfo=new PageInfo<>(roleList);
		LayuiEntity<ShopRole> layuiEntity=new LayuiEntity<>();
		layuiEntity.setCode(0);
		layuiEntity.setMsg("数据");
		layuiEntity.setCount(pageInfo.getTotal());
		layuiEntity.setData(pageInfo.getList());
		return ServerResponse.createBySuccess(layuiEntity);
	}

	@Override
	public ServerResponse<?> addShopRole(ShopRole shopRole) {
		int result=shopRoleMapper.addShopRole(shopRole);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("添加失败！");
		}
		return ServerResponse.createBySuccessMessage("添加成功！");
	}

	@Override
	public ServerResponse<?> updateShopRole(ShopRole shopRole) {
		int result=shopRoleMapper.updateShopRole(shopRole);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("修改失败！");
		}
		return ServerResponse.createBySuccessMessage("修改成功！");
	}

	@Override
	public ServerResponse<?> deleteShopRole(Integer roleId) {
		int result=shopRoleMapper.deleteShopRole(roleId);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("删除失败！");
		}
		return ServerResponse.createBySuccessMessage("删除成功！");
	}

}
