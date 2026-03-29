package com.hotel.backend_hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotel.backend_hotel.dto.UserLoginDTO;
import com.hotel.backend_hotel.dto.UserRegisterDTO;
import com.hotel.backend_hotel.entity.User;
import com.hotel.backend_hotel.repository.UserRepository;

@Service
public class UserService {
@Autowired private UserRepository userRepository;
@Autowired private PasswordEncoder passwordEncoder;
@Autowired private EmailService emailService;
// REGISTER - save new user
public User registerUser(UserRegisterDTO dto) {
// check if email already used
if (userRepository.existsByEmail(dto.getEmail())) {
throw new RuntimeException("Email already registered!");
}
// create user
User user = new User();
user.setName(dto.getName());
user.setEmail(dto.getEmail());
user.setPassword(passwordEncoder.encode(dto.getPassword())); // encrypt
user.setPhone(dto.getPhone());
user.setAddress(dto.getAddress());
User saved = userRepository.save(user);
// send welcome email
emailService.sendEmail(saved.getEmail(),
"Welcome to Food Delivery!",
"Hi " + saved.getName() + "! Your account is ready. Start ordering!");
return saved;
}
// LOGIN - check email and password
public User loginUser(UserLoginDTO dto) {
User user = userRepository.findByEmail(dto.getEmail())
.orElseThrow(() -> new RuntimeException("User not found!"));
if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
throw new RuntimeException("Wrong password!");
}
return user;
}
}

