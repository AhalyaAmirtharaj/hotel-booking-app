package com.hotel.backend_hotel.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "restaurants")
public class Restaurant {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String cuisine; // eg: South Indian, Chinese, Fast Food
        private String location;
        private double rating; // eg: 4.5
        private String deliveryTime; // eg: 30-40 mins
    }



