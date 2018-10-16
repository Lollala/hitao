package com.hzitxx.hitao.service;

import com.hzitxx.hitao.entity.ShopPayment;
import com.hzitxx.hitao.utils.ServerResponse;

/**
 * 支付方式表
 * @author Lenovo
 *
 */
public interface ShopPaymentService {
  ServerResponse<Integer> add(ShopPayment shopPayment);
}
