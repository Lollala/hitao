package com.hzitxx.hitao.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.entity.ShopBrand;
import com.hzitxx.hitao.entity.ShopMenu;
import com.hzitxx.hitao.mapper.ShopBrandMapper;
import com.hzitxx.hitao.service.ShopBrandService;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;

public class ShopBrandServiceImpl implements ShopBrandService {
	@Autowired
	private ShopBrandMapper mapper;

	@Override
	public ServerResponse<Integer> addShopBrand(ShopBrand shopBrand) {
		int result = mapper.addShopBrand(shopBrand);
		if (result != 1) {
			return ServerResponse.createByErrorMessage("添加失败");
		}
		return ServerResponse.createBySuccessMessage("添加成功");
	}

	@Override
	public ServerResponse<Integer> deleteShopBrand(Integer brandId) {
		int result = mapper.deleteShopBrand(brandId);
		if (result!=1) {
			return ServerResponse.createByErrorMessage("删除失败");
		}
		return ServerResponse.createBySuccessMessage("删除成功");
	}

	@Override
	public ServerResponse<Integer> updateShopBrand(ShopBrand shopBrand) {
		int result = mapper.updateShopBrand(shopBrand);
		if (result!=1) {
			return ServerResponse.createByErrorMessage("更新失败");
		}
		 return ServerResponse.createBySuccessMessage("更新成功");
	}

	@Override
	public ServerResponse<PageUtil<List<ShopBrand>>> selectShopBrand(int page, int limit, Map<String, Object> map) {
		PageHelper.offsetPage((page-1)*limit, limit); //分页
		List<ShopBrand> list = mapper.selectShopBrand(map);
		//获取到数据后让pageinfo去解析
		PageInfo<ShopBrand> pageInfo = new PageInfo<>(list);
		PageUtil<List<ShopBrand>> pageUtil = new PageUtil<>();
		pageUtil.setCode(0);
		pageUtil.setCount(pageInfo.getTotal());
		pageUtil.setData(pageInfo.getList());
		pageUtil.setMsg("品牌表数据");
		return ServerResponse.createBySuccess("品牌表数据", pageUtil);
	}

	@Override
	public ServerResponse<ShopBrand> findone(Integer brandId) {
		ShopBrand shopBrand = mapper.findone(brandId);
		if (shopBrand==null) {
			return ServerResponse.createByErrorMessage("查询失败");
		}
		return ServerResponse.createBySuccess("查询成功", shopBrand);
	}
}
