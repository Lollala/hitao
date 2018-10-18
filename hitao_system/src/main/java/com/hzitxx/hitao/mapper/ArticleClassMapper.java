package com.hzitxx.hitao.mapper;

import com.hzitxx.hitao.entity.ArticleClass;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章分类表 Mapper 接口
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public interface ArticleClassMapper{

    int addArticleClass(ArticleClass obj);

    int addArticleClassSelective(ArticleClass obj);

    int deleteById(int acId);
                                    
    int deleteByIds(String[] ids);

    int updateById(ArticleClass articleClass);

    int updateSelectiveById(ArticleClass articleClass);

    ArticleClass findOne(Integer acId);
                                    
    List<ArticleClass> searchArticleClass(Map<String,Object> map);
}