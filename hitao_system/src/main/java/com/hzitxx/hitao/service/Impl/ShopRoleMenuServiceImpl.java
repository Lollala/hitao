package com.hzitxx.hitao.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.entity.ShopRoleMenu;
import com.hzitxx.hitao.mapper.ShopRoleMenuMapper;
import com.hzitxx.hitao.service.ShopRoleMenuService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;
/**
 * 角色菜单表
 * @author WE1
 *
 */
@Service
public class ShopRoleMenuServiceImpl implements ShopRoleMenuService {
	@Autowired
	private ShopRoleMenuMapper shopRoleMenuMapper;
	@Override
	public ServerResponse<LayuiEntity<ShopRoleMenu>> findShopRoleMenu(Integer page, Integer limit,
			Map<String, Object> map) {
		PageHelper.startPage(page,limit);
		List<ShopRoleMenu> roleMenuList=shopRoleMenuMapper.findShopRoleMenu(map);
		PageInfo<ShopRoleMenu> pageInfo=new  PageInfo<>(roleMenuList);
		LayuiEntity<ShopRoleMenu> layuiEntity=new LayuiEntity<>();
		layuiEntity.setCode(0);
		layuiEntity.setMsg("数据");
		layuiEntity.setCount(pageInfo.getTotal());
		layuiEntity.setData(pageInfo.getList());
		return ServerResponse.createBySuccess(layuiEntity);
	}

	@Override
	public ServerResponse<?> addShopRoleMenu(ShopRoleMenu shopRoleMenu) {
		int result=shopRoleMenuMapper.addShopRoleMenu(shopRoleMenu);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("添加失败！");
		}
		return ServerResponse.createBySuccessMessage("添加成功！");
	}

	@Override
	public ServerResponse<?> updateShopRoleMenu(ShopRoleMenu shopRoleMenu) {
		int result=shopRoleMenuMapper.updateShopRoleMenu(shopRoleMenu);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("修改失败！");
		}
		return ServerResponse.createBySuccessMessage("修改成功！");
	}

	@Override
	public ServerResponse<?> deleteShopRoleMenu(Integer id) {
		int result=shopRoleMenuMapper.deleteShopRoleMenu(id);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("删除失败！");
		}
		return ServerResponse.createBySuccessMessage("删除成功！");
	}

}
