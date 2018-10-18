package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.Dic;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface DicMapper{

    int addDic(Dic obj);

    int addDicSelective(Dic obj);

                                    
    int deleteByIds(String[] ids);

    int updateById(Dic dic);

    int updateSelectiveById(Dic dic);

                                    
    List<Dic> searchDic(Map<String,Object> map);
}