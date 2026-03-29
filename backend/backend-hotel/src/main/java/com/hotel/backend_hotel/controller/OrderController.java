package com.hotel.backend_hotel.controller;


import com.hotel.backend_hotel.dto.OrderRequestDTO;
import com.hotel.backend_hotel.entity.Order;
import com.hotel.backend_hotel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:5173")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping
    public Order placeOrder(@RequestBody OrderRequestDTO dto) {
        return orderService.placeOrder(dto);
    }
    @PutMapping("/{id}/cancel")
    public Order cancelOrder(@PathVariable Long id) {
        return orderService.cancelOrder(id);
    }
    @GetMapping("/user/{userId}")
    public List getMyOrders(@PathVariable Long userId) {
        return orderService.getMyOrders(userId);
    }
}

