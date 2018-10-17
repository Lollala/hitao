package com.hzitxx.hitao.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzitxx.hitao.entity.ShopAdmin;
import com.hzitxx.hitao.mapper.ShopAdminMapper;
import com.hzitxx.hitao.service.ShopAdminService;
import com.hzitxx.hitao.utils.Md5Util;
import com.hzitxx.hitao.utils.PageUtil;
import com.hzitxx.hitao.utils.ServerResponse;

@Service
public class ShopAdminServiceImpl implements ShopAdminService {
	@Autowired
	private ShopAdminMapper mapper;

	/**
	 * 添加管理员
	 */
	@Override
	public ServerResponse<Integer> addShopAdmin(ShopAdmin shopAdmin) {
		try {
			shopAdmin.setAdminPassword(Md5Util.getMD5(shopAdmin.getAdminPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int result = mapper.addShopAdmin(shopAdmin);
		if (result != 1) {
			return ServerResponse.createByErrorMessage("添加失败");
		}
		return ServerResponse.createBySuccessMessage("添加成功");
	}
     /**
      * 分页查询
      */
	@Override
	public ServerResponse<PageUtil<List<ShopAdmin>>> selectShopAdmin(int page, int limit) {
		PageHelper.offsetPage((page - 1) * limit, limit);
		List<ShopAdmin> list = mapper.selectShopAdmin(null);//普通查询sql
		
		//让pageInfo对象去解析shopAdminList里面的数据
		PageInfo<ShopAdmin> pageInfo = new PageInfo<>(list);
        PageUtil<List<ShopAdmin>> pageUtil = new PageUtil<>();
        pageUtil.setCode(0);
        pageUtil.setMsg("管理员数据");
        pageUtil.setCount(pageInfo.getTotal());
        pageUtil.setData(pageInfo.getList());
		return ServerResponse.createBySuccess("管理员数据", pageUtil);
	}
	/**
	 * 查询一条数据
	 */
	@Override
	public ServerResponse<ShopAdmin> findone(Integer adminId) {
		ShopAdmin shopAdmin =mapper.findone(adminId);
		if (shopAdmin==null) {
			return ServerResponse.createByErrorMessage("查询失败");
		}
		//查询成功,返回这条数据信息
		return ServerResponse.createBySuccess(shopAdmin);
	}
	/**
	 * 更新
	 */
	@Override
	public ServerResponse<Integer> updateShopAdmin(ShopAdmin shopAdmin) {
		 int result = mapper.updateShopAdmin(shopAdmin);
		 if (result!=1) {
			return ServerResponse.createByErrorMessage("更新失败");
		}
		 return ServerResponse.createBySuccessMessage("更新成功");
	}
	/**
	 * 物理删除
	 */
	@Override
	public ServerResponse<Integer> deleteShopAdmin(Integer adminId) {
		int result = mapper.deleteShopAdmin(adminId);
		if (result!=1) {
			return ServerResponse.createByErrorMessage("删除失败");
		}
		return ServerResponse.createBySuccessMessage("删除成功");
	}
	/**
	 * 根据用户名和密码查询账号是否存在
	 */
	@Override
	public ServerResponse<Integer> findOneShopAdminByUAP(String username,String password) {
		Map<String,Object> map=new HashMap<>();
		try {
			password=Md5Util.getMD5(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int result=mapper .findOneShopAdminByUAP(map);
		if(result!=1) {
			return ServerResponse.createByErrorMessage("查找失败！");
		}
		return ServerResponse.createBySuccessMessage("查找成功！");
	}

}
