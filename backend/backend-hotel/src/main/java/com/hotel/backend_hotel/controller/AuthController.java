package com.hotel.backend_hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.backend_hotel.dto.UserLoginDTO;
import com.hotel.backend_hotel.dto.UserRegisterDTO;
import com.hotel.backend_hotel.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173") // allow React to call
public class AuthController {
@Autowired private UserService userService;
// POST http://localhost:8080/api/auth/register
@PostMapping("/register")
public ResponseEntity register(@RequestBody UserRegisterDTO dto) {
return ResponseEntity.ok(userService.registerUser(dto));
}
// POST http://localhost:8080/api/auth/login
@PostMapping("/login")
public ResponseEntity login(@RequestBody UserLoginDTO dto) {
return ResponseEntity.ok(userService.loginUser(dto));
}
}
