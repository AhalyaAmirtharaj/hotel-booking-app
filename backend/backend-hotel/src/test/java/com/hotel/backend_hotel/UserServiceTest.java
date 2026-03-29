package com.hotel.backend_hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotel.backend_hotel.dto.UserLoginDTO;
import com.hotel.backend_hotel.dto.UserRegisterDTO;
import com.hotel.backend_hotel.entity.User;
import com.hotel.backend_hotel.service.UserService;

@SpringBootTest
public class UserServiceTest {
@Autowired private UserService userService;
// Test 1: Register a new user
@Test
public void testRegisterUser() {
UserRegisterDTO dto = new UserRegisterDTO();
dto.setName("Test User");
dto.setEmail("testfood@gmail.com");
dto.setPassword("test123");
dto.setPhone("9876543210");
dto.setAddress("Chennai");
User saved = userService.registerUser(dto);
// assertNotNull checks the result is not null
assertNotNull(saved.getId());
assertEquals("Test User", saved.getName());
System.out.println("Register Test PASSED! User ID = " + saved.getId());
}
// Test 2: Login with correct credentials
@Test
public void testLoginUser() {
UserLoginDTO dto = new UserLoginDTO();
dto.setEmail("testfood@gmail.com");
dto.setPassword("test123");
User loggedIn = userService.loginUser(dto);
assertNotNull(loggedIn);
assertEquals("testfood@gmail.com", loggedIn.getEmail());
System.out.println("Login Test PASSED!");
}
}

