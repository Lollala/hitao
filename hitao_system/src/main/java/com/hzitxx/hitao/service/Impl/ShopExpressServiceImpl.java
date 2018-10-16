package com.hzitxx.hitao.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.entity.ShopExpress;
import com.hzitxx.hitao.entity.ShopGoods;
import com.hzitxx.hitao.mapper.ShopexpressMapper;
import com.hzitxx.hitao.service.ShopExpressService;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;
@Service
public class ShopExpressServiceImpl implements ShopExpressService{
    @Autowired
    private ShopexpressMapper mapper;
	@Override
	public ServerResponse<Integer> addShopExpress(ShopExpress shopExpress) {
		int result = mapper.addShopexpress(shopExpress);
		if (result != 1) {
			return ServerResponse.createByErrorMessage("添加失败");
		}
		return ServerResponse.createBySuccessMessage("添加成功");
	}

	@Override
	public ServerResponse<Integer> updateShopExpress(ShopExpress shopExpress) {
		int result = mapper.updateShopExpress(shopExpress);
		if (result != 1) {
			return ServerResponse.createByErrorMessage("更新失败");
		}
		return ServerResponse.createBySuccessMessage("更新成功");
	}

	@Override
	public ServerResponse<Integer> deleteShopExpress(Integer id) {
		int result = mapper.deleteShopExpress(id);
		if (result != 1) {
			return ServerResponse.createByErrorMessage("删除失败");
		}
		return ServerResponse.createBySuccessMessage("删除成功");
	}

	@Override
	public ServerResponse<ShopExpress> findone(Integer id) {
		ShopExpress shopExpress = mapper.findone(id);
		if (shopExpress == null) {
			return ServerResponse.createByErrorMessage("查询失败");
		}
		// 查询成功,返回这条数据信息
		return ServerResponse.createBySuccess("查询成功", shopExpress);
	}

	@Override
	public ServerResponse<PageUtil<List<ShopExpress>>> selectShopExpress(int page, int limit, Map<String, Object> map) {
		PageHelper.offsetPage((page-1)*limit, limit);
		List<ShopExpress> list = mapper.selectShopexpress(map);
		//解析这些数据
		PageInfo<ShopExpress> pageInfo = new PageInfo<>(list);
		PageUtil<List<ShopExpress>> pageUtil = new PageUtil<>();
		pageUtil.setCode(0);
		pageUtil.setCount(pageInfo.getTotal());
		pageUtil.setData(pageInfo.getList());
		pageUtil.setMsg("快递公司表数据");
		return ServerResponse.createBySuccess("快递公司表数据", pageUtil);
	}

}
