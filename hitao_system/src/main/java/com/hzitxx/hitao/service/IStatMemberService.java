package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.StatMember;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 会员相关数据统计 服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface IStatMemberService  {
    ServerResponse addStatMember(StatMember statMember);

    ServerResponse addStatMemberSelective(StatMember obj);

    ServerResponse deleteById(int statmId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(StatMember statMember);

    ServerResponse updateSelectiveById(StatMember statMember);

    ServerResponse<List<StatMember>> searchStatMember(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<StatMember>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<StatMember> findOne(Integer statmId);

}
