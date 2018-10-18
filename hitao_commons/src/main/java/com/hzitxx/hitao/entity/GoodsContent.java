package com.hzitxx.hitao.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 商品内容表
 * </p>
 *
 * @author WE1
 * @since 2018-10-17
 */
public class GoodsContent implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 商品编号，主键值来自商品表
     */
    private Integer goodsId;
    /**
     * 商品内容
     */
    private String content;
    /**
     * 录入时间
     */
    private Date createdTime;
    /**
     * 修改时间
     */
    private Date updatedTime;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
 
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
 
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
 
    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
 


    @Override
    public String toString() {
        return "GoodsContent{" +
        "goodsId=" + goodsId +
        ", content=" + content +
        ", createdTime=" + createdTime +
        ", updatedTime=" + updatedTime +
        "}";
    }
}