package com.hzitxx.hitao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.hzitxx.hitao.entity.GatewayApiDefine;
import com.hzitxx.hitao.service.IGatewayApiDefineService;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.utils.ServerResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
@RestController
@RequestMapping("/gatewayApiDefine")
public class GatewayApiDefineController {

	@Autowired
	private IGatewayApiDefineService gatewayApiDefineService;

	/**
	 * 分页
	 * 
	 * @return
	 */
	@GetMapping("/show")
	public ServerResponse<LayuiEntity<GatewayApiDefine>> showData(
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit, 
			String value) {
		Map<String, Object> map = new HashMap<>();
		return gatewayApiDefineService.page(page, limit, map);
		
	}

	/**
	 * 处理添加表单
	 * 
	 * @param
	 * @return
	 */
	@PostMapping(value = "/addGatewayApiDefine")
	public ServerResponse addGatewayApiDefine(GatewayApiDefine gatewayApiDefine) {
		return gatewayApiDefineService.addGatewayApiDefine(gatewayApiDefine);
	}

	/**
	 * 根据系统用户编号获取系统用户信息
	 * 
	 * @param adminId
	 * @return
	 */
	@GetMapping("/findOne")
	public ServerResponse findOne(Integer id) {
		return gatewayApiDefineService.findOne(id);
	}

	/**
	 * 处理修改数据表单提交
	 * 
	 * @return
	 */
	@PostMapping("/editGatewayApiDefine")
	public ServerResponse editGatewayApiDefine(GatewayApiDefine gatewayApiDefine) {
		return gatewayApiDefineService.updateById(gatewayApiDefine);
	}

	/**
	 * 根据id批量删除数据
	 * 
	 * @param ids
	 * @return
	 */
	@GetMapping("deleteByIds")
	public ServerResponse deleteByIds(String[] ids) {
		return gatewayApiDefineService.deleteByIds(ids);
	}

	/**
    * 根据id删除数据
    * @return
    */
    @GetMapping("remove")
    public ServerResponse remove(@RequestParam("id") Integer id){
        return gatewayApiDefineService.deleteById(id);
    }
}