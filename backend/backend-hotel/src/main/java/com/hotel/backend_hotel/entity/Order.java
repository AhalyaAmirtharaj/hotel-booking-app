package com.hotel.backend_hotel.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class Order {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @ManyToOne @JoinColumn(name = "user_id")
        private User user;
        @ManyToOne @JoinColumn(name = "restaurant_id")
        private Restaurant restaurant;
        private double totalAmount;
        private String deliveryAddress;
        private String status; // PLACED, PREPARING, DELIVERED, CANCELLED
        private LocalDateTime createdAt;
}
