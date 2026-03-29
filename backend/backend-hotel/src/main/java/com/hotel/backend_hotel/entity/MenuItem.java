package com.hotel.backend_hotel.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "menu_items")
public class MenuItem {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        // many menu items belong to one restaurant
        @ManyToOne
        @JoinColumn(name = "restaurant_id")
        private Restaurant restaurant;
        private String name;
        private String description;
        private double price;
        private String category; // eg: Starters, Main Course, Desserts
        private boolean isAvailable; // true means available to order
    }
}
