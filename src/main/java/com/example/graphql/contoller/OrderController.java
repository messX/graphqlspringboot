package com.example.graphql.contoller;

import com.example.graphql.entity.Order;
import com.example.graphql.services.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    IOrderService orderService;

    @GetMapping(name="getOrder", path = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrder(@PathVariable("orderId") Integer orderId){
        log.info(String.format("Getting role data for %d", orderId));
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
}
