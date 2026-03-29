package com.hotel.backend_hotel.service;

import com.hotel.backend_hotel.dto.OrderItemDTO;
import com.hotel.backend_hotel.dto.OrderRequestDTO;
import com.hotel.backend_hotel.entity.MenuItem;
import com.hotel.backend_hotel.entity.Order;
import com.hotel.backend_hotel.entity.Restaurant;
import com.hotel.backend_hotel.repository.MenuItemRepository;
import com.hotel.backend_hotel.repository.OrderRepository;
import com.hotel.backend_hotel.repository.RestaurantRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired private MenuItemRepository menuItemRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private RestaurantRepository restaurantRepository;
    @Autowired private EmailService emailService;
    // PLACE ORDER
    public Order placeOrder(OrderRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found!"));
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found!"));
// calculate total price
        double total = 0;
        for (OrderItemDTO item : dto.getItems()) {
            MenuItem menuItem = menuItemRepository.findById(item.getMenuItemId())
                    .orElseThrow(() -> new RuntimeException("Item not found!"));
            total += menuItem.getPrice() * item.getQuantity();
        }
// create and save order
        Order order = new Order();
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setTotalAmount(total);
        order.setDeliveryAddress(dto.getDeliveryAddress());
        order.setStatus("PLACED");
        order.setCreatedAt(LocalDateTime.now());
        Order saved = orderRepository.save(order);
// send email confirmation
        emailService.sendEmail(user.getEmail(),
                "Order Confirmed!",
                "Your order from " + restaurant.getName() + " is placed! Total: Rs." + total);
        return saved;
    }
    // CANCEL ORDER
    public Order cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found!"));
        order.setStatus("CANCELLED");
        return orderRepository.save(order);
    }
    // GET MY ORDERS
    public List getMyOrders(Long userId) {
        return orderRepository.findByUserId(userId);
}}
