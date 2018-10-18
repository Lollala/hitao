package com.hzitxx.hitao.service;

import com.hzitxx.hitao.utils.ServerResponse;
import com.hzitxx.hitao.utils.LayuiEntity;
import com.hzitxx.hitao.entity.ArticleClass;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章分类表 服务类
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */

public interface IArticleClassService  {
    ServerResponse addArticleClass(ArticleClass articleClass);

    ServerResponse addArticleClassSelective(ArticleClass obj);

    ServerResponse deleteById(int acId);

    ServerResponse deleteByIds(String[] ids);

    ServerResponse updateById(ArticleClass articleClass);

    ServerResponse updateSelectiveById(ArticleClass articleClass);

    ServerResponse<List<ArticleClass>> searchArticleClass(Map<String,Object> map);

    /**
     * 数据查询分页
     * @param page
     * @param limit
     * @param map
     * @return
     */
    ServerResponse<LayuiEntity<ArticleClass>> page(int page, int limit, Map<String,Object> map);

    /**
     * 根据编号查询数据
     *
     */
    ServerResponse<ArticleClass> findOne(Integer acId);

}
