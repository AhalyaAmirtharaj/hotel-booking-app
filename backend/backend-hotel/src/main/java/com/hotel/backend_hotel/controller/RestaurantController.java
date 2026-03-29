package com.hotel.backend_hotel.controller;

import com.hotel.backend_hotel.entity.MenuItem;
import com.hotel.backend_hotel.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")

public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @GetMapping("/restaurants")
    public List getAll() { return restaurantService.getAllRestaurants(); }
    @GetMapping("/restaurants/search")
    public List search(@RequestParam String cuisine) {
        return restaurantService.searchByCuisine(cuisine);
    }
    @GetMapping("/menu/{restaurantId}")
    public List getMenu(@PathVariable Long restaurantId) {
        return restaurantService.getMenu(restaurantId);
    }
    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant r) {
        return restaurantService.addRestaurant(r);
    }
    @PostMapping("/menu")
    public MenuItem addMenuItem(@RequestBody MenuItem item) {
        return restaurantService.addMenuItem(item);
    }
}

}
