package com.hotel.backend_hotel.service;

import com.hotel.backend_hotel.entity.MenuItem;
import com.hotel.backend_hotel.entity.Restaurant;
import com.hotel.backend_hotel.repository.MenuItemRepository;
import com.hotel.backend_hotel.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Autowired
private RestaurantRepository restaurantRepository;
@Autowired private MenuItemRepository menuItemRepository;
public class RestaurantService {

    public List getAllRestaurants() {
        return restaurantRepository.findAll();
    }
    public List searchByCuisine(String cuisine) {
        return restaurantRepository.findByCuisineContainingIgnoreCase(cuisine);
    }
    public List getMenu(Long restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId);
    }
    public Restaurant addRestaurant(Restaurant r) {
        return restaurantRepository.save(r);
    }
    public MenuItem addMenuItem(MenuItem item) {
        return menuItemRepository.save(item);
    }
}


