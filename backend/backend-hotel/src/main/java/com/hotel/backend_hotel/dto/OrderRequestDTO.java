package com.hotel.backend_hotel.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {


        private Long userId;
        private Long restaurantId;
        private String deliveryAddress;
        private List items; // list of menu items
    }
    // each item in the order

