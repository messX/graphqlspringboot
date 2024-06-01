package com.example.graphql.services;

import com.example.graphql.entity.Order;

public interface IOrderService {
    Order create(Order order);
    Order getOrderById(Integer id);
}
