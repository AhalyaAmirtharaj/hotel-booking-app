package com.hotel.backend_hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RestaurantRepository extends JpaRepository {
    List findByCuisineContainingIgnoreCase(String cuisine);
}
