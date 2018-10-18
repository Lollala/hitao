package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.StatMember;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 会员相关数据统计 Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface StatMemberMapper{

    int addStatMember(StatMember obj);

    int addStatMemberSelective(StatMember obj);

    int deleteById(int statmId);
                                                
    int deleteByIds(String[] ids);

    int updateById(StatMember statMember);

    int updateSelectiveById(StatMember statMember);

    StatMember findOne(Integer statmId);
                                                
    List<StatMember> searchStatMember(Map<String,Object> map);
}