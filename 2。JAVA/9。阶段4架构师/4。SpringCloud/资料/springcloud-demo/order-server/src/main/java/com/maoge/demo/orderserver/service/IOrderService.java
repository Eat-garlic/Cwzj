package com.maoge.demo.orderserver.service;

import com.maoge.demo.orderserver.domain.Order;

public interface IOrderService {
    public Order save(Long userId, Long productId);
}
