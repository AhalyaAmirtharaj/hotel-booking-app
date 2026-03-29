package com.hotel.backend_hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository {
    List findByRestaurantId(Long restaurantId);

}
