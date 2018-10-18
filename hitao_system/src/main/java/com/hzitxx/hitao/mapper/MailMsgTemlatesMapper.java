package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.MailMsgTemlates;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 邮件模板表 Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface MailMsgTemlatesMapper{

    int addMailMsgTemlates(MailMsgTemlates obj);

    int addMailMsgTemlatesSelective(MailMsgTemlates obj);

    int deleteById(int id);
                            
    int deleteByIds(String[] ids);

    int updateById(MailMsgTemlates mailMsgTemlates);

    int updateSelectiveById(MailMsgTemlates mailMsgTemlates);

    MailMsgTemlates findOne(Integer id);
                            
    List<MailMsgTemlates> searchMailMsgTemlates(Map<String,Object> map);
}