package com.hotel.backend_hotel.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order_items")
public class OrderItem {

    public class OrderItem {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @ManyToOne @JoinColumn(name = "order_id")
        private Order order;
        @ManyToOne @JoinColumn(name = "menu_item_id")
        private MenuItem menuItem;
        private int quantity;
        private double price;}
    }
