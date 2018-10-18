package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.MailMsgTemlates;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 邮件模板表 服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface IMailMsgTemlatesService  {
    ServerResponse addMailMsgTemlates(MailMsgTemlates mailMsgTemlates);

    ServerResponse addMailMsgTemlatesSelective(MailMsgTemlates obj);

    ServerResponse deleteById(int id);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(MailMsgTemlates mailMsgTemlates);

    ServerResponse updateSelectiveById(MailMsgTemlates mailMsgTemlates);

    ServerResponse<List<MailMsgTemlates>> searchMailMsgTemlates(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<MailMsgTemlates>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<MailMsgTemlates> findOne(Integer id);

}
