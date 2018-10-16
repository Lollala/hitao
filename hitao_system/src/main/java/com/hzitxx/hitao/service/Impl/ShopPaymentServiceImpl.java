package com.hzitxx.hitao.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.entity.ShopGoods;
import com.hzitxx.hitao.entity.ShopPayment;
import com.hzitxx.hitao.mapper.ShopPaymentMapper;
import com.hzitxx.hitao.service.ShopPaymentService;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;
@Service
public class ShopPaymentServiceImpl implements ShopPaymentService{
    @Autowired
    private ShopPaymentMapper mapper;
	@Override
	public ServerResponse<Integer> addShopPayment(ShopPayment shopPayment) {
		int result=mapper.addShopPayment(shopPayment);
		if (result != 1) {
			return ServerResponse.createByErrorMessage("添加失败");
		}
		return ServerResponse.createBySuccessMessage("添加成功");
	}

	@Override
	public ServerResponse<Integer> updateShopPayment(ShopPayment shopPayment) {
		int result = mapper.updateShopPayment(shopPayment);
		if (result != 1) {
			return ServerResponse.createByErrorMessage("更新失败");
		}
		return ServerResponse.createBySuccessMessage("更新成功");
	}

	@Override
	public ServerResponse<ShopPayment> deleteShopPayment(Integer paymentId) {
		int result = mapper.deleteShopPayment(paymentId);
		if (result != 1) {
			return ServerResponse.createByErrorMessage("删除失败");
		}
		return ServerResponse.createBySuccessMessage("删除成功");
	}

	@Override
	public ServerResponse<ShopPayment> findoneShopPayment(Integer paymentId) {
		ShopPayment shopPayment = mapper.findone(paymentId);
		if (shopPayment == null) {
			return ServerResponse.createByErrorMessage("查询失败");
		}
		// 查询成功,返回这条数据信息
		return ServerResponse.createBySuccess("查询成功", shopPayment);
	}

	@Override
	public ServerResponse<PageUtil<List<ShopPayment>>> selectShopPayment(int page, int limit, Map<String, Object> map) {
		PageHelper.offsetPage((page-1)*limit, limit);
		List<ShopPayment> list = mapper.selectShopPayment(map);
		//解析这些数据
		PageInfo<ShopPayment> pageInfo = new PageInfo<>(list);
		PageUtil<List<ShopPayment>> pageUtil = new PageUtil<>();
		pageUtil.setCode(0);
		pageUtil.setCount(pageInfo.getTotal());
		pageUtil.setData(pageInfo.getList());
		pageUtil.setMsg("支付方式表数据");
		return ServerResponse.createBySuccess("支付方式表数据", pageUtil);
	}

}
