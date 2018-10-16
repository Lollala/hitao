package com.hzitxx.hitao.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.entity.ShopMenu;
import com.hzitxx.hitao.mapper.ShopMenuMapper;
import com.hzitxx.hitao.service.ShopMenuService;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;
/**
 * 菜单表
 * @author Lenovo
 *
 */
@Service
public class ShopMenuServiceImpl implements ShopMenuService{
    @Autowired
    private ShopMenuMapper mapper;
    /**
     * 添加
     * @param shopMenu
     * @return
     */
	@Override
	public ServerResponse<Integer> addShopMenu(ShopMenu shopMenu) {
		int result = mapper.addShopMenu(shopMenu);
		if (result != 1) {
			return ServerResponse.createByErrorMessage("添加失败");
		}
		return ServerResponse.createBySuccessMessage("添加成功");
	}
    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public ServerResponse<Integer> deleteShopMenu(Integer id) {
		int result = mapper.deleteShopMenu(id);
		if (result!=1) {
			return ServerResponse.createByErrorMessage("删除失败");
		}
		return ServerResponse.createBySuccessMessage("删除成功");
	}
    /**
     * 更新
     * @param shopMenu
     * @return
     */
	@Override
	public ServerResponse<Integer> updateShopMenu(ShopMenu shopMenu) {
		int result = mapper.updateShopMenu(shopMenu);
		 if (result!=1) {
			return ServerResponse.createByErrorMessage("更新失败");
		}
		 return ServerResponse.createBySuccessMessage("更新成功");
	}
    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
	@Override
	public ServerResponse<PageUtil<List<ShopMenu>>> selectShopMenu(int page, int limit
			,Map<String, Object> map) {
		PageHelper.offsetPage((page-1)*limit, limit); //分页
		List<ShopMenu> list = mapper.selectShopMenu(map);//普通查询sql
		//获取到数据后让pageinfo去解析
		PageInfo<ShopMenu> pageInfo = new PageInfo<>(list);
		PageUtil<List<ShopMenu>> pageUtil = new PageUtil<>();
		pageUtil.setCode(0);
		pageUtil.setCount(pageInfo.getTotal());
		pageUtil.setData(pageInfo.getList());
		pageUtil.setMsg("菜单表数据");
		return ServerResponse.createBySuccess("菜单表数据", pageUtil);
	}
    /**
     * 查询一条
     * @param id
     * @return
     */
	@Override
	public ServerResponse<ShopMenu> findone(Integer id) {
		ShopMenu shopMenu = mapper.findone(id);
		if (shopMenu==null) {
			return ServerResponse.createByErrorMessage("查询失败");
		}
		return ServerResponse.createBySuccess("查询成功", shopMenu);
	}

}
