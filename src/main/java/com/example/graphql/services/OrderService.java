package com.example.graphql.services;

import com.example.graphql.entity.Order;
import com.example.graphql.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderService implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElseThrow(() -> {
            log.error(String.format("Invalid order id %d", id));
            return new RuntimeException("Invalid order id");
        });
    }
}
