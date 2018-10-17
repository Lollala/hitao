package com.hzitxx.hitao.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.entity.ShopGoods;
import com.hzitxx.hitao.entity.ShopTransport;
import com.hzitxx.hitao.mapper.ShopTransportMapper;
import com.hzitxx.hitao.service.ShopTransportService;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;
@Service
public class ShopTransportServiceImpl implements ShopTransportService{
    @Autowired
    private ShopTransportMapper mapper;
	@Override
	public ServerResponse<Integer> addShopTransport(ShopTransport shopTransport) {
		int result = mapper.addShopTransport(shopTransport);
		if (result != 1) {
			return ServerResponse.createByErrorMessage("添加失败");
		}
		return ServerResponse.createBySuccessMessage("添加成功");
	}

	@Override
	public ServerResponse<Integer> updateShopTransport(ShopTransport shopTransport) {
		int result = mapper.updateTransport(shopTransport);
		if (result != 1) {
			return ServerResponse.createByErrorMessage("更新失败");
		}
		return ServerResponse.createBySuccessMessage("更新成功");
	}

	@Override
	public ServerResponse<Integer> deleteShopTransport(Integer id) {
		int result=mapper.deleteTransport(id);
		if (result != 1) {
			return ServerResponse.createByErrorMessage("删除失败");
		}
		return ServerResponse.createBySuccessMessage("删除成功");
	}

	@Override
	public ServerResponse<ShopTransport> findone(Integer id) {
		ShopTransport shopTransport = mapper.findone(id);
		if (shopTransport == null) {
			return ServerResponse.createByErrorMessage("查询失败");
		}
		// 查询成功,返回这条数据信息
		return ServerResponse.createBySuccess("查询成功", shopTransport);
	}

	@Override
	public ServerResponse<PageUtil<List<ShopTransport>>> selectShopTransport(int page, int limit,
			Map<String, Object> map) {
		PageHelper.offsetPage((page-1)*limit, limit);
		List<ShopTransport> list = mapper.selectShopTransport(map);
		//解析这些数据
		PageInfo<ShopTransport> pageInfo = new PageInfo<>(list);
		PageUtil<List<ShopTransport>> pageUtil = new PageUtil<>();
		pageUtil.setCode(0);
		pageUtil.setCount(pageInfo.getTotal());
		pageUtil.setData(pageInfo.getList());
		pageUtil.setMsg("运费表数据");
		return ServerResponse.createBySuccess("运费表数据", pageUtil);
	}

}
