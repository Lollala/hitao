package com.hzitxx.hitao.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.entity.ShopMenu;
import com.hzitxx.hitao.entity.ShopOrder;
import com.hzitxx.hitao.mapper.ShopOrderMapper;
import com.hzitxx.hitao.service.ShopOrderService;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;
@Service
public class ShopOrderServiceImpl implements ShopOrderService{
    @Autowired
    private ShopOrderMapper mapper;
	@Override
	public ServerResponse<Integer> addShopOrder(ShopOrder shopOrder) {
		int result = mapper.addShopOrder(shopOrder);
		if (result != 1) {
			return ServerResponse.createByErrorMessage("添加失败");
		}
		return ServerResponse.createBySuccessMessage("添加成功");
	}

	@Override
	public ServerResponse<Integer> updateShopOrder(ShopOrder shopOrder) {
		int result = mapper.updateShopOrder(shopOrder);
		if (result!=1) {
			return ServerResponse.createByErrorMessage("更新失败");
		}
		 return ServerResponse.createBySuccessMessage("更新成功");
	}

	@Override
	public ServerResponse<Integer> deleteShopOrder(Integer orderId) {
		int result = mapper.deleteShopOrder(orderId);
		if (result!=1) {
			return ServerResponse.createByErrorMessage("删除失败");
		}
		return ServerResponse.createBySuccessMessage("删除成功");
	}

	@Override
	public ServerResponse<ShopOrder> findone(Integer orderId) {
		ShopOrder shopOrder = mapper.findone(orderId);
		if (shopOrder==null) {
			return ServerResponse.createByErrorMessage("查询失败");
		}
		return ServerResponse.createBySuccess("查询成功", shopOrder);
	}

	@Override
	public ServerResponse<PageUtil<List<ShopOrder>>> selectShopOrder(int page, int limit, Map<String, Object> map) {
		PageHelper.offsetPage((page-1)*limit, limit); //分页
		List<ShopOrder> list = mapper.selectShopOrder(map);
		//获取到数据后让pageinfo去解析
		PageInfo<ShopOrder> pageInfo = new PageInfo<>(list);
		PageUtil<List<ShopOrder>> pageUtil = new PageUtil<>();
		pageUtil.setCode(0);
		pageUtil.setCount(pageInfo.getTotal());
		pageUtil.setData(pageInfo.getList());
		pageUtil.setMsg("订单表数据");
		return ServerResponse.createBySuccess("订单表数据", pageUtil);
	}

}
